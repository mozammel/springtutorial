package com.livingoncodes.spring.springtutorial;

public class FileWriter implements LogWriter {

	public void write(String text) {
		System.out.println("Log to file: " + text);

	}

}
