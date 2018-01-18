package com.bram.concat.associationsundercognitiveload.pattern;

import com.bram.concat.associationsundercognitiveload.pattern.grid.Grid;

/**
 * Create a pattern of four dots, all on the same line or column (which line/column is randomized). 
 * Randomization was verified: 1000000 runs returns r1/r2/r3/r4/c1/c2/c3/c4: 124523/125240/125266/125180/125350/124737/125087/124617 
 */
public class LowloadPattern extends Pattern {	
	
	public LowloadPattern() {
		super(LOWLOAD);		
	}
	
	@Override
	protected Grid createGrid() {
		return new Grid(createPattern());
	}
	
	/**
	 * @return A 4x4 matrix with one row or column of 1's.
	 */
	private int[][] createPattern() {
		int[][] squares = new int[NCELLS][NCELLS];
		int n = RAND.nextInt(NCELLS);		
		
		if (RAND.nextBoolean()){ //make a column of ones
			for (int i = 0; i < squares.length; i++) {
				squares[i][n] = 1;
			}
		} else {  //make a row of ones
			for (int i = 0; i < squares.length; i++) {
				squares[n][i] = 1;
			}
		}
		return squares;
	}
}