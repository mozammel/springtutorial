package com.livingoncodes.spring.springtutorial;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;


public class Logger {

	private ConsoleWriter consoleWriter;

	private LogWriter fileWriter;

	@Inject
	@Named(value="demoWriter2")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	@Inject
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);

	}
	
	@PostConstruct
	public void init() {
		System.out.println("Creating bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying bean");
	}

}
