package model;

import java.sql.Date;

public class Doctor extends User{
	private String doctorID;
	private String specialization;
	private int salary;

	public Doctor(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String username, String password, String doctorID) {
		super(firstName, lastName, address, dob, gender, phoneNumber, email, username, password);
		this.doctorID = doctorID;
	}

	public Doctor(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String username, String password, String doctorID, String specialization) {
		this(firstName, lastName, address, dob, gender, phoneNumber, email, username, password, doctorID);
		this.specialization = specialization;
	}

	public Doctor(String firstName, String lastName, String address, Date dob, String gender, String phoneNumber,
			String email, String username, String password, String doctorID, String specialization, int salary) {
		this(firstName, lastName, address, dob, gender, phoneNumber, email, username, password, doctorID, specialization);
		this.salary = salary;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
