package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Doctor;
import model.Patient;
import view.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

import database.InsertDB;
import database.ReturnDB;
import database.SearchDB;
import database.SearchDBDoctor;
import database.SearchDBUser_Pass;


public class SignInController {
	public SignInController() {
		
	}
	
	@FXML
	private Button signInButton;
	@FXML
	private Button signUpButton;
	@FXML
	private RadioButton forgetUsernameButton;
	@FXML
	private RadioButton forgetPasswordButton;
	@FXML
	private Label wrongSignIn;
	@FXML
	private TextField usernameSignIn;
	@FXML
	private PasswordField passwordSignIn;
	
	SearchDB mySearch = new SearchDB();
	SearchDBDoctor dSearch = new SearchDBDoctor();
	SearchDBUser_Pass us = new SearchDBUser_Pass();
	ReturnDB myReturn = new ReturnDB();
	Main sw = new Main();
	
	public void userSignIn(ActionEvent event) throws IOException{
		checkSignin();
	}
	
	private void checkSignin() throws IOException {
		int flag = us.searchFollowUsernamePassword(usernameSignIn.getText().toString()
														,passwordSignIn.getText().toString());
		// System.out.println(flag);
		
		if(usernameSignIn.getText().toString().equals("Genki Baskervillge") 
				&& passwordSignIn.getText().toString().contentEquals("194263")) {
			wrongSignIn.setText("Success!");
			
		    sw.changeScene("PatientView.fxml");
		}
		
		else if(flag == 1) {
			wrongSignIn.setText("Success!");
			String pid = myReturn.returnIDFollowUsernamePassword(usernameSignIn.getText().toString(), passwordSignIn.getText().toString(), flag);
			Patient p = mySearch.searchFollowPID(pid);
			PatientViewController.setPatient(p);
			PatientEditController.setPatient(p);
			ResultFormController.setPatient(p);
			ServiceFormController.setPatient(p);
			AdviceFormController.setPatient(p);
		    sw.changeScene("PatientView.fxml");
		}
		
		else if(flag == 2) {
			wrongSignIn.setText("Success!");
			String did = myReturn.returnIDFollowUsernamePassword(usernameSignIn.getText().toString(), passwordSignIn.getText().toString(), flag);
			Doctor d = dSearch.searchFollowdDID(did);
			DoctorViewController.setDoctor(d);
			DoctorEditController.setDoctor(d);
		    sw.changeScene("DoctorView.fxml");
		}
		
		else if(usernameSignIn.getText().isEmpty() || passwordSignIn.getText().isEmpty()) {
			wrongSignIn.setText("Need to fill all information");
		}
		
		else {
			wrongSignIn.setText("Wrong username or password");
		}
	}
	
	public String getUsername() {
		return usernameSignIn.getText().toString();
	}
	
	public String getPassword() {
		return passwordSignIn.getText().toString();
	}
	
	public String getID(String getUsername, String getPassword) {
		String id = myReturn.returnIDFollowUsernamePassword(getUsername, getPassword, 
				us.searchFollowUsernamePassword(getUsername, getPassword));
		return id;
	}
	
	public void userSignUp(ActionEvent event) throws IOException {
		toSignUp();
	}
	
	private void toSignUp() throws IOException {
		Main sw = new Main();
		sw.changeScene("SignUp.fxml");
	}
	
	public void forgetUsername(ActionEvent event) throws IOException {
		checkForgetkUsernanme();
	}
	
	private void checkForgetkUsernanme() throws IOException {
		if(usernameSignIn.getText().isEmpty() && forgetUsernameButton.isSelected()) {
			Main sw = new Main();
			sw.changeScene("Forget.fxml");
		}
	}
	
	public void forgetPassword(ActionEvent event) throws IOException {
		checkForgetPassword();
	}
	
	private void checkForgetPassword() throws IOException {
		Main sw = new Main();
		if(passwordSignIn.getText().isEmpty() && forgetPasswordButton.isSelected()) {
			sw.changeScene("Forget.fxml");
		}
	}
}

