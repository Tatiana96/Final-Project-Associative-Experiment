package com.bram.concat.associationsundercognitiveload.pattern.validity;

import java.util.Arrays;

public abstract class MirrorAndRotation {
	
	/**
	 * Check whether the indicated pattern is valid according to the mirror method.
	 * @param squares The pattern to investigate.
	 * @return True if the pattern is valid according to this approach.
	 */
	public static boolean validByMirroring(int[][] squares) {				
		int[][] original 			= squares;
		int[][] originalRight90  	= rotateRight(original);
		int[][] originalRight180 	= rotateRight(originalRight90); // = horizontally mirrored
		int[][] originalRight270 	= rotateRight(originalRight180);// = left 90
		
		int[][] mirrored  		 	= mirrorVertically(original);
		int[][] mirroredRight90  	= rotateRight(mirrored);
		int[][] mirroredRight180 	= rotateRight(mirroredRight90); // = horizontally mirrored
		int[][] mirroredRight270 	= rotateRight(mirroredRight180);// = left 90
		
		int[][][] patterns = { original, originalRight90, originalRight180, originalRight270, 
					           mirrored, mirroredRight90, mirroredRight180, mirroredRight270 };
		
		for (int i = 0; i < patterns.length; i++) {
			for (int j = i; j < patterns.length; j++) {
				if (j > i && Arrays.deepEquals(patterns[i], patterns[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int[][] rotateRight(int[][] squares) {
		int[][] rotate90right = new int[4][4];
		for (int row = 0; row < 4; row++) {
		    for (int col = 0; col < 4; col++) {
		         rotate90right[row][col] = squares[4 - col - 1][row];
		    }
		}
		return rotate90right;
	}
	
	private static int[][] mirrorVertically(int[][] squares) {
		int[][] mirrorVertically = new int[4][4];
		for (int row = 0; row < 4; row++) {
		    for (int col = 0; col < 4; col++) {
		    	mirrorVertically[row][3-col] = squares[row][col];
		    }
		}
		return mirrorVertically;
	}	
}
