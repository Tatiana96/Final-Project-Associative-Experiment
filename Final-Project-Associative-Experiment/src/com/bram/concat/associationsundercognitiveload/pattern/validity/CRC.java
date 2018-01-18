package com.bram.concat.associationsundercognitiveload.pattern.validity;

public abstract class CRC {	
	
	/**
	 * Any pattern with a CRC value below this is accepted.
	 * This value was computed as follows:
	 * 		Calculated the CRC value of 50000 patterns of four dots placed completely randomly in a 4x4 matrix.
	 * 		The cutoff value of 0.329 corresponds to the mean of the 50000 values minus the standard deviation. 
	 */
	public static final double CRC_CUTOFF = 0.3293491;
	
	/**
	 * Check whether the pattern in the indicated squares is valid according to the CRC method.
	 * @param squares The pattern to investigate.
	 * @return True if the CRC value of the pattern is below {@code CRC_CUTOFF}.
	 */
	public static boolean validByCrc(int[][] squares) {
		return computeCrc(squares) < CRC_CUTOFF;
	}	
	
	/**
	 * Calculate the CRC value of the indicated pattern.
	 * @param squares The pattern to investigate
	 * @return	The CRC value of the indicated pattern.
	 */
	private static double computeCrc(int[][] squares) {
		//calculate CR
		double numerator = 0;	//start by computing the numerator
		
		for (int row = 0; row < 4; row++) {				
			double pi = 0; //nb of dots in this row divided by total number of dots
			
			for (int col = 0; col < 4; col++) {
				pi += squares[row][col];
			}
			
			pi = pi / 4;
			
			if (pi != 0) {
				numerator += pi * log2(1/pi); //avoid division by zero; we assume that 0 * Log₂0 = 0			
			}
		}
		double cr = 1 - numerator / log2(4);
		
		//calculate CC
		numerator = 0;		
		for (int col = 0; col < 4; col++) {		
			double pi = 0; //nb of dots in this col divided by total number of dots
			
			for(int row = 0; row < 4; row++) {
				pi += squares[row][col]; 
			}
			
			pi = pi / 4;
			
			if (pi != 0) {
				numerator += pi * log2(1/pi); //avoid division by zero; we assume that 0 * Log₂0 = 0			
			}
		}		
		double cc = 1 - numerator / log2(4);
		
		return 1 - (( 1 - cr ) * ( 1 - cc)); //return CRC
	}
	
	/**
	 * Returns the log2 of the indicated value.
	 */
	private static double log2(double val) {
		return Math.log(val) / Math.log(2);
	}
}
