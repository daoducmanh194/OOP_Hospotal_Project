package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.AnGynlogy;

public class GetAnGynlogyResult {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static AnGynlogy ag = new AnGynlogy(null, null, null);
	
	public AnGynlogy getAnGynlogyFromPidDate(String pid, String mydate) throws ParseException {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "select phieu_kham.test_date, kham_san.* "
					+ "from phieu_kham join kham_san on (phieu_kham.pkid = kham_san.pkid)"
					+ "where phieu_kham.pid = ? and phieu_kham.test_date = ? ";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, pid);
			java.util.Date new_date = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			java.sql.Date sDate = new java.sql.Date(new_date.getTime());
			statement.setDate(2, sDate);
			
			ResultSet result = statement.executeQuery();

			System.out.println("A new patient's information has been inserted!");
			
			while(result.next()) {
				String nam = result.getString("nam_khoa");
				String nu = result.getString("phu_khoa");
				String pkid = result.getString("pkid");
				

				AnGynlogy curag = new AnGynlogy(nam, nu, pkid);

				ag = curag;
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return ag;
	}
}
