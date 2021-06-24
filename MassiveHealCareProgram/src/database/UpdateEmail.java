package database;

import java.sql.*;

public class UpdateEmail {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public void updatePEmail(String email, String pid) {
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
				String sql = "UPDATE patient SET email = (?) WHERE pid = (?) ";
				
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, email);
				statement.setString(2, pid);

				
				int result = statement.executeUpdate();
				
				if(result > 0) {
					System.out.println("Update email sucessfully!");
				}
				
				statement.close();
			
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		}
		
	}
}
