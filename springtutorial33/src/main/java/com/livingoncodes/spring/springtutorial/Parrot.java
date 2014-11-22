package com.livingoncodes.spring.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Parrot {

	private String id;
	private String speech;

	@Autowired
	public void setId(@Value("#{randomSpeech.getText()?.length()}") String id) {
		this.id = id;
	}

	@Autowired
	public void setSpeech(@Value("#{randomSpeech.getText()}") String speech) {
		this.speech = speech;
	}
	
	public void speak() {
		System.out.println(id + ":" + speech);
	}

}
