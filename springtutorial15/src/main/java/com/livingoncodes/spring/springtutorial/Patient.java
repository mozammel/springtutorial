package com.livingoncodes.spring.springtutorial;

import java.util.List;

public class Patient {

	private int id;
	private String name;

	private List<EmergencyContact> emergencyContacts;
	
	public Patient() {

	}
	
	
	public Patient(int id, String name) {
		this.id = id;
		this.name = name;
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
		return "Patient [id=" + id + ", name=" + name + "]";
	}


	public List<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}


	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	
	

}
