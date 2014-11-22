package com.livingoncodes.spring.springtutorial;

import java.util.Random;

public class RandomSpeech {
	
	private static String[] texts = {
		"Who goes there?",
		"Good Morning!",
		"Feed me cookies"
	};
	
	public String getText() {
		Random random = new Random();
		
		return texts[random.nextInt(texts.length)];
	}
}
