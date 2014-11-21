package com.livingoncodes.spring.springtutorial;

public class Logger {

	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	public LogWriter getConsoleWriter() {
		return consoleWriter;
	}

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public LogWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);		
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
		
	}

}
