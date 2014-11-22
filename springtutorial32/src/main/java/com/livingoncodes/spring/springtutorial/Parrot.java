package com.livingoncodes.spring.springtutorial;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

	private int id;
	private String speech;

	public void setId(int id) {
		this.id = id;
	}

	public void setSpeech( String speech) {
		this.speech = speech;
	}
	
	public void speak() {
		System.out.println(id + ":" + speech);
	}

}
