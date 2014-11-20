package com.livingoncodes.spring.springtutorial;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {
	
	private Patient patient;

	private Map<String, EmergencyContact> contacts = new HashMap<String, EmergencyContact>();

	public Map<String, EmergencyContact> getContacts() {
		return contacts;
	}
	
	public ContactBook() {
		patient = new Patient(10, "Dolly");
	}

	public void setContacts(Map<String, EmergencyContact> contacts) {
		this.contacts = contacts;
	}

	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(patient==null?"Patient is null\n":patient.toString());
		
		for (Map.Entry<String, EmergencyContact> contact : contacts.entrySet()) {
			sb.append(contact.toString() + "\n");
		}
		
		return sb.toString();

	}

}
