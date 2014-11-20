package com.livingoncodes.spring.springtutorial;

public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
