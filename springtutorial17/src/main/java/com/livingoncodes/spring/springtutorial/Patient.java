package com.livingoncodes.spring.springtutorial;

import java.util.List;

public class Patient {

	private int id;
	private String name;
	
	private EmergencyContact criticalContact;

	private List<EmergencyContact> emergencyContacts;
	
	public Patient() {

	}
	
	
	public Patient(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

	public EmergencyContact getCriticalContact() {
		return criticalContact;
	}


	public void setCriticalContact(EmergencyContact criticalContact) {
		this.criticalContact = criticalContact;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + " CriticalContact=" + criticalContact + "]";
	}


	public List<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}


	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	
	

}
