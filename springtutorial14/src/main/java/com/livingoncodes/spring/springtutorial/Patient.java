package com.livingoncodes.spring.springtutorial;

import java.util.List;

public class Patient {

	private int id;
	private String name;

	private List<String> emergencyContactNames;

	
	public Patient() {

	}
	
	
	public void onCreate() {
		System.out.println("Patient created: " + this);
	}

	public void onDestroy() {
		System.out.println("Patient destroyed");
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


	public List<String> getEmergencyContactNames() {
		return emergencyContactNames;
	}


	public void setEmergencyContactNames(List<String> emergencyContactNames) {
		this.emergencyContactNames = emergencyContactNames;
	}

	

}
