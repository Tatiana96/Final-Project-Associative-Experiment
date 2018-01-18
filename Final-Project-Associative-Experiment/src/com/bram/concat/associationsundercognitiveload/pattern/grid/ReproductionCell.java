package com.bram.concat.associationsundercognitiveload.pattern.grid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A cell of the 4x4 grid that can be clicked by the user to add/remove dots.
 * This allows the user to recreate a pattern they previously memorized.
 */
@SuppressWarnings("serial")
public class ReproductionCell extends Cell implements ActionListener {
	protected ReproductionCell() {
		super(false);
		addActionListener(this);
		setEnabled(true);
	}	
	
	/**
	 * Cell was clicked: if it contained a dot, remove it; else, add a dot.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (containsDot) {
			removeDot();
		} else {
			addDot();	
		}
	}
}