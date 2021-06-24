package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import database.GetAdvice;
import database.GetAnGynlogyResult;
import database.GetDiagnostic;
import database.GetOstetricResult;
import database.GetSurgicalResult;
import database.GetTestResult;
import database.UpdateAdvice;
import database.UpdateDiagnostic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AnGynlogy;
import model.Doctor;
import model.Ostetric;
import model.Patient;
import model.Surgical;
import model.Test;
import view.Main;

public class DoctorEditController {
	
	@FXML
    private Button saveButton;

    @FXML
    private TextField patientID;

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
    private TextField doctorID;

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
    private Button obstetricButton;

    @FXML
    private Button surgicalButton;

    @FXML
    private Button AnGynlogyButton;

    @FXML
    private Button testButton;

    @FXML
    private Button diagAdvButton;

    @FXML
    private DatePicker selectDate;

    @FXML
    private AnchorPane obstetricPane;

    @FXML
    private TextField resultHuyetApTTT;

    @FXML
    private TextField resultHuyetApTTD;

    @FXML
    private TextField resultDienTim;

    @FXML
    private TextField resultSieuAmOBung;

    @FXML
    private TextField resultSieuAmTuyenGiap;

    @FXML
    private AnchorPane surgicalPane;

    @FXML
    private TextField resultMat;

    @FXML
    private TextField resultTai;

    @FXML
    private TextField resultMui;

    @FXML
    private TextField resultHong;

    @FXML
    private TextField resultRang;

    @FXML
    private AnchorPane anGynlogyPane;

    @FXML
    private TextField resultNam;

    @FXML
    private TextField resultNu;

    @FXML
    private AnchorPane testPane;

    @FXML
    private TextField resultHGSAB;

    @FXML
    private TextField resultHCV;

    @FXML
    private TextField resultAFP;

    @FXML
    private TextField resultURE;

    @FXML
    private TextField resultNSE;

    @FXML
    private TextField resultCYFRA;

    @FXML
    private TextField resultCA125;

    @FXML
    private TextField resultPSA;

    @FXML
    private TextField resultASLO;

    @FXML
    private TextField resultFT3;

    @FXML
    private TextField resultPLT;

    @FXML
    private AnchorPane diagAdvPane;

    @FXML
    private TextArea diagnostic;

    @FXML
    private TextArea advice;
    
    protected static Doctor d;
	public static void setDoctor(Doctor newD) {
		DoctorEditController.d = newD;
	}
	
	protected static Patient p;
	public static void setPatient(Patient newP) {
		DoctorEditController.p = newP;
	}
	
	static Ostetric pOs = new Ostetric(null, null, 0, null, null, null);
	static Surgical pSur = new Surgical(null, null, null, null, null, null);
	static AnGynlogy ag = new AnGynlogy(null, null, null);
	static Test t = new Test(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	static String doctorDiagnostic = null;
	static String doctorAdvice = null;
	
	@FXML
	private void showInformation() throws IOException {
		// show patient's information
		patientID.setText(p.getPatientID());
		patientID.setEditable(false);
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
		
		// show doctor's information
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
		doctorPhone.setText(d.getPhoneNumber());
		doctorPhone.setEditable(false);
	}

    @FXML
    public void AnGynlogyShow(ActionEvent event) throws IOException, ParseException {
    	callAnGynlogy();
    }
    
    private void callAnGynlogy() throws IOException, ParseException {
    	// call UI
    	obstetricPane.setVisible(false);
    	surgicalPane.setVisible(false);
    	anGynlogyPane.setVisible(true);
    	testPane.setVisible(false);
    	diagAdvPane.setVisible(false);
    	
    	// set information
    	GetAnGynlogyResult getAg = new GetAnGynlogyResult();
		ag = getAg.getAnGynlogyFromPidDate(p.getPatientID(), selectDate.getValue().toString());
		resultNam.setText(ag.getNam_khoa());
		resultNam.setEditable(false);
		resultNu.setText(ag.getPhu_khoa());
		resultNu.setEditable(false);
    }

    @FXML
    public void diagAdvShow(ActionEvent event) throws IOException, ParseException {
    	callDiagAdv();
    }
    
    private void callDiagAdv() throws IOException, ParseException {
    	// call UI
    	obstetricPane.setVisible(false);
    	surgicalPane.setVisible(false);
    	anGynlogyPane.setVisible(false);
    	testPane.setVisible(false);
    	diagAdvPane.setVisible(true);
    	
    	// show and get diagnostic + advice
    	GetDiagnostic getDiag = new GetDiagnostic();
    	diagnostic.setText(getDiag.getPatientDiagnostic(p.getPatientID(), selectDate.getValue().toString()));
    	// doctorDiagnostic = diagnostic.getText().toString();
    	
    	GetAdvice getAdv = new GetAdvice();
    	advice.setText(getAdv.getPatientAdvice(p.getPatientID(), selectDate.getValue().toString()));
    	// doctorAdvice = advice.getText().toString();
    }

    @FXML
    public void osbtetricShow(ActionEvent event) throws IOException, ParseException {
    	callObstetric();
    }
    
    private void callObstetric() throws IOException, ParseException {
    	// call UI
    	obstetricPane.setVisible(true);
    	surgicalPane.setVisible(false);
    	anGynlogyPane.setVisible(false);
    	testPane.setVisible(false);
    	diagAdvPane.setVisible(false);
    	
    	// set information
    	GetOstetricResult getOs = new GetOstetricResult();
    	pOs = getOs.getOstetricFromPidDate(p.getPatientID(), selectDate.getValue().toString());
    	resultHuyetApTTT.setText(pOs.getHuyetApTTT());
    	resultHuyetApTTT.setEditable(false);
    	resultHuyetApTTD.setText(pOs.getHuyetApTTD());
    	resultHuyetApTTD.setEditable(false);
    	resultDienTim.setText(String.valueOf(pOs.getDienTim()));
    	resultDienTim.setEditable(false);
    	resultSieuAmOBung.setText(pOs.getSieuamOBung());
    	resultSieuAmOBung.setEditable(false);
    	resultSieuAmTuyenGiap.setText(pOs.getSieuamTuyenGiap());
    	resultSieuAmTuyenGiap.setEditable(false);
    }

    @FXML
    public void saveDiagAdv(ActionEvent event) throws IOException, ParseException {
    	callSave();
    }
    
    private void callSave() throws IOException, ParseException {
    	UpdateDiagnostic upDiag = new UpdateDiagnostic();
    	doctorDiagnostic = diagnostic.getText().toString();
    	upDiag.updatePatientDiagnostic(doctorDiagnostic, p.getPatientID(), selectDate.getValue().toString());
    	JOptionPane.showMessageDialog(null, "Set diagnostic successfully!");
    	UpdateAdvice upAdv = new UpdateAdvice();
    	doctorAdvice = advice.getText().toString();
    	upAdv.updatePatientAdvice(doctorAdvice, p.getPatientID(), selectDate.getValue().toString());
    	JOptionPane.showMessageDialog(null, "Set advance successfully!");
    	Main m = new Main();
    	m.changeScene("DoctorView.fxml");
    }

    @FXML
    public void surgicalShow(ActionEvent event) throws IOException, ParseException {
    	callSurgical();
    }
    
    private void callSurgical() throws IOException, ParseException {
    	// call UI
    	obstetricPane.setVisible(false);
    	surgicalPane.setVisible(true);
    	anGynlogyPane.setVisible(false);
    	testPane.setVisible(false);
    	diagAdvPane.setVisible(false);
    	
    	// set information
    	GetSurgicalResult getSur = new GetSurgicalResult();
		pSur = getSur.getSurgicalFromPidDate(p.getPatientID(), selectDate.getValue().toString());
		resultMat.setText(pSur.getKham_mat());
		resultMat.setEditable(false);
		resultTai.setText(pSur.getKham_tai());
		resultTai.setEditable(false);
		resultMui.setText(pSur.getKham_mui());	
		resultMui.setEditable(false);
		resultHong.setText(pSur.getKham_hong());
		resultHong.setEditable(false);
		resultRang.setText(pSur.getKham_rang());
		resultRang.setEditable(false);
    }

    @FXML
    public void testShow(ActionEvent event) throws IOException, ParseException {
    	callTest();
    }
    
    private void callTest() throws IOException, ParseException {
    	// call UI
    	obstetricPane.setVisible(false);
    	surgicalPane.setVisible(false);
    	anGynlogyPane.setVisible(false);
    	testPane.setVisible(true);
    	diagAdvPane.setVisible(false);
    	
    	// set information
    	GetTestResult getTest = new GetTestResult();
		t = getTest.getTestFromPidDate(p.getPatientID(), selectDate.getValue().toString());
		resultHGSAB.setText(String.valueOf(t.getHgsab()));
		resultHGSAB.setEditable(false);
		resultHCV.setText(String.valueOf(t.getHcv()));
		resultHCV.setEditable(false);
		resultAFP.setText(String.valueOf(t.getAfp()));
		resultAFP.setEditable(false);
		resultURE.setText(String.valueOf(t.getUre()));
		resultURE.setEditable(false);
		resultNSE.setText(String.valueOf(t.getNse()));
		resultNSE.setEditable(false);
		resultCYFRA.setText(String.valueOf(t.getCyfra()));
		resultCYFRA.setEditable(false);
		resultCA125.setText(String.valueOf(t.getCa125()));
		resultCA125.setEditable(false);
		resultPSA.setText(String.valueOf(t.getPsa()));
		resultPSA.setEditable(false);
		resultASLO.setText(String.valueOf(t.getAslo()));
		resultASLO.setEditable(false);
		resultFT3.setText(String.valueOf(t.getFt3()));
		resultFT3.setEditable(false);
		resultPLT.setText(String.valueOf(t.getPlt()));
		resultPLT.setEditable(false);
    }


}
