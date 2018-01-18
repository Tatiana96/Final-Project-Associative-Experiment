package com.bram.concat.associationsundercognitiveload.pattern.validity;

/**
 * Check whether the pattern does not have two vertically or horizontally adjacent dots, nor three or four dots in either diagonal.
 */
public abstract class NoAdjacencies {
	
	/**
	 * Check whether the indicated pattern does not have two vertically or horizontally adjacent dots, nor three or four dots in either diagonal.
	 * @param squares The pattern to investigate.
	 * @return True when the pattern holds up to these criteria.
	 */
	public static boolean validByAdjacencies(int[][] squares) {
		int d1sum = 0; //number of ones in the bottom-left to top-right diagonal
		int d2sum = 0; //number of ones in the top-left to bottom-right diagonal
		for (int i = 0; i < 4; i++) {
			d1sum += squares[3-i][i];
			d2sum += squares[i][i]; 
			
			for (int j = 0; j < 4; j++) {
				if (squares[i][j] == 1) { //there's a dot on this square: make sure there are no horizontal/vertical neighbors
					
					if (i < 3 && squares[i + 1][j] == 1) {
						return false; //there's a dot to the right of this dot: try again
					}
					
					if (i > 0 && squares[i - 1][j] == 1) {
						return false; //there's a dot to the left of this dot: try again
					}
					
					if (j < 3 && squares[i][j + 1] == 1) {
						return false; //there's a dot on top of this dot: try again
					}
					
					if (j > 0 && squares[i][j - 1] == 1) {
						return false; //there's a dot below this dot: try again
					}
				}
			}
		}
		if (d1sum > 2 || d2sum > 2) return false; //more than two dots in either diagonal: try again
		return true;
	}
}
