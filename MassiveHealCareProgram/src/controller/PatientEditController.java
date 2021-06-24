package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import database.UpdateAddress;
import database.UpdateEmail;
import database.UpdatePhonenumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Patient;
import view.Main;

public class PatientEditController {
	
	@FXML
    private TextField resetAddress;

    @FXML
    private TextField resetEmail;

    @FXML
    private TextField resetPhone;

    @FXML
    private Button resetButton;
    
    protected static Patient p;
	public static void setPatient(Patient newP) {
		PatientEditController.p = newP;
	}

    @FXML
    void resetInformation(ActionEvent event) throws IOException{
    	// Update information
    	if(resetAddress.getText().isEmpty() && resetEmail.getText().isEmpty() && resetPhone.getText().isEmpty()) {
    		// warning
    		JOptionPane.showMessageDialog(null, "You don't change any information", "Warning", JOptionPane.WARNING_MESSAGE);
    		
    	} else if(!resetAddress.getText().isEmpty()) {
    		// Update address
    		UpdateAddress upAdd = new UpdateAddress();
    		upAdd.updatePAddress(resetAddress.getText().toString(), p.getPatientID());
    	} else if(!resetEmail.getText().isEmpty()) {
    		// Update email
    		UpdateEmail upMail = new UpdateEmail();
    		upMail.updatePEmail(resetEmail.getText().toString(), p.getPatientID());
    	} else if(!resetPhone.getText().isEmpty()){
    		// Update Phone number
    		UpdatePhonenumber upPhone = new UpdatePhonenumber();
    		upPhone.updatePPhonenumber(resetPhone.getText().toString(), p.getPatientID());
    	}
    	
    	// Return to PatientView
    	Main m = new Main();
    	m.changeScene("PatientView.fxml");
    }


}
