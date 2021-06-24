package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Doctor;

import view.Main;

public class DoctorViewController {
	
	 @FXML
	 private Button doctorViewButton;

	 @FXML
	 private Button doctorEditButton;

	 @FXML
	 private Button doctorLogOutButton;

	 @FXML
	 private Button doctorSalaryButton;

	 @FXML
	 private TextField doctorID;

	 @FXML
	 private TextField doctorSpecialization;

	 @FXML
	 private TextField doctorName;

	 @FXML
	 private TextField doctorAge;

	 @FXML
	 private TextField doctorGender;

	 @FXML
	 private TextField doctorPhonenumber;

	 @FXML
	 private TextField doctorEmail;

	 @FXML
	 private TextField doctorAddress;
	 	 
	 
	protected static Doctor d;
	public static void setDoctor(Doctor newD) {
		DoctorViewController.d = newD;
	}
	
	public void showInformation(ActionEvent e) throws IOException {
		show();
	}
	
	private void show() throws IOException {		
		// show information
		doctorID.setText(d.getDoctorID());
		doctorID.setEditable(false);
		doctorSpecialization.setText(d.getSpecialization());
		doctorSpecialization.setEditable(false);
		doctorName.setText(d.getFirstName() + " " + d.getLastName());
		doctorName.setEditable(false);
		doctorAge.setText("39");
		doctorAge.setEditable(false);
		doctorGender.setText(d.getGender());
		doctorGender.setEditable(false);
		doctorPhonenumber.setText(d.getPhoneNumber());
		doctorPhonenumber.setEditable(false);
		doctorEmail.setText(d.getEmail());
		doctorEmail.setEditable(false);
		doctorAddress.setText(d.getAddress());
		doctorAddress.setEditable(false);
	}


	 public void doctorEditResult(ActionEvent event) throws IOException {
		 toEdit();
	 }
	 
	 private void toEdit() throws IOException {
		 Main m = new Main();
		 m.changeScene("EditInputView.fxml");
	 }


	 public void doctorLogOut(ActionEvent event) throws IOException {
		 LogOut();
	 }
	 
	 private void LogOut() throws IOException {
		 Main m = new Main();
		 m.changeScene("SignIn.fxml");
	 }


	 public void doctorViewPatient(ActionEvent event) throws IOException {
		 toPatientList();
	 }
	 
	 private void toPatientList() throws IOException {
		 Main m = new Main();
		 m.changeScene("PatientListView.fxml");
	 }


	 public void doctorViewSalary(ActionEvent event) throws IOException {
		 viewSalary();
	 }
	 
	 private void viewSalary() throws IOException{
		 JOptionPane.showMessageDialog(null, "Monthly salary: " + d.getSalary());
	 }
}
