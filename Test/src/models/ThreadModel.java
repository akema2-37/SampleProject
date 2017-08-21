package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import publish.DatabaseConnector;
import publish.ThreaBean;

public class ThreadModel {

	private static final String MYTABLE1 = "EmployeeRight_master";//社員テーブル
	List<ThreaBean> beans = new ArrayList<>();


	//全ての人数を数える
	public int countRecord() {
		int n = 0;
		try (DatabaseConnector cn = DatabaseConnector.createDafultConnector();) {
			cn.open();
			cn.createStatement("select count(*) as cnt from " + MYTABLE1);
			ResultSet rs = cn.executeQuery();
			if (rs.next()) {
				n = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;

	}
	//ページ分けます
	public List<ThreaBean> selectAll(int limit,int offset) {
		try (DatabaseConnector cn = DatabaseConnector.createDafultConnector();) {
			cn.open();
			cn.createStatement(" select * from " + MYTABLE1 +" limit "+ limit + "offset "+offset );
			ResultSet rs = cn.executeQuery();
			while (rs.next()) {
				String id        = rs.getString("id");
				String name      = rs.getString("name");
				String plice     = rs.getString("plice");
				String phone     = rs.getString("phone");
				String biography =rs.getString("biography");
				ThreaBean bean = new ThreaBean();
				bean.setId(id);
				bean.setName(name);
				bean.setPlice(plice);
				bean.setPhone(phone);
				bean.setBiography(biography);
				beans.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return beans;
	}

	//検索条件で人を探す。
	public List<ThreaBean> select(int id ,String name,String plice,String phone,String biography){
		int indextt = 1;

		try (DatabaseConnector cn = DatabaseConnector.createDafultConnector();) {
			cn.open();
			StringBuilder sql = new StringBuilder(" select * from " + MYTABLE1 +" where 1 = 1 ");
			if(id != 0){
				sql.append(" AND id = ? ");
			}
			if(name != null && !name.isEmpty()){
				sql.append(" AND name like ? ");
			}
			if(plice!=null&& !plice.isEmpty()){
				sql.append(" AND plice like ? ");
			}
			if(phone!= null && !phone.isEmpty()){
				sql.append(" AND phone like ? ");
			}
			if(biography!=null && !biography.isEmpty()){
				sql.append(" AND biography like ? ");
			}

			PreparedStatement ps = cn.createStatement(sql.toString());

			if(id !=0){
				ps.setInt(indextt, id);
				indextt++;
			}
			if(name != null && !name.isEmpty()){
				ps.setString(indextt,"%"+name+"%");
				indextt++;
			}
			if(plice!=null && !plice.isEmpty()){
				ps.setString(indextt, "%"+plice+"%");
				indextt++;
			}
			if(phone!= null && !phone.isEmpty()){
				ps.setString(indextt, "%"+phone+"%");
				indextt++;
			}
			if(biography!=null && !biography.isEmpty()){
				ps.setString(indextt,"%"+biography+"%");
			}

			ResultSet rs =  ps.executeQuery();

			while (rs.next()) {
				String id1    = rs.getString("id");
				String name1  = rs.getString("name");
				String plice1 = rs.getString("plice");
				String phone1 = rs.getString("phone");
				String biography1 = rs.getString("biography");
				ThreaBean bean = new ThreaBean();
				bean.setId(id1);
				bean.setName(name1);
				bean.setPlice(plice1);
				bean.setPhone(phone1);
				bean.setBiography(biography1);
				beans.add(bean);

			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return beans;

	}
	public boolean insert(int id,String name,String plice,String phone,String biography){
		if(id==0||name == null||name.isEmpty()||plice==null||plice.isEmpty()||phone== null||phone.isEmpty()){
			return false;
		}
		try(DatabaseConnector cn = DatabaseConnector.createDafultConnector();){
			cn.open();
			PreparedStatement st = cn.createStatement("insert into "+MYTABLE1+" (id,name,plice,phone,biography) values(?,?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, plice);
			st.setString(4, phone);
			st.setString(5, biography);
			cn.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;

	}
	public List<ThreaBean>idAll(int cheakid){
		ThreaBean bean = new ThreaBean();
		try(DatabaseConnector cn = DatabaseConnector.createDafultConnector();){
			cn.open();
			PreparedStatement st = cn.createStatement("select * from "+MYTABLE1+" where id = ?");
			st.setInt(1, cheakid);
			ResultSet rs = cn.executeQuery();
			if(rs.next()) {
				String id        = rs.getString("id");
				String name      = rs.getString("name");
				String plice     = rs.getString("plice");
				String phone     = rs.getString("phone");
				String biography = rs.getString("biography");
				bean.setId(id);
				bean.setName(name);
				bean.setPlice(plice);
				bean.setPhone(phone);
				bean.setBiography(biography);
				beans.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return beans;
	}

	public boolean update(String name,String plice,String phone,String biography,int id){
		if(name==null||name.isEmpty()||plice==null||plice.isEmpty()||phone==null||phone.isEmpty()||biography==null||biography.isEmpty()){
			return false;
		}
		try (DatabaseConnector cn = DatabaseConnector.createDafultConnector();){
				cn.open();
				PreparedStatement st = cn.createStatement("update "+MYTABLE1+" set name = ?,plice = ?,phone = ?,biography = ?  where id = ?");
				st.setString(1, name);
				st.setString(2, plice);
				st.setString(3, phone);
				st.setString(4, biography);
				st.setInt(5, id);
				cn.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;

	}
	public boolean delete(int id){
		try(DatabaseConnector cn = DatabaseConnector.createDafultConnector();){
			cn.open();
			PreparedStatement st = cn.createStatement("delete from "+MYTABLE1+" where id = ?");
			st.setInt(1, id);
			cn.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}




}
