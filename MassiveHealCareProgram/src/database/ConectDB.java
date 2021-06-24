package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConectDB {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
		String username = "postgres";
		String password = "genkidao263";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			// Add information to database
			String sql = "INSERT INTO patient (pid, cid, f_name, l_name, gender, phone_number, email, yob) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						
			PreparedStatement statement = connection.prepareStatement(sql);
						
			statement.setString(1, "HBT999");
			statement.setString(2, "BK");
			statement.setString(3, "Winson");
			statement.setString(4, "Churckhill");
			statement.setString(5, "M");
			statement.setInt(6, 1234635543);
			statement.setString(7, "winsonhill@gmail.com");
			statement.setInt(8, 1945);
						
			int rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("A new patient's information has been inserted!");
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		}
	}
}

