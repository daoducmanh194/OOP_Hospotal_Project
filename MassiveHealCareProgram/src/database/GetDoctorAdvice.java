package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class GetDoctorAdvice {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static String getDid = null;

	
	public String getDIDAdv(String pid, String mydate) throws ParseException {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "select did from phieu_kham where pid = ? and test_date = ?";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, pid);
			java.util.Date new_date = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			java.sql.Date sDate = new java.sql.Date(new_date.getTime());
			statement.setDate(2, sDate);
			
			ResultSet result = statement.executeQuery();

			System.out.println("A doctor's found");
			
			while(result.next()) {
				String doctorID = result.getString("did");
				getDid = doctorID;
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return getDid;
	}

}
