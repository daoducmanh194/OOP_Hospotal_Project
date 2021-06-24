package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import database.InsertAppointmentAnGynlogy;
import database.InsertAppointmentOstetric;
import database.InsertAppointmentRegitration;
import database.InsertAppointmentSurgical;
import database.InsertAppointmentTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Patient;
import view.Main;

public class ServiceFormController {
	
    @FXML
    private Button sendButton;

    @FXML
    private DatePicker obstetricDate;

    @FXML
    private DatePicker surgicalDate;

    @FXML
    private DatePicker androGynDate;

    @FXML
    private DatePicker testDate;

    @FXML
    private CheckBox obstetricCBox;

    @FXML
    private CheckBox surgicalCBox;

    @FXML
    private CheckBox androGynCBox;

    @FXML
    private CheckBox testCBox;

    @FXML
    private TextArea symptomTextArea;

    @FXML
    private RadioButton supersonicRButton;

    @FXML
    private RadioButton xrayRButton;

    @FXML
    private TextField setObsDate;

    @FXML
    private TextField setSurDate;

    @FXML
    private TextField setAndroGynDate;

    @FXML
    private TextField setTestDate;

    @FXML
    private TextField obsPay;

    @FXML
    private TextField surPay;

    @FXML
    private TextField androGynPay;

    @FXML
    private TextField testPay;

    @FXML
    private TextField totalPay;
    
    @FXML
    private Button backButton;
    
    InsertAppointmentRegitration reg = new InsertAppointmentRegitration();
	InsertAppointmentOstetric os = new InsertAppointmentOstetric();
	InsertAppointmentSurgical sur = new InsertAppointmentSurgical();
	InsertAppointmentAnGynlogy ag = new InsertAppointmentAnGynlogy();
	InsertAppointmentTest t = new InsertAppointmentTest();
    
    protected static Patient p;
	public static void setPatient(Patient newP) {
		ServiceFormController.p = newP;
	}

    @FXML
    public void sendRegistrationObstetric(ActionEvent event) throws IOException, ParseException{
    	sendObstetric();
    }
    
    private void sendObstetric( ) throws IOException, ParseException{
    	// insert obstetric
    	if(obstetricCBox.isSelected() && !obstetricDate.getValue().toString().isEmpty()) {
    		reg.insertRegistration(p.getPatientID(), obstetricDate.getValue().toString());
    		os.insertOstetric(p.getPatientID(), obstetricDate.getValue().toString());
    		setObsDate.setText(obstetricDate.getValue().toString());
    	}
    	
    	
    }
    
    @FXML
    public void sendRegistrationSurgical(ActionEvent event) throws IOException, ParseException{
    	sendSurgical();
    }
    
    private void sendSurgical() throws IOException, ParseException {
    	// insert surgical
    	if(surgicalCBox.isSelected() && !surgicalDate.getValue().toString().isEmpty()) {
    		if(surgicalDate.getValue().toString().equals(obstetricDate.getValue().toString())) {
    			sur.insertSurgiacal(p.getPatientID(), obstetricDate.getValue().toString());
    			setSurDate.setText(obstetricDate.getValue().toString());
    		}else {
    			reg.insertRegistration(p.getPatientID(), surgicalDate.getValue().toString());
        		sur.insertSurgiacal(p.getPatientID(), surgicalDate.getValue().toString());
        		setSurDate.setText(surgicalDate.getValue().toString());
    		}
    	}
    }
    
    @FXML
    public void sendRegistrationAndroGynlogy(ActionEvent event) throws IOException, ParseException{
    	sendAndroGynlogy();
    }
    
    private void sendAndroGynlogy() throws IOException, ParseException {
    	// insert angynlogy
    	if(androGynCBox.isSelected() && !androGynDate.getValue().toString().isEmpty()) {
    		if(androGynDate.getValue().toString().equals(obstetricDate.getValue().toString())) {
    			ag.insertAnGynlogy(p.getPatientID(), obstetricDate.getValue().toString());
    			setAndroGynDate.setText(obstetricDate.getValue().toString());
    		}else if(androGynDate.getValue().toString().equals(surgicalDate.getValue().toString())) {
    			ag.insertAnGynlogy(p.getPatientID(), surgicalDate.getValue().toString());
    			setAndroGynDate.setText(surgicalDate.getValue().toString());
    		}else {
    			reg.insertRegistration(p.getPatientID(), androGynDate.getValue().toString());
    			ag.insertAnGynlogy(p.getPatientID(), androGynDate.getValue().toString());
    			setAndroGynDate.setText(androGynDate.getValue().toString());
    		}
    	}
    }
    
    @FXML
    public void sendRegistrationTest(ActionEvent event) throws IOException, ParseException{
    	sendTest();
    }
    
    private void sendTest() throws IOException, ParseException {
    	// insert test
    	if(testCBox.isSelected() && !testDate.getValue().toString().isEmpty()) {
    		if(testDate.getValue().toString().equals(obstetricDate.getValue().toString())) {
    			t.insertTest(p.getPatientID(), obstetricDate.getValue().toString());
    			setTestDate.setText(obstetricDate.getValue().toString());
    		}else if(testDate.getValue().toString().equals(surgicalDate.getValue().toString())) {
    			t.insertTest(p.getPatientID(), surgicalDate.getValue().toString());
    			setTestDate.setText(surgicalDate.getValue().toString());
    		}else if(testDate.getValue().toString().equals(androGynDate.getValue().toString())) {
    			t.insertTest(p.getPatientID(), androGynDate.getValue().toString());
    			setTestDate.setText(androGynDate.getValue().toString());
    		}else {
    			reg.insertRegistration(p.getPatientID(), testDate.getValue().toString());
    			t.insertTest(p.getPatientID(), testDate.getValue().toString());
    			setTestDate.setText(testDate.getValue().toString());
    		}
    	}
    	
    }
    
    @FXML
    public void returntoView(ActionEvent event) throws IOException {
    	returnView();
    }
    
    private void returnView() throws IOException {
    	Main m = new Main();
    	m.changeScene("PatientView.fxml");
    }
    
    @FXML
    public void sendRegistrationForm(ActionEvent event) throws IOException {
    	returnViewForm();
    }
    
    private void returnViewForm() throws IOException {
    	// return the patient view
    	JOptionPane.showMessageDialog(null, "Appointment is set successfully!");
    	Main m = new Main();
    	m.changeScene("PatientView.fxml");
    }
}
