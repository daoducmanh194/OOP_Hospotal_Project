package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import database.ReturnAllPatient;
import database.ReturnAllPatientAddress;
import database.ReturnAllPatientFemale;
import database.ReturnAllPatientFirstName;
import database.ReturnAllPatientLastName;
import database.ReturnAllPatientMale;
import database.ReturnAllPatientPhone;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Patient;
import view.Main;

public class PatientListController implements Initializable {
	
	@FXML
    private TextField patientFirstName;

    @FXML
    private TextField patientLastName;

    @FXML
    private TextField patientPhone;

    @FXML
    private TextField patientAddress;

    @FXML
    private DatePicker patinetFrom;

    @FXML
    private DatePicker patientTo;

    @FXML
    private CheckBox patientMale;

    @FXML
    private CheckBox patientFemale;

    @FXML
    private Button searchButton;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, String> showID;

    @FXML
    private TableColumn<Patient, String> showFirstName;

    @FXML
    private TableColumn<Patient, String> showLastName;

    @FXML
    private TableColumn<Patient, String> showGender;

    @FXML
    private TableColumn<Patient, Date> showBirth;

    @FXML
    private TableColumn<Patient, String> showPhone;

    @FXML
    private TableColumn<Patient, String> showAddress;

    @FXML
    private TableColumn<Patient, String> showTestDate;

    @FXML
    public void backToView(ActionEvent event) throws IOException {
    	toView();
    }
    
    private void toView() throws IOException {
    	Main m = new Main();
    	m.changeScene("DoctorView.fxml");
    }

    @FXML
    public void searchInformation(ActionEvent event) throws IOException {
    	searchFName();
    	searchLName();
    	searchPhone();
    	searchAddress();
    	searchFollowGender();
    }
    
    private void searchFName() throws IOException {
    	if(!patientFirstName.getText().toString().isEmpty()) {
    		ReturnAllPatientFirstName fn = new ReturnAllPatientFirstName();
    		ObservableList<Patient> listFn = fn.allPatientFName(patientFirstName.getText().toString());
    		initialize(listFn);
    	}
    }
    
    private void searchLName() throws IOException {
    	if(!patientLastName.getText().toString().isEmpty()) {
    		ReturnAllPatientLastName ln = new ReturnAllPatientLastName();
    		ObservableList<Patient> listLn = ln.allPatientLName(patientLastName.getText().toString());
    		initialize(listLn);
    	}
    }
    
    private void searchPhone() throws IOException {
    	if(!patientPhone.getText().toString().isEmpty()) {
    		ReturnAllPatientPhone pp = new ReturnAllPatientPhone();
    		ObservableList<Patient> listPhone = pp.allPatientPhone(patientPhone.getText().toString());
    		initialize(listPhone);
    	}
    }
    
    private void searchAddress() throws IOException {
    	if(!patientAddress.getText().toString().isEmpty()) {
    		ReturnAllPatientAddress pa = new ReturnAllPatientAddress();
    		ObservableList<Patient> listAddress = pa.allPatientAddress(patientAddress.getText().toString());
    		initialize(listAddress);
    	}
    }
    
    private void searchFollowGender() throws IOException {
    	if(patientMale.isSelected() && patientFemale.isSelected()) {
    		JOptionPane.showMessageDialog(null, "Choose one option for gender!", "Warning", JOptionPane.WARNING_MESSAGE);
    	}else if(patientMale.isSelected()) {
    		// choose male
    		ReturnAllPatientMale rm = new ReturnAllPatientMale();
    		ObservableList<Patient> listMale = rm.allPatientMale();
    		initialize(listMale);
    	} else if(patientFemale.isSelected()) {
    		// choose female
    		ReturnAllPatientFemale rf = new ReturnAllPatientFemale();
    		ObservableList<Patient> listFemale = rf.allPatientFemale();
    		initialize(listFemale);
    	}
    }
    
    ReturnAllPatient rap = new ReturnAllPatient();
    ObservableList<Patient> listPatient;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	showID.setCellValueFactory(new PropertyValueFactory<Patient, String>("patientID"));
    	showFirstName.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
    	showLastName.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
    	showGender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
    	showBirth.setCellValueFactory(new PropertyValueFactory<Patient, Date>("dob"));
    	showPhone.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNumber"));
    	showAddress.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
    	
    	listPatient = rap.allPatient();
    	patientTable.setItems(listPatient);
    }
    
    public void initialize(ObservableList<Patient> list) {
    	
    	showID.setCellValueFactory(new PropertyValueFactory<Patient, String>("patientID"));
    	showFirstName.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
    	showLastName.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
    	showGender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
    	showBirth.setCellValueFactory(new PropertyValueFactory<Patient, Date>("dob"));
    	showPhone.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNumber"));
    	showAddress.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
    	
    	patientTable.setItems(list);
    }

}
