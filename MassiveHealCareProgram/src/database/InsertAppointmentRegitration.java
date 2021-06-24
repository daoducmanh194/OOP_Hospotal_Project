package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class InsertAppointmentRegitration {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	
	public void insertRegistration(String pid, String mydate) throws ParseException {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "INSERT INTO phieu_kham(pkid, pid, test_date) VALUES (?, ?, ?) ";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(2, pid);
			java.util.Date new_date = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			java.sql.Date sDate = new java.sql.Date(new_date.getTime());
			statement.setDate(3, sDate);
			String[] ymd = mydate.split("-");
			String tmp =  ymd[2] + ymd[1] + ymd[0].subSequence(2, 4) + pid;
			statement.setString(1, tmp);

			System.out.println("A new appointment has been inserted!");
			
			int result = statement.executeUpdate();
			
			if(result > 0) {
				System.out.println("Insert registration sucessfully!");
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
	}
}
