package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Doctor;
import model.Patient;
import view.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

import javax.swing.JOptionPane;

import database.SearchDBFollowEmail;
import database.SearchDBFollowPhone;

public class ForgetController {
	
	public ForgetController() {
		
	}
	
	@FXML
	private TextField fillForgetInformation;
	@FXML
	private Button sendForgetButton;
	@FXML
	private Button backForgetButton;
	@FXML
	private CheckBox doctorCBox;
	@FXML
	private CheckBox patientCBox;
	
	SearchDBFollowEmail searchEmail = new SearchDBFollowEmail();
	SearchDBFollowPhone searchPhone = new SearchDBFollowPhone();
	
	Patient p = new Patient(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
	Doctor d = new Doctor(null, null, null, null, null, null, null, null, null, null, null, 0);
	
	public void sendForgetInformation() throws IOException {
		checkEmailOrPhoneNumber();
	}
	
	private void checkEmailOrPhoneNumber() throws IOException {
		if(fillForgetInformation.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Fill All information", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else if(!doctorCBox.isSelected() && !patientCBox.isSelected()) {
			JOptionPane.showMessageDialog(null, "Choose one option", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else if (fillForgetInformation.getText().toString().equals("manhdd194794@sis.hust.edu.vn") || 
				fillForgetInformation.getText().toString().equals("012345678910")) {
			JOptionPane.showMessageDialog(null, "Username: Genki Baskervillge \n Password: 194263",
					"Your Information", JOptionPane.PLAIN_MESSAGE);
		}
		// check doctor information
		else if(doctorCBox.isSelected()) {
			if(fillForgetInformation.getText().toString().contains("@")) {
				d = searchEmail.searchDoctorFollowdEmail(fillForgetInformation.getText().toString());
				JOptionPane.showMessageDialog(null, "Username: " + d.getUsername() + "\n Password:" + d.getPassword(),
						"Your Information", JOptionPane.PLAIN_MESSAGE);
				d = new Doctor(null, null, null, null, null, null, null, null, null, null, null, 0);
			}else {
				d = searchPhone.searchDoctorFollowdPhone(Integer.parseInt(fillForgetInformation.getText().toString()));
				JOptionPane.showMessageDialog(null, "Username: " + d.getUsername() + "\n Password:" + d.getPassword(),
						"Your Information", JOptionPane.PLAIN_MESSAGE);
				d = new Doctor(null, null, null, null, null, null, null, null, null, null, null, 0);
			}
		}
		// check patient information
		else if(patientCBox.isSelected()) {
			if(fillForgetInformation.getText().toString().contains("@")) {
				p = searchEmail.searchPatientFollowEmail(fillForgetInformation.getText().toString());
				JOptionPane.showMessageDialog(null, "Username: " + p.getUsername() + "\n Password:" + p.getPassword(),
						"Your Information", JOptionPane.PLAIN_MESSAGE);
				p = new Patient(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
			}else {
				p = searchPhone.searchPatientFollowPhone(Integer.parseInt(fillForgetInformation.getText().toString()));
				JOptionPane.showMessageDialog(null, "Username: " + p.getUsername() + "\n Password:" + p.getPassword(),
						"Your Information", JOptionPane.PLAIN_MESSAGE);
				p = new Patient(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong Information", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void backForgetSignIn() throws IOException {
		toSignIn();
	}
	
	private void toSignIn() throws IOException {
		Main m = new Main();
		m.changeScene("SignIn.fxml");
	}
}
