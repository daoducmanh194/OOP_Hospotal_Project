package database;

import model.Patient;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReturnAllPatientMale {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private String username = "postgres";
	private String password = "genkidao263"; 
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ObservableList<Patient> listPatient = FXCollections.observableArrayList();
	
	public ObservableList<Patient> allPatientMale() {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Query to find all patient in database
			String sql = "SELECT * FROM patient WHERE gender = 'M' ";
						
			statement = connection.prepareStatement(sql);
			
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

				listPatient.add(p);
			}
			
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		return listPatient;
	}
}
