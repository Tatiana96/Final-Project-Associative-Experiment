package com.bram.concat.associationsundercognitiveload.experiment;

/**
 * Represents the user of the experiment.
 */
public class Participant {
	
	/**
	 * The participant's number. Should be given to him/her by the experimenter.
	 */
	public int ssNb;	
	
	/**
	 * Filled out by participant.
	 */
	public int age;	
	
	/**
	 * Filled out by participant.
	 */
	public char gender;
	
	public Participant(int ssNb, int age, char gender) {
		this.ssNb = ssNb;		
		this.age = age;		
		this.gender = gender;
	}
}
