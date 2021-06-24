package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import database.SearchDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Patient;
import view.Main;

public class EditInputController {
	
    @FXML
    private TextField patientIDText;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    public void toDoctorView(ActionEvent event) throws IOException {
    	returnToView();
    }
    
    private void returnToView() throws IOException {
    	Main m = new Main();
    	m.changeScene("DoctorView.fxml");
    }

    @FXML
    public void toEditForm(ActionEvent event) throws IOException {
    	Main m = new Main();
    	SearchDB sDB = new SearchDB();
    	if(!patientIDText.getText().toString().isEmpty()) {
    		Patient p = sDB.searchFollowPID(patientIDText.getText().toString());
    		DoctorEditController.setPatient(p);
    		m.changeScene("DoctorEditView.fxml");
    	}else {
    		JOptionPane.showMessageDialog(null, "Please fill the text!", "Warning", JOptionPane.WARNING_MESSAGE);
    	}

    }

}
