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
import view.Main;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import database.InsertDB;

public class SignUpController {
	
	public SignUpController() {
		
	}
	
	@FXML
	private TextField firstnameSignUp;
	@FXML
	private TextField lastnameSignUp;
	@FXML
	private TextField yearSignUp;
	@FXML
	private TextField monthSignUp;
	@FXML
	private TextField dateSignUp;
	@FXML
	private TextField phonenumberSignUp;
	@FXML
	private TextField emailSignUp;
	@FXML
	private TextField addressSignUp;
	@FXML
	private TextField usernameSignUp;
	@FXML
	private PasswordField passwordSignUp;
	@FXML
	private PasswordField passwordConfirmedSignUp;
	@FXML
	private RadioButton maleButton;
	@FXML
	private RadioButton femaleButton;
	
	public void submitSignUp() throws IOException {
		checkSignUp();
	}
	
	private void checkSignUp() throws IOException {
		if(firstnameSignUp.getText().isEmpty() || lastnameSignUp.getText().isEmpty() || yearSignUp.getText().isEmpty() ||
				monthSignUp.getText().isEmpty() || dateSignUp.getText().isEmpty() || phonenumberSignUp.getText().isEmpty() ||
				emailSignUp.getText().isEmpty() || addressSignUp.getText().isEmpty() || usernameSignUp.getText().isEmpty() ||
				passwordSignUp.getText().isEmpty() || passwordConfirmedSignUp.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Fill All information", "Warning", JOptionPane.WARNING_MESSAGE);
			
		} else if(!passwordConfirmedSignUp.getText().equals(passwordSignUp.getText())) {
			JOptionPane.showMessageDialog(null, "Wrong password signed up!", "Warning", JOptionPane.WARNING_MESSAGE);
			
		} else if(maleButton.isSelected() && femaleButton.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please choose one option for gender!", "Warning", JOptionPane.WARNING_MESSAGE);
			
		} else if(!maleButton.isSelected() && !femaleButton.isSelected()) {
			JOptionPane.showMessageDialog(null, "Choose one option for gender!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Submit successfully!");
			String firstname = firstnameSignUp.getText().toString();
			String lastname = lastnameSignUp.getText().toString();
			String syear = yearSignUp.getText().toString();
			int year = Integer.parseInt(syear);
			String smonth = monthSignUp.getText().toString();
			int month = Integer.parseInt(smonth);
			String sdate = dateSignUp.getText().toString();
			int date = Integer.parseInt(sdate);
			Date dob = new Date(year, month, date);
			String sphonenumber = phonenumberSignUp.getText().toString();
			int phonenumber = Integer.parseInt(sphonenumber);
			
			String email = emailSignUp.getText().toString();
			String address = addressSignUp.getText().toString();
			String username = usernameSignUp.getText().toString();
			String password = passwordSignUp.getText().toString();
			
			String gender = new String();
			if (maleButton.isSelected()) {
				gender = "M";
			} else if (femaleButton.isSelected()){
				gender = "F";
			}
			
			// random password
			ArrayList<String> areaCode = new ArrayList<String>();
			areaCode.add("BK"); 
			areaCode.add("HBT");
			areaCode.add("HN");
			Random generator = new Random();
			int code = generator.nextInt(3);
			int value = generator.nextInt(100) + 1;
			String pid = areaCode.get(code) + Integer.toString(value);
			String cid = areaCode.get(code);
			
			JOptionPane.showMessageDialog(null, "Your username is: "  + username + "\nYour ID as password is: " + password);
			// save to database
			InsertDB insert = new InsertDB();
			insert.insert(pid, cid, firstname, lastname, gender, phonenumber, email, address, dob, username, password);
		}
	}
	
	public void backSignUpSignIn() throws IOException {
		toSignIn();
	}
	
	private void toSignIn() throws IOException {
		Main m = new Main();
		m.changeScene("SignIn.fxml");
	}
}
