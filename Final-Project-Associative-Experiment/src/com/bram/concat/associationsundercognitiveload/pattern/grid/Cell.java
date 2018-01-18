package com.bram.concat.associationsundercognitiveload.pattern.grid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.JButton;

import com.bram.concat.associationsundercognitiveload.Options;

/**
 * A cell of the 4x4 grid.
 * Each cell may contain a dot, or be empty.
 */
@SuppressWarnings("serial")
public class Cell extends JButton {
	
	private DotIcon dot;
	
	/**
	 * True: this cell holds a dot.
	 */
	public boolean containsDot;
	
	Cell(boolean containsDot) {
		dot = new DotIcon((int) (Options.GRID_PIXELSIZE * 0.4));
		setBackground(Color.white);
		setFocusable(false);
		setEnabled(false);		
		if (containsDot) {
			addDot();
		} else {
			removeDot();
		}
	}
	
	/**
	 * Make sure this cell contains a dot.
	 */
	public void addDot() {
		this.containsDot = true;
		setIcon(dot);
	}
	
	/**
	 * Make sure this cell does not contain a dot.
	 */
	public void removeDot() {
		this.containsDot = false;
		setIcon(null);
	}

	private class DotIcon implements Icon {
		private int size;
		
		private DotIcon(int size) {
			this.size = size;
			setFocusable(false);
		}
		
		@Override
		public int getIconHeight() {
			return size;
		}

		@Override
		public int getIconWidth() {
			return size;
		}
		
		/**
		 * Draw the dot.
		 */
		@Override
		public void paintIcon(Component c, Graphics g, int w, int h) {					    
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Ellipse2D.Double circle = new Ellipse2D.Double(Options.GRID_PIXELSIZE / 2 - size / 2, Options.GRID_PIXELSIZE / 2 - size / 2, size, size);
			g2d.setColor(Color.black);
			g2d.fill(circle);						
		}						
	}	
}
