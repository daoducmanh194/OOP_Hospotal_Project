package model;

import java.sql.Date;

public class Patient extends User{
	private String patientID;
	private String enterpriseID;
	private int weight;
	private int height;
	private int yob;
	

	public Patient(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String patientID, String username, String password) {
		super(firstName, lastName, address, dob, gender, phoneNumber, email, username, password);
		this.patientID = patientID;
	}
	
	
	
	public Patient(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String patientID, String username, String password, int weight, int height) {
		this(firstName, lastName, address, dob, gender, phoneNumber, email, username, password, patientID);
		this.weight = weight;
		this.height = height;
	}

	
	public Patient(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String patientID, String username, String password, String enterpriseID, int weight, int height) {
		this(firstName, lastName, address, dob, gender, phoneNumber, email, username, password, patientID, weight, height);
		this.enterpriseID = enterpriseID;

	}


	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	

	public String getEnterpriseID() {
		return enterpriseID;
	}


	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
