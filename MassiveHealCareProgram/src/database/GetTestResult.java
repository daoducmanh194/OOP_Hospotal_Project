package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Test;

public class GetTestResult {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static Test t = new Test(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	
	public Test getTestFromPidDate(String pid, String mydate) throws ParseException {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "select phieu_kham.test_date, xet_nghiem.* "
					+ "from phieu_kham join xet_nghiem on (phieu_kham.pkid = xet_nghiem.pkid)"
					+ "where phieu_kham.pid = ? and phieu_kham.test_date = ? ";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, pid);
			java.util.Date new_date = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			java.sql.Date sDate = new java.sql.Date(new_date.getTime());
			statement.setDate(2, sDate);
			
			ResultSet result = statement.executeQuery();

			System.out.println("A new patient's information has been inserted!");
			
			while(result.next()) {
				int hgsab = result.getInt("hgsab");
				String hcv = result.getString("hcv");
				int afp = result.getInt("afp");
				int ure = result.getInt("ure");
				int nse = result.getInt("nse");
				int cyfra = result.getInt("cyfra");
				int ca125 = result.getInt("ca125");
				int psa = result.getInt("psa");
				int aslo = result.getInt("aslo");
				int ft3 = result.getInt("ft3");
				int plt = result.getInt("plt");
				String pkid = result.getString("pkid");
				

				Test temp = new Test(hgsab, hcv, afp, ure, nse, cyfra, ca125, psa, aslo, ft3, plt, pkid);

				t = temp;
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return t;
	}
}
