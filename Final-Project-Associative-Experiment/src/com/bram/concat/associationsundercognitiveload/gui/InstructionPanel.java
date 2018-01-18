package com.bram.concat.associationsundercognitiveload.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.bram.concat.associationsundercognitiveload.Options;
import com.bram.concat.associationsundercognitiveload.Text;
import com.bram.concat.associationsundercognitiveload.experiment.Experiment;

/**
 * Panel that displays the introduction to / explanation of the experiment.
 */
@SuppressWarnings("serial")
public class InstructionPanel extends JPanel {		
	
	/**
	 * Holds the text.
	 */
	JEditorPane textPane;
	
	/**
	 * Starts the experiment.
	 */
	JButton mainButton;
	
	/**
	 * Display the previous instructions.
	 */
	JButton previousButton;
	
	/**
	 * Display the next instructions.
	 */
	JButton nextButton;
	
	InstructionPanel() {
		setLayout(null); 	//absolute positioning
		int width = (int) (Options.screenSize.width * 0.8); //80% of screenwidth
		if (width > 1000) {
			width = 1000; //max 1000px
		}
		
		int height = 500;
		
		textPane = new JEditorPane("text/html", ""); //create text pane, make sure we can use html formatting
		textPane.setEditable(false);
		textPane.setBackground(getBackground());     //set backgroundcolor to parent's background
		textPane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
		textPane.setFont(Text.FONT_INSTRUCTIONS);
		
		JScrollPane paneScrollPane = new JScrollPane(textPane);
        paneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //hopefully we never need scrollbars, but just in case
        paneScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneScrollPane.setBorder(BorderFactory.createEmptyBorder()); //remove border
		paneScrollPane.setBounds((int) (Options.screenSize.getWidth() / 2 - width / 2), 100, width, height); //centered
        add(paneScrollPane); //add instructions
        
        mainButton = new JButton(Text.BTN_BEGIN); 
		previousButton = new JButton(Text.BTN_PREVIOUS);
		nextButton = new JButton(Text.BTN_NEXT);
		
		mainButton.setVisible(false);
		previousButton.setVisible(false);
		nextButton.setVisible(false);
		
		add(mainButton); 
		add(previousButton);
		add(nextButton);
		
		int buttonWidth = 120;
		mainButton.setBounds((int) (Options.screenSize.getWidth() / 2 - buttonWidth / 2), height + 125, buttonWidth, 35); 	
		previousButton.setBounds((int) (Options.screenSize.getWidth() / 2 - 120 / 2 - buttonWidth), height + 125, buttonWidth, 35); 	 
		nextButton.setBounds((int) (Options.screenSize.getWidth() / 2 + 120 / 2), height + 125, buttonWidth, 35); 	
		
		textPane.setCaretPosition(0); //scroll to top
	}
	
	/**
	 * Show the indicated page of the instructions.
	 */
	public void showMainInstructions(final int pageIndex) {
		removeActionListeners(nextButton);
		removeActionListeners(previousButton);
		
		if (pageIndex < Text.TEXT_INSTRUCTIONS.length) { 
			//not last page
			nextButton.setText(Text.BTN_NEXT);
			nextButton.setVisible(true);
			nextButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
				showMainInstructions(pageIndex + 1);
			}});
		} 
		
		if (pageIndex > 1) { 
			//not first page
			previousButton.setText(Text.BTN_PREVIOUS);
			previousButton.setVisible(true);
			previousButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
				showMainInstructions(pageIndex - 1);
			}});
		} else {
			previousButton.setVisible(false);
		}
		
		if (pageIndex == Text.TEXT_INSTRUCTIONS.length) { 
			//last page			
			nextButton.setText(Text.BTN_BEGIN);
			nextButton.setVisible(true);
			nextButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
				previousButton.setVisible(false);
				nextButton.setVisible(false);
				Experiment.xp.displayAndContinue(); 
			}});
		}				
		setInstructions(Text.TEXT_INSTRUCTIONS[pageIndex - 1]);		
	}
	
	public void showFirstBlockPostTrainingInstructions() {
		mainButton.setVisible(true);
		mainButton.setText(Text.BTN_CONTINUE);
		removeActionListeners(mainButton);
		mainButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
			Experiment.xp.displayAndContinue(); 
		}});
		setInstructions(Text.TEXT_POSTTRAINING_INSTRUCTIONS);	
	}
	
	/**
	 * @param lastblock True: show the instructions for the last block
	 * Last block: generally slightly different from previous interblock instructions, e.g. they may refer to the upcoming block as the last one instead of the next one.
	 */
	public void showInterBlockInstructions(boolean lastblock) {
		mainButton.setText(Text.BTN_CONTINUE);
		removeActionListeners(mainButton);
		mainButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
			Experiment.xp.displayAndContinue(); 
		}});
		if (lastblock) {
			setInstructions(Text.TEXT_INTERBLOCK_LAST);
		} else {
			setInstructions(Text.TEXT_INTERBLOCK);
		}
	}
	
	public void showXpOverText() {
		mainButton.setText(Text.BTN_QUIT);
		removeActionListeners(mainButton);
		mainButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { //on click, close the gui		
			Experiment.gui.dispose(); 		//remove the layout
	        System.exit(0); //exit	
		}});
		setInstructions(Text.TEXT_XP_OVER_MESSAGE);			
	}
	
	private void setInstructions(String text){
		Experiment.gui.showCursor();
		Experiment.gui.bg.removeAll(); 
		textPane.setText(text);	
		Experiment.gui.bg.add(this); //add introduction screen
		Experiment.gui.bg.validate(); 			  
		Experiment.gui.bg.repaint();
	}

	private void removeActionListeners(JButton button) {
		for (ActionListener al : button.getActionListeners()) {
			button.removeActionListener(al);
	    }
	}
}