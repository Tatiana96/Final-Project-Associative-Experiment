package com.bram.concat.associationsundercognitiveload.pattern.grid;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.bram.concat.associationsundercognitiveload.pattern.Pattern;

/**
 * A 4x4 grid containing 16 cells, each of which may contain a dot, forming a pattern.
 */
@SuppressWarnings("serial")
public class Grid extends JPanel {		
	public static int NCELLS = Pattern.NCELLS;	
	public Cell[][] cells;
	
	/**
	 * Create an empty grid, then populate it with a pattern.
	 * @param squares Which cells contain a dot.
	 */
	public Grid(int[][] squares) { 
		super(new GridLayout(NCELLS,NCELLS));	 //empty grid	
		createCells(squares); //populate it
	}
	
	protected void createCells(int[][] squares) {
		cells = new Cell[NCELLS][NCELLS];
		
		for (int row = 0; row < NCELLS; row++) {
			for (int col = 0; col < NCELLS; col++) {
				cells[row][col] = new Cell(squares[row][col] == 1);
				add(cells[row][col]);
			}
		}	
	}
}