package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Patient;

public class testInsert {
	private static String jdbcURL = "jdbc:postgresql://localhost:5432/HealthCare";
	private static String username = "postgres";
	private static String password = "genkidao263"; 
	
	static Connection connection = null;
	static Statement statement = null;
	static Patient newP = new Patient(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
	
	public static void main(String[] args) {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgesql Server");
			
			// Add information to database
			String sql = "SELECT * FROM patient WHERE pid = 'BK47' ";
			
			statement = connection.createStatement();

			
			ResultSet result = statement.executeQuery(sql);

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
				
				// System.out.println(firstname+lastname);

				Patient p = new Patient(firstname, lastname, address, dob, gender, phonenumber, email,
						patientUsername, patientPassword, patientID, companyID, weight, height);
				// System.out.println(p.getFirstName() + p.getLastName());
				newP = p;
			}
			
			//new_patient = p;
			//System.out.println(new_patient.getFirstName());
			
			// statement.close();
		} catch (SQLException e) {
			System.out.println("Error when connecting to Postgesql server");
			e.printStackTrace();
		} 
		System.out.println(newP.getEnterpriseID());
		//return new_patient;
	}
}
