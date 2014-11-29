package com.livingoncodes.spring.web.dao;

import javax.validation.constraints.Size;

public class Notice {
	private int id;
	@Size(min=4, max=100)
	private String name;
	private String email;
	private String text;
	
	
	public Notice() {
		
	}
	
	public Notice(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Notice(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

	
}
