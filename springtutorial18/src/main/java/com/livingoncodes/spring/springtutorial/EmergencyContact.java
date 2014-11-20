package com.livingoncodes.spring.springtutorial;

public class EmergencyContact {

	private String name;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "EmergencyContact [name=" + name + ", phoneNumber="
				+ phoneNumber + "]";
	}

	
}
