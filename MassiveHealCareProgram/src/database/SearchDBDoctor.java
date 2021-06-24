package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Doctor;

public class SearchDBDoctor {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static Connection connection1 = null;
	static PreparedStatement statement = null;
	static Doctor new_doctor = new Doctor(null, null, null, null, null, null, null, null, null, null, null, 0);
	
	public Doctor searchFollowdDID(String DID) {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "SELECT * FROM doctor WHERE did = ? ";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, DID);
			
			ResultSet result = statement.executeQuery();

			System.out.println("A new doctor's information has been inserted!");
			
			while(result.next()) {
				String doctorID = result.getString("did");
				String specialization = result.getString("specialization");
				String firstname = result.getString("f_name");
				String lastname = result.getString("l_name");
				String gender = result.getString("gender");
				Date dob = result.getDate("dob");
				int salary = result.getInt("salary");
				int iphonenumber = result.getInt("phone_number");
				String phonenumber = String.valueOf(iphonenumber);
				String email = result.getString("email");
				String address = result.getString("address");
				String doctorUsername = result.getString("user_name");
				String doctorPassword = result.getString("password");

				Doctor d = new Doctor(firstname, lastname, address, dob, gender, phonenumber,
						 email, doctorUsername, doctorPassword, doctorID, specialization, salary);

				new_doctor = d;
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return new_doctor;
	}
}
