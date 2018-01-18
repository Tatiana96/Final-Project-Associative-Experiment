package com.bram.concat.associationsundercognitiveload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to assist with input of figures, and with output of data.
 */
public abstract class IO {
	
	/**
	 * List of the raw stimuli; one list-entry per line, one array-entry per column.
	 * Will be filled by {@code readStimuli()}.
	 */
	public static List<String[]> stimStrings; 
	
	/**
	 * Name of the file to which this participant's data will be written.
	 * This filename contains student number, age, gender, date, and time.
	 */
	private static String outputFilename;
	
	/**
	 * Used to write this participant's data to his/her datafile.
	 */
	private static PrintWriter out;     
	
	/**
	 * Read the stimuli as defined in {@code Options.STIM_FILE}
	 * Add them to {@code stimStrings}
	 */
	public static void readStimuli() {
		File stimFile = new File(Options.STIM_FILE);
		stimStrings = new ArrayList<String[]>();
		
		try {
			 BufferedReader fReader =
					    new BufferedReader(
					    new InputStreamReader(
					    new FileInputStream(stimFile), "UTF-8"));
            String line = fReader.readLine(); //remove header line
            
            while ((line = fReader.readLine()) != null) {
            	stimStrings.add(line.split("\t"));
            }
			fReader.close();

		} catch (NumberFormatException | IOException e) { 
			e.printStackTrace(); 
		}  
		
	}
	
	/**
	 * Create a datafile for the current user; filename contains student number, age, gender, date, and time.
	 */
	public static void initializeWriting(String filename) {
		outputFilename = filename;
		try {	
			out = new PrintWriter(new FileWriter(outputFilename));
			out.close();
		} catch (IOException e){ 
			e.printStackTrace();   
		}	
		
		writeData(Text.HEADER); //write the headers as the first line
	}

	/**
	 * Write out the indicated string to this participant's data file, and start a new line.
	 */
	public static void writeData(String a) {	 
		try {	 
			out = new PrintWriter(new FileWriter(outputFilename,true)); //open the file
			out.append(a); //append the string
			out.println(); //start new line
			out.close();   //close file
		} catch (IOException e) { 
			e.printStackTrace();   
		}
	}
}