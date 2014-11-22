package com.livingoncodes.spring.springtutorial;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("filewriter")
public class FileWriter implements LogWriter {

	public void write(String text) {
		System.out.println("Log to file: " + text);

	}

}
