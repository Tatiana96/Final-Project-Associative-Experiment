package com.bram.concat.associationsundercognitiveload.gui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.bram.concat.associationsundercognitiveload.Options;
import com.bram.concat.associationsundercognitiveload.Text;

/**
 * Class to assist with the layout of the experiment.
 */
@SuppressWarnings("serial")
public class Gui extends JFrame {
	
	/**
	 * Contains whatever is currently showing, e.g. the introduction, the actual experiment, ...
	 */
	protected Container bg;
				
	/**
	 * Contains the dot-pattern, a fixation-cross, the pattern-reproduction screen, or a blank screen.
	 */
	public ExperimentPanel xpPane;

	/**
	 * Contains a text message; either the main instructions, the post-training instructions, or the goodbye text.
	 */
	public InstructionPanel instructionPanel;
	
	/**
	 * Used to hide the cursor (we can't actually hide it, so we replace it with an empty image).
	 */
	private Cursor blankCursor;
	
	/**
	 * Initialize the layout
	 */
	public Gui() {
		setTitle(Text.TEXT_WINDOW_TITLE);					//set the application's title
		setUndecorated(!Options.DECORATED);				//removes title bar and close buttons if necessary
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize(Options.screenSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exit, stop all processes
		setVisible(true);								//display the frame

		blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");
		bg = getContentPane();							//bg contains whatever we are currently displaying
		xpPane = new ExperimentPanel(); 				//create the panel that holds the experiment
		instructionPanel = new InstructionPanel();		//create the panel that displays instructions/goodbye text
	}
	
	/**
	 * Restore the default cursor.
	 */
	public void showCursor() {
		setCursor(Cursor.getDefaultCursor());
	}
	
	/**
	 * Replace the cursor with an empty image, effectively hiding it.
	 */
	public void hideCursor() {
		setCursor(blankCursor);
	}
	
	/**
	 * Display the screen that asks for the participants basic info.
	 */
	public void showSsInfo() {
		SsInfoPanel info = new SsInfoPanel(); //create the screen
		bg.add(info);						  //add it to the background
		bg.validate();				
		bg.repaint();
		info.snTextField.grabFocus(); 		  //set focus to usernumber field, to allow the user to type without clicking something first
	}				
		
	/**
	 * Display the actual experiment.
	 */
	public void showXP() {
		bg.removeAll(); //remove the introduction panel
		bg.add(xpPane); //add the experiment panel
		bg.validate();  //repaint background
		bg.repaint();		
	}		
}