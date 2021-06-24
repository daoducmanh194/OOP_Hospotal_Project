package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDBUser_Pass {
	
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public int searchFollowUsernamePassword(String pusername, String ppassword) {
		// boolean flag = false;
		int userChoice = 0;  // 0: start; 1: patient, 2: doctor
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// query for find patient's password follow user_name
			String patientSql = "SELECT password FROM patient WHERE user_name = ? ";
			// query for find docter's password follow user_name
			String doctorSql = "SELECT password FROM doctor WHERE user_name = ? ";
			
			PreparedStatement patientStatement = connection.prepareStatement(patientSql);
			PreparedStatement doctorStatement = connection.prepareStatement(doctorSql);
			
			patientStatement.setString(1, pusername);
			doctorStatement.setString(1, pusername);
			
			ResultSet patientResult = patientStatement.executeQuery();
			
			while(patientResult.next()) {
				String comparePassword = patientResult.getString("password");
				System.out.println(patientResult.getString("password"));
				if(comparePassword.equals(ppassword)) {
					userChoice = 1;
					// flag = true;
					System.out.println("Patient exist!");
				}else {
					userChoice = 0;
					// flag = false;
					System.out.println("Patient not exist!");
				}
			}
			
			patientStatement.close();
			
			ResultSet doctorResult = doctorStatement.executeQuery();
			
			while(doctorResult.next()) {
				String comparedPassword = doctorResult.getString("password");
				System.out.println(doctorResult.getString("password"));
				if(comparedPassword.equals(ppassword)) {
					userChoice = 2;
					// flag = true;
					System.out.println("Doctor exist!");
				}else {
					userChoice = 0;
					// flag = false;
					System.out.println("Doctor not exist!");
				}
			}
			
			doctorStatement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return userChoice;
	}
}
