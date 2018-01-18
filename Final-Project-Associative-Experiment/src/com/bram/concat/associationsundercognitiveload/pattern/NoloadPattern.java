package com.bram.concat.associationsundercognitiveload.pattern;

import com.bram.concat.associationsundercognitiveload.pattern.grid.Grid;
import com.bram.concat.associationsundercognitiveload.pattern.grid.ReproductionGrid;

/**
 * An empty grid, used for pattern reproduction.
 */
public class NoloadPattern extends Pattern{	
	public NoloadPattern() {
		super(NOLOAD);	
	}
	
	@Override
	protected Grid createGrid() {
		return new ReproductionGrid(new int[NCELLS][NCELLS]); //reproduction grid: cells are clickable
	}
	
	/**
	 * Removes all dots, ran before presenting the grid. (The dots were added at reproduction phase of the previous trial.)
	 */
	public void clearDots() {
		for (int row = 0; row < NCELLS; row++) {
			for (int col = 0; col < NCELLS; col++) {
				grid.cells[row][col].removeDot();
			}
		}	
	}
}