package com.livingoncodes.spring.springtutorial;

public class Patient {
	
	private int id;
	private String name;
	
	private int nationalId;
	
	
	public Patient() {
		
	}
	
	
	public Patient(int id, String name) {
		this.id = id;
		this.name = name;
	}




	public int getNationalId() {
		return nationalId;
	}


	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
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
		return "Patient [id=" + id + ", name=" + name + ", nationalId="
				+ nationalId + "]";
	}


	public void speak() {
		System.out.println("Help me!");
	}

}
