package com.livingoncodes.spring.springtutorial;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {

	private Map<String, EmergencyContact> contacts = new HashMap<String, EmergencyContact>();

	public Map<String, EmergencyContact> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, EmergencyContact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, EmergencyContact> contact : contacts.entrySet()) {
			sb.append(contact.toString() + "\n");
		}
		
		return sb.toString();

	}

}
