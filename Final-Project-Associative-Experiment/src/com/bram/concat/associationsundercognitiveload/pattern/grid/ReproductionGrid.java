package com.bram.concat.associationsundercognitiveload.pattern.grid;

/**
 * A 4x4 grid in which the user can create a pattern (reproducing the one memorized earlier).
 */
@SuppressWarnings("serial")
public class ReproductionGrid extends Grid {

	public ReproductionGrid(int[][] squares) {
		super(squares); //this will call createCells		
	}
	
	@Override
	protected void createCells(int[][] squares) {
		cells = new ReproductionCell[NCELLS][NCELLS];
		
		for (int row = 0; row < NCELLS; row++) {
			for (int col = 0; col < NCELLS; col++) {
				cells[row][col] = new ReproductionCell();
				add(cells[row][col]);
			}
		}	
	}
}
