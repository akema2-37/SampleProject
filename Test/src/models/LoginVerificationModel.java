package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;

import publish.DatabaseConnector;

public class LoginVerificationModel {

	public String sha256(String password) throws NoSuchAlgorithmException{
		byte[] cipher;

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		cipher = md.digest();
		StringBuilder sb = new StringBuilder(2 *cipher.length);
		for(byte b : cipher){
			sb.append(String.format("%02x", b&0xff));
		}
		return sb.toString();

	}
	//入力判断
	public boolean verify(String name, String password) {
		if (name == null || password == null) {
			return false;
		}
		try (DatabaseConnector cn = DatabaseConnector.createDafultConnector();) {

			String hashedPassword = sha256(password);
			cn.open();
			PreparedStatement ps = cn.createStatement(" select * from Employee_master where name = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, hashedPassword);
			ps.executeQuery();

//			return ps.getResultSet().next();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
