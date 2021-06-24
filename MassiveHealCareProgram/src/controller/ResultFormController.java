package controller;

import java.io.IOException;
import java.text.ParseException;

import database.GetAnGynlogyResult;
import database.GetOstetricResult;
import database.GetSurgicalResult;
import database.GetTestResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.AnGynlogy;
import model.Ostetric;
import model.Patient;
import model.Surgical;
import model.Test;
import view.Main;


public class ResultFormController {
	
	@FXML
    private TextField patientInsurance;

    @FXML
    private TextField patientGender;

    @FXML
    private TextField patientAge;

    @FXML
    private TextField patientName;

    @FXML
    private TextField patientID;

    @FXML
    private Button patientPDFButton;

    @FXML
    private Button patientProfileButton;

    @FXML
    private Button backButton;

    @FXML
    private Button patientAdviceButton;

    @FXML
    private TextField normalHuyetApT;

    @FXML
    private TextField normalHuyetApD;

    @FXML
    private TextField normalDienTim;

    @FXML
    private TextField normalSieuAmOBung;

    @FXML
    private TextField normalSieuAmTuyenGiap;

    @FXML
    private TextField resultHuyetApT;

    @FXML
    private TextField resultHuyetApD;

    @FXML
    private TextField resultDienTim;

    @FXML
    private TextField resultSieuAmOBung;

    @FXML
    private TextField resultSieuAmTuyenGiap;

    @FXML
    private TextField diagnosticHuyetApT;

    @FXML
    private TextField diagnosticHuyetApD;

    @FXML
    private TextField diagnosticDienTim;

    @FXML
    private TextField diagnosticSieuAmOBung;

    @FXML
    private TextField diagnosticSieuAmTuyenGiap;

    @FXML
    private TextField normalMat;

    @FXML
    private TextField normalTai;

    @FXML
    private TextField normalMui;

    @FXML
    private TextField normalHong;

    @FXML
    private TextField normalRang;

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
    private TextField diagnosticMat;

    @FXML
    private TextField diagnosticTai;

    @FXML
    private TextField diagnosticMui;

    @FXML
    private TextField diagnosticHong;

    @FXML
    private TextField diagnosticRang;

    @FXML
    private TextField normalNam;

    @FXML
    private TextField normalNu;

    @FXML
    private TextField resultNam;

    @FXML
    private TextField resultNu;

    @FXML
    private TextField diagnosticNam;

    @FXML
    private TextField diagnosticNu;

    @FXML
    private TextField normalHGSAB;

    @FXML
    private TextField resultHGSAB;

    @FXML
    private TextField normalHCV;

    @FXML
    private TextField resultHCV;

    @FXML
    private TextField normalAFP;

    @FXML
    private TextField resultAFP;

    @FXML
    private TextField normalURE;

    @FXML
    private TextField resultURE;

    @FXML
    private TextField normalNSE;

    @FXML
    private TextField resultNSE;

    @FXML
    private TextField normalCYFRA;

    @FXML
    private TextField resultCYFRA;

    @FXML
    private TextField normalCA125;

    @FXML
    private TextField resultCA125;

    @FXML
    private TextField normalPSA;

    @FXML
    private TextField resultPSA;

    @FXML
    private TextField normalASLO;

    @FXML
    private TextField resultASLO;

    @FXML
    private TextField normalFT3;

    @FXML
    private TextField resultFT3;

    @FXML
    private TextField normalPLT;

    @FXML
    private TextField resultPLT;

    @FXML
    private TextField diagnosticHGSAB;

    @FXML
    private TextField diagnosticHCV;

    @FXML
    private TextField diagnosticAFP;

    @FXML
    private TextField diagnosticURE;

    @FXML
    private TextField diagnosticNSE;

    @FXML
    private TextField diagnosticCYFRA;

    @FXML
    private TextField diagnosticCA125;

    @FXML
    private TextField diagnosticPSA;

    @FXML
    private TextField diagnosticASLO;

    @FXML
    private TextField diagnosticFT3;

    @FXML
    private TextField diagnosticPLT;

    @FXML
    private DatePicker selectDate;
    
    protected static Patient p;
    protected static Ostetric os;
    protected static Surgical sur;
    protected static AnGynlogy ag;
    protected static Test t;
    
	public static void setPatient(Patient newP) {
		ResultFormController.p = newP;
	}
	
	@FXML
	public void showInformation(ActionEvent e) throws IOException {
		show();
	}
	
	private void show() throws IOException {		
		// show information
		patientID.setText(p.getPatientID());
		patientID.setEditable(false);
		patientName.setText(p.getFirstName() + " " + p.getLastName());
		patientName.setEditable(false);
		patientAge.setText("20");
		patientAge.setEditable(false);
		patientGender.setText(p.getGender());
		patientGender.setEditable(false);
		patientInsurance.setText(" ");
		patientInsurance.setEditable(false);
	}
	
	@FXML
	public void showOstetricInformation() throws Exception {
		callOstetric();
	}
	
	private void callOstetric() throws IOException, Exception{
		if(!selectDate.getValue().toString().isEmpty()) {
			GetOstetricResult getOs = new GetOstetricResult();
			os = getOs.getOstetricFromPidDate(p.getPatientID(), selectDate.getValue().toString());
			// System.out.println(selectDate.getValue().toString());
			resultHuyetApT.setText(os.getHuyetApTTT());
			// System.out.println(os.getHuyetApTTT());
			resultHuyetApT.setEditable(false);
			resultHuyetApD.setText(os.getHuyetApTTD());
			resultHuyetApD.setEditable(false);
			resultDienTim.setText(String.valueOf(os.getDienTim()));
			resultDienTim.setEditable(false);
			resultSieuAmOBung.setText(os.getSieuamOBung());
			resultSieuAmOBung.setEditable(false);
			resultSieuAmTuyenGiap.setText(os.getSieuamTuyenGiap());
			resultSieuAmTuyenGiap.setEditable(false);
		}
	}
	
	@FXML
	public void showSurgicalInformation() throws Exception {
		callSurgical();
	}
	
	private void callSurgical() throws IOException, Exception{
		if(!selectDate.getValue().toString().isEmpty()) {
			GetSurgicalResult getSur = new GetSurgicalResult();
			sur = getSur.getSurgicalFromPidDate(p.getPatientID(), selectDate.getValue().toString());
			resultMat.setText(sur.getKham_mat());
			resultMat.setEditable(false);
			resultTai.setText(sur.getKham_tai());
			resultTai.setEditable(false);
			resultMui.setText(sur.getKham_mui());
			resultMui.setEditable(false);
			resultHong.setText(sur.getKham_hong());
			resultHong.setEditable(false);
			resultRang.setText(sur.getKham_rang());
			resultRang.setEditable(false);
		}
	}
	
	@FXML
	public void showAnGynlogyInformation() throws Exception {
		callAnGynlogy();
	}
	
	private void callAnGynlogy() throws IOException, Exception {
		if(!selectDate.getValue().toString().isEmpty()) {
			GetAnGynlogyResult getAg = new GetAnGynlogyResult();
			ag = getAg.getAnGynlogyFromPidDate(p.getPatientID(), selectDate.getValue().toString());
			resultNam.setText(ag.getNam_khoa());
			resultNam.setEditable(false);
			resultNu.setText(ag.getPhu_khoa());
			resultNu.setEditable(false);
		}
	}
	
	@FXML
	public void showTestInformation() throws Exception {
		callTest();
	}
	
	private void callTest() throws IOException, Exception {
		if(!selectDate.getValue().toString().isEmpty()) {
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
	
	@FXML
	public void showAll(ActionEvent event) throws Exception {
		all();
	}
	
	private void all() throws Exception {
		showOstetricInformation();
		showSurgicalInformation();
		showAnGynlogyInformation();
		showTestInformation();
	}

    @FXML
    public void backToView(ActionEvent event) throws IOException{
    	changetoView();
    }
    
    private void changetoView() throws IOException {
    	Main m = new Main();
    	m.changeScene("PatientView.fxml");
    }

    @FXML
    void extractPDF(ActionEvent event) throws IOException{

    }

    @FXML
    void viewAdvice(ActionEvent event) throws IOException{
    	changeToAdvice();
    }
    
    private void changeToAdvice() throws IOException {
    	Main m = new Main();
    	AdviceFormController.setDate(selectDate.getValue().toString());
    	m.changeScene("AdviceFormView.fxml");
    }

    @FXML
    void viewProfile(ActionEvent event) throws IOException{

    }

}
