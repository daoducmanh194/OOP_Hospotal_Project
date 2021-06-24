package database;

import java.sql.*;

public class ReturnDB {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public String returnIDFollowUsernamePassword(String inUsername, String inPassword, int choice) {
		String returnID = new String();
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			if(choice == 1) {
				String sql = "SELECT pid FROM patient WHERE (user_name, password) = (?, ?) ";
				
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, inUsername);
				statement.setString(2, inPassword);
				
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					returnID = result.getString("pid");
				}
				
				statement.close();
			}else if(choice == 2) {
				String sql = "SELECT did FROM doctor WHERE (user_name, password) = (?, ?) ";
				
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, inUsername);
				statement.setString(2, inPassword);
				
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					returnID = result.getString("did");
				}
				
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		}
		
		return returnID;
	}
}
