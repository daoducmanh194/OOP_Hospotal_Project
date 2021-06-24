package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateAdvice {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;

	
	public void updatePatientAdvice(String doctorAdvice, String pid, String mydate) throws ParseException {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to update diagnostic
			String sql = "UPDATE phieu_kham SET advice = (?) WHERE pid = (?) AND test_date = (?)";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, doctorAdvice);
			statement.setString(2, pid);
			java.util.Date new_date = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			java.sql.Date sDate = new java.sql.Date(new_date.getTime());
			statement.setDate(3, sDate);

			System.out.println("A new patient's advice has been inserted!");
			
			int result = statement.executeUpdate();
			
			if(result > 0) {
				System.out.println("Update advice sucessfully!");
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
	}
}
