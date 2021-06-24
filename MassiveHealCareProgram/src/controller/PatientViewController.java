package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Patient;
import view.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

import database.SearchDB;

import controller.SignInController;

public class PatientViewController {
	
	public PatientViewController() {
		
	}
	
	@FXML
	private TextField patientID;
	@FXML
	private TextField companyName;
	@FXML
	private TextField patientName;
	@FXML
	private TextField patientAge;
	@FXML
	private TextField patientGender;
	@FXML
	private TextField patientPhonenumber;
	@FXML
	private TextField patientEmail;
	@FXML
	private TextField patientAddress;
	
	@FXML
	private Button patientInfoButton;
	
	@FXML
	private Button patientServiceButton;

	@FXML
	private Button patientResultButton;
	@FXML
	private Button patientPaymentButton;
	@FXML
	private Button patientLogOutButton;
	
	
	
	protected static Patient p;
	public static void setPatient(Patient newP) {
		PatientViewController.p = newP;
	}
	
	@FXML
	public void showInformation(ActionEvent e) throws IOException {
		show();
	}
	
	private void show() throws IOException {		
		// show information
		patientID.setText(p.getPatientID());
		patientID.setEditable(false);
		companyName.setText("");
		companyName.setEditable(false);
		patientName.setText(p.getFirstName() + " " + p.getLastName());
		patientName.setEditable(false);
		patientAge.setText("20");
		patientAge.setEditable(false);
		patientGender.setText(p.getGender());
		patientGender.setEditable(false);
		patientPhonenumber.setText(p.getPhoneNumber());
		patientPhonenumber.setEditable(false);
		patientEmail.setText(p.getEmail());
		patientEmail.setEditable(false);
		patientAddress.setText(p.getAddress());
		patientAddress.setEditable(false);
	}
	
	
	public void patientEditInformation(ActionEvent e) throws IOException {
		chooseEditInformation();
	}
	
	private void chooseEditInformation() throws IOException {
		Main m0 = new Main();
		m0.changeScene("PatientEditView.fxml");
	}
	
	public void patientSelectService(ActionEvent e) throws IOException {
		chooseService();
	}
	
	private void chooseService() throws IOException {
		Main m = new Main();
		m.changeScene("ServiceFormView.fxml");
	}
	
	public void patientGetResult(ActionEvent e) throws IOException {
		getResult();
	}
	
	private void getResult() throws IOException {
		Main m = new Main();
		m.changeScene("ResultForm.fxml");
	}
	
	public void patientPay(ActionEvent e) throws IOException {
		payment();
	}
	
	private void payment() throws IOException {
		
	}
	
	public void patientLogOut(ActionEvent e) throws IOException {
		tryLogOut();
	}
	
	private void tryLogOut() throws IOException {
		Main m = new Main();
		m.changeScene("SignIn.fxml");
	}
}
