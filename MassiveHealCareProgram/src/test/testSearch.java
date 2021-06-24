package test;

import database.GetDiagnostic;
import database.GetDoctorAdvice;
import database.GetOstetricResult;
import database.ReturnAllPatient;
import database.ReturnDB;
import database.SearchDB;
import database.UpdateAddress;
import database.UpdateDiagnostic;
import database.UpdatePhonenumber;
import model.Ostetric;
import model.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;  

public class testSearch {
	public static void main(String[] ags) throws ParseException {
		//SearchDB newsearch = new SearchDB();
		//int flag = newsearch.searchFollowUsernamePassword("Tai Thu", "binhminh7");
		//System.out.println(flag);
		//Patient p = newsearch.searchFollowPID("BK47");
		//System.out.println(p.getFirstName() + p.getLastName());
		//ReturnDB myReturn = new ReturnDB();
		//String did = myReturn.returnIDFollowUsernamePassword("Tai Thu", "binhminh7", 2);
		//System.out.println(did);
		//UpdatePhonenumber myUpdate = new UpdatePhonenumber();
		//myUpdate.updatePPhonenumber("0986297562", "HBT2");
		//GetOstetricResult o = new GetOstetricResult();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		//String sDate1="2021-06-12";  
	    //Date date1=formatter.parse(sDate1);
		//Ostetric myOs = o.getOstetricFromPidDate("BK001", "2021-06-12");
		//System.out.println(myOs.getDienTim());
		//GetDoctorAdvice getDoc = new GetDoctorAdvice();
		//System.out.println(getDoc.getDIDAdv("BK001", "2021-06-12"));
		//GetDiagnostic getDiag = new GetDiagnostic();
		//System.out.println(getDiag.getPatientDiagnostic("Bk001", "2021-06-12"));
		//UpdateDiagnostic u = new UpdateDiagnostic();
		//u.updatePatientDiagnostic("Tình trạng sức khỏe ổn định", "BK001", "2021-06-16");
		//ReturnAllPatient rp = new ReturnAllPatient();
		//ArrayList<Patient> p = rp.allPatient();
		//System.out.println(p.size());
		//System.out.println(p.get(0).getFirstName() + " " +  p.get(0).getLastName());
	}
}
