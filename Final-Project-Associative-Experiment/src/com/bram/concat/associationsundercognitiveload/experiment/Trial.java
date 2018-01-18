package com.bram.concat.associationsundercognitiveload.experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bram.concat.associationsundercognitiveload.IO;
import com.bram.concat.associationsundercognitiveload.experiment.TrialGroup.IncorrectNumberOfTrialsException;

/**
 * Represents one trial in the experiment.
 * Each trial begins with a fixation cross, then the prime, a blank screen, the target, and finally another blank screen.
 */
public class Trial {
	
	/**
	 * TrialGroups (each contains five trials) that will be used in the training phase.
	 */
	public static List<TrialGroup> trainingTrialGroups; 
		
	/**
	 * TrialGroups (each contains five trials) that will be used in the experiment (does not include training trials).
	 */
	public static List<TrialGroup> experimentTrialGroups;
    	
	/**
	 * Full factorial of 2 conditions (lowLoad|highload), in randomized order.
	 * (Yes, this is overengineered for the current setup, but allows for easy adding of extra conditions.)
	 */
	private static final boolean[][] CONDITION_MATRIX = { 
		{true},
		{false}
	};   
    
	/**
	 * Create all trials the current participant will see.
	 * Participant number determines which trials fall in which condition.
	 * As such, this can only be run AFTER the participant is initialized.
	 * @throws IncorrectNumberOfTrialsException 
	 */
    public static void createTrials() throws IncorrectNumberOfTrialsException {
    	if (Experiment.pp == null) {
    		System.err.println("Cannot create trials before participant is defined!");
    	} else {
    		int ssOffset = Experiment.pp.ssNb % CONDITION_MATRIX.length; //1 to 2
    		if (ssOffset == 0) {
    			ssOffset = CONDITION_MATRIX.length;
    		}

    		//create all trials, in 8 groups of 40 (one group per condition)
    		List<Trial> lowLoadTrials = new ArrayList<Trial>();
    		List<Trial> highLoadTrials = new ArrayList<Trial>();

    		while (!IO.stimStrings.isEmpty()) {
    			String[] trialLine = IO.stimStrings.remove(0); //the line containing the text of this trial    		
    			String cue = trialLine[0];
    			int list = Integer.parseInt(trialLine[1]);
    			    			
    			boolean[] condition = CONDITION_MATRIX[(ssOffset - 1) % CONDITION_MATRIX.length]; //-1 because ssOffset starts at 1, while conditionMatrix starts at 0
    			boolean list1lowload = condition[0];

    			boolean lowLoad = ((list == 1 && list1lowload) || (list == 2 && !list1lowload));
    			
    			Trial t = new Trial(cue, lowLoad, false, list);
    			
    			if	(lowLoad) {
    				lowLoadTrials.add(t);
    			} else {
    				highLoadTrials.add(t);  			
    			}
    		}
    		    		
    		//randomize the order within each list
    		Collections.shuffle(lowLoadTrials);
    		Collections.shuffle(highLoadTrials);

    		experimentTrialGroups = new ArrayList<TrialGroup>();
    		experimentTrialGroups.addAll(TrialGroup.createTrialGroups(lowLoadTrials));
    		experimentTrialGroups.addAll(TrialGroup.createTrialGroups(highLoadTrials));   		
    		Collections.shuffle(experimentTrialGroups);    		
    	}
    }      
    
    /**
     * Create the training trials the participant will see.
     * They are hardcoded here.
     * More trialgroups can be added (here) for a longer training phase.
     */
    public static void createTrainingTrials() {
    	List<Trial> lowLoadTrainingTrials = new ArrayList<Trial>();
    	lowLoadTrainingTrials.add(new Trial("Человек", true, true, -1));
    	lowLoadTrainingTrials.add(new Trial("после", true, true, -1));
    	lowLoadTrainingTrials.add(new Trial("подражать", true, true, -1));
    	lowLoadTrainingTrials.add(new Trial("улитка", true, true, -1));
    	lowLoadTrainingTrials.add(new Trial("надувать", true, true, -1));
    	
    	List<Trial> highLoadTrainingTrials = new ArrayList<Trial>();
    	highLoadTrainingTrials.add(new Trial("серия", false, true, -1));
    	highLoadTrainingTrials.add(new Trial("избыток", false, true, -1));
    	highLoadTrainingTrials.add(new Trial("мед", false, true, -1));
    	highLoadTrainingTrials.add(new Trial("кровь", false, true, -1));
    	highLoadTrainingTrials.add(new Trial("счастливый", false, true, -1));
    	
    	trainingTrialGroups = new ArrayList<TrialGroup>(); 
    	trainingTrialGroups.add(new TrialGroup(lowLoadTrainingTrials, true)); 
    	trainingTrialGroups.add(new TrialGroup(highLoadTrainingTrials, false));
    }
      
    /**
     * The cue i.e. the word on which the participant will give associations.
     */
	public String cue;
	
	/**
	 * True: simple pattern (see {@code pattern.LowloadPattern}).
	 * False: complex pattern (see {@code pattern.HighloadPattern}).
	 */
	public boolean lowLoad;
	
	/**
	 * Textual representation of the indicated condition, for this Trial. Used when writing away the data to disk. 
	 */
	public String loadString;
	
	/**
	 * Which list the trial belongs in, read from {@code Options.STIM_FILE}.
	 */
	public int list;
	
	/**
	 * Index of this trial in its trial group i.e. 0..4.
	 */
	public int indexInTrialGroup; 
	
    private Trial(String cue, boolean lowLoad, boolean trainingTrial, int list) {
        this.cue = cue;
        this.lowLoad = lowLoad;
        this.list = list;
        loadString = (lowLoad ? "LOW_LOAD" : "HIGH_LOAD");    
    }
}
