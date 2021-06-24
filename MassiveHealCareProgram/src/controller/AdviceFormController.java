package controller;

import java.io.IOException;
import java.text.ParseException;

import database.GetAdvice;
import database.GetDiagnostic;
import database.GetDoctorAdvice;
import database.SearchDBDoctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Doctor;
import model.Patient;
import view.Main;

public class AdviceFormController {
	
	@FXML
    private TextArea diagnostic;

    @FXML
    private TextArea advice;

    @FXML
    private Button backButton;

    @FXML
    private TextField patientName;

    @FXML
    private TextField patientAge;

    @FXML
    private TextField patientGender;

    @FXML
    private TextField patientPhone;

    @FXML
    private TextField patientAddress;

    @FXML
    private TextField doctorName;

    @FXML
    private TextField doctorSpecialization;

    @FXML
    private TextField doctorAge;

    @FXML
    private TextField doctorGender;

    @FXML
    private TextField doctorPhone;

    @FXML
    private TextField doctorEmail;
    
    @FXML
    private TextField testDate;
    
    protected static Patient p;
	public static void setPatient(Patient newP) {
		AdviceFormController.p = newP;
	}
	
	protected static String adviceDate;
	public static void setDate(String newDate) {
		AdviceFormController.adviceDate = newDate;
	}
	
	@FXML
	public void showInformation(ActionEvent e) throws IOException, ParseException {
		show();
	}
	
	private void show() throws IOException, ParseException {		
		// show information
		patientName.setText(p.getFirstName() + " " + p.getLastName());
		patientName.setEditable(false);
		patientAge.setText("20");
		patientAge.setEditable(false);
		patientGender.setText(p.getGender());
		patientGender.setEditable(false);
		patientPhone.setText(p.getPhoneNumber());
		patientPhone.setEditable(false);
		patientAddress.setText(p.getAddress());
		patientAddress.setEditable(false);
		
		// set date
		testDate.setText(adviceDate);
		testDate.setEditable(false);
		
		// call doctor who advice
		GetDoctorAdvice getDoc = new GetDoctorAdvice();
		String advDid = getDoc.getDIDAdv(p.getPatientID(), adviceDate);
		// System.out.println(advDid);
		SearchDBDoctor searchDoc = new SearchDBDoctor();
		Doctor d = searchDoc.searchFollowdDID(advDid);
		// doctor's information
		doctorName.setText(d.getFirstName() + " " + d.getLastName());
		doctorName.setEditable(false);
		doctorSpecialization.setText(d.getSpecialization());
		doctorSpecialization.setEditable(false);
		doctorAge.setText("39");
		doctorAge.setEditable(false);
		doctorGender.setText(d.getGender());
		doctorGender.setEditable(false);
		doctorPhone.setText("0" + String.valueOf(d.getPhoneNumber()));
		doctorPhone.setEditable(false);
		doctorEmail.setText(d.getEmail());
		doctorEmail.setEditable(false);
		
		// get diagnostic
		GetDiagnostic getDiag = new GetDiagnostic();
		String pDiag = getDiag.getPatientDiagnostic(p.getPatientID(), adviceDate);
		diagnostic.setText(pDiag);
		// get advices
		GetAdvice getAdv = new GetAdvice();
		String pAdv = getAdv.getPatientAdvice(p.getPatientID(), adviceDate);
		advice.setText(pAdv);
	}

    @FXML
    public void backToResult(ActionEvent event) throws IOException {
    	toResult();
    }
    
    private void toResult() throws IOException {
    	Main m = new Main();
    	m.changeScene("ResultForm.fxml");
    }

}
