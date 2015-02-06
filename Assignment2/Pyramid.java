/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		LayBricks();
	} 
	private void LayBricks() {
		// this method creates the brick pyramid using two 'for' statements.
		for (int row=0;row<14;row++) {
			for (int i=0;i<BRICKS_IN_BASE-row;i++) {
				add (new GRect(BRICK_WIDTH*(1+0.5*row)+BRICK_WIDTH*i,400-row*BRICK_HEIGHT, BRICK_WIDTH,BRICK_HEIGHT));
			}
		}
		getWidth();
		getHeight();
	}
}

