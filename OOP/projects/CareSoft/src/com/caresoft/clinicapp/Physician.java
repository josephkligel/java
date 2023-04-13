package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes;
	
    public Physician(Integer id) {
		super(id);
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
    public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
    	
    	if(length == 4) {
    		this.pin = pin;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean accessAuthorized(Integer confirmedAuthId) {
    	if(confirmedAuthId.equals(this.id)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    

}
