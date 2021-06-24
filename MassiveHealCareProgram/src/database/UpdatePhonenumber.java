package database;

import java.sql.*;

public class UpdatePhonenumber {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public void updatePPhonenumber(String phone, String pid) {
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
				String sql = "UPDATE patient SET phone_number = (?) WHERE pid = (?) ";
				
				statement = connection.prepareStatement(sql);
				
				int phonenumber = Integer.parseInt(phone);
				statement.setInt(1, phonenumber);
				statement.setString(2, pid);

				
				int result = statement.executeUpdate();
				
				if(result > 0) {
					System.out.println("Update phone number sucessfully!");
				}
				
				statement.close();
			
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		}
		
	}
}
