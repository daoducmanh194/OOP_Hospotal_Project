package model;

import java.util.ArrayList;

public class Enterprises {
	private String enterpriseID;
	private String name;
	private ArrayList<Patient> ePatient = new ArrayList<Patient>();
	
	public Enterprises(String enterpriseID, String name) {
		super();
		this.enterpriseID = enterpriseID;
		this.name = name;
	}

	public String getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Patient> getePatient() {
		return ePatient;
	}

	public void setePatient(ArrayList<Patient> ePatient) {
		this.ePatient = ePatient;
	}
	
	
}
