package publish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector implements AutoCloseable {

	// 各自の環境に合わせて入力
	private static final String defaultUrl   = "jdbc:postgresql://localhost:5432/postgres";//SQLのURLとデータ名
	private static final String defaultUser  = "postgres";
	private static final String defualtPass  = "postgres";

	private String url;
	private String user;
	private String pass;

	private Connection              cn;
	private List<PreparedStatement> sts;
	private List<ResultSet>         rss;

	public static DatabaseConnector createDafultConnector(){
		DatabaseConnector db = new DatabaseConnector();
		try{
			db.initializeDefault();
		}catch(InstantiationException | IllegalAccessException  | ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
		return db;
	}
	private DatabaseConnector(){
		this.url  = "";
		this.user = "";
		this.pass = "";
		this.cn   = null;
		this.sts  = null;
		this.rss  = null;
	}
	  private void initializeDefault() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		    Class.forName("org.postgresql.Driver").newInstance();
		    this.url  = defaultUrl;
		    this.user = defaultUser;
		    this.pass = defualtPass;
	}
	  public Connection open() {//データベースサーバーへ接続
		    Connection cn;
		    try {
		      cn = DriverManager.getConnection(this.url, this.user, this.pass);
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    this.cn = cn;
		    return cn;
		  }
	  public Connection getConnection() {
		    return this.cn;
		  }
	  public PreparedStatement createStatement(String sql)
		      throws SQLException {
		    if(this.sts == null) {
		      this.sts = new ArrayList<PreparedStatement>();
		    }
		    PreparedStatement st = this.cn.prepareStatement(sql);
		    this.sts.add(st);
		    return st;
		  }
	  public ResultSet executeQuery(PreparedStatement st)
		      throws SQLException {
		    if(st == null) {
		      throw new IllegalStateException();
		    }
		    if(this.rss == null) {
		      this.rss = new ArrayList<ResultSet>();
		    }
		    ResultSet rs = st.executeQuery();
		    this.rss.add(rs);
		    return rs;
		  }
	  public ResultSet executeQuery()
		      throws SQLException {
		    if(this.sts.isEmpty()) {
		      throw new IllegalStateException();
		    }
		    return this.executeQuery(this.sts.get(this.sts.size()-1));
		  }
	  public int executeUpdate(PreparedStatement st)
		      throws SQLException {
		    if(st == null) {
		      throw new IllegalStateException();
		    }
		    return st.executeUpdate();
		  }
	  public int executeUpdate()
		      throws SQLException {
		    if(this.sts.isEmpty()) {
		      throw new IllegalStateException();
		    }
		    return this.executeUpdate(this.sts.get(this.sts.size()-1));
		  }
	  public boolean isOpen() {
		    return this.cn != null;
		  }


	@Override
	public void close() {
	    if(this.rss != null) {
	      for(ResultSet rs : this.rss) {
	        try {
	          if(rs.isClosed() == false) {
	            rs.close();
	          }
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    if(this.sts != null) {
	      for(PreparedStatement st : this.sts) {
	        try {
	          if(st.isClosed() == false) {
	            st.close();
	          }
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    try {
	      if(this.cn != null && this.cn.isClosed() == false) {
	        this.cn.close();
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    this.cn = null;
	  }
	}