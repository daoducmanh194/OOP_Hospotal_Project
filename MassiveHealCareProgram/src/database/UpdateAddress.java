package database;

import java.sql.*;

public class UpdateAddress {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public void updatePAddress(String address, String pid) {
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
				String sql = "UPDATE patient SET address = (?) WHERE pid = (?) ";
				
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, address);
				statement.setString(2, pid);

				
				int result = statement.executeUpdate();
				
				if(result > 0) {
					System.out.println("Update address sucessfully!");
				}
				
				statement.close();
			
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		}
		
	}
}
