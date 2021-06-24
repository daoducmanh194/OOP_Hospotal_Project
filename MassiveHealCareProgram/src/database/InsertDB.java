package database;

import java.sql.*;

public class InsertDB {
	public void insert(String pid, String cid, String firstname, String lastname, String gender, int phonenumber,
			String email, String address, Date dob, String user_name, String upassword) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
		String username = "postgres";
		String password = "genkidao263";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Add information to database
			String sql = "INSERT INTO patient (pid, cid, f_name, l_name, gender, phone_number, email, address,  dob, user_name, password)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, pid);
			statement.setString(2, cid);
			statement.setString(3, firstname);
			statement.setString(4, lastname);
			statement.setString(5, gender);
			statement.setInt(6, phonenumber);
			statement.setString(7, email);
			statement.setString(8, address);
			statement.setDate(9, dob);
			statement.setString(10,  user_name);
			statement.setString(11,  upassword);
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("A new patient's information has been inserted!");
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
	}
}
