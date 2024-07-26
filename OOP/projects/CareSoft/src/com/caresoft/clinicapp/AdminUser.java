package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	public AdminUser(int ID, String role) {
		super(ID);
		this.role = role;
	}

    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
        
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
    public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
    	
    	if(length >= 6) {
    		this.pin = pin;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean accessAuthorized(Integer confirmedId) {
    	if(confirmedId.equals(this.id)) {
    		return true;
    	} else {
    		this.authIncident();
    		return false;
    	}
    }
    
    public ArrayList<String> reportSecurityIncidents(){
    	return this.securityIncidents;
    }

}
