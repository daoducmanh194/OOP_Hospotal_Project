package database;

import model.Patient;

import java.sql.*;


public class SearchDB {
	
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static Patient new_patient = new Patient(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
	
	public Patient searchFollowPID(String PID) {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find patient follow patient's id
			String sql = "SELECT * FROM patient WHERE pid = ? ";
						
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, PID);
			
			ResultSet result = statement.executeQuery();

			System.out.println("A new patient's information has been inserted!");
			
			while(result.next()) {
				String patientID = result.getString("pid");
				String companyID = result.getString("cid");
				String firstname = result.getString("f_name");
				String lastname = result.getString("l_name");
				String gender = result.getString("gender");
				Date dob = result.getDate("dob");
				int weight = result.getInt("weight");
				int height = result.getInt("height");
				int iphonenumber = result.getInt("phone_number");
				String phonenumber = String.valueOf(iphonenumber);
				String email = result.getString("email");
				String address = result.getString("address");
				String patientUsername = result.getString("user_name");
				String patientPassword = result.getString("password");

				Patient p = new Patient(firstname, lastname, address, dob, gender, phonenumber, email,
						patientUsername, patientPassword, patientID, companyID, weight, height);

				new_patient = p;
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return new_patient;
	}
}
