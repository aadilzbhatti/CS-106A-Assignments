/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	

private static final int PROG_RECT_LOC_X=325;	
private static final int PROG_RECT_LOC_Y=150;
private static final int RECT_HEIGHT=30;
private static final int RECT_WIDTH=110;

	public void run() {
		AddRectangles();
		AddLabels();
		AddLines();
	}
	private void AddRectangles() {
		GRect Program=(new GRect(PROG_RECT_LOC_X,PROG_RECT_LOC_Y,RECT_WIDTH,RECT_HEIGHT));
			add(Program);
		GRect ConsoleProgram=(new GRect(PROG_RECT_LOC_X,PROG_RECT_LOC_Y+75,RECT_WIDTH,RECT_HEIGHT));
			add(ConsoleProgram);
		GRect DialogProgram=(new GRect(440,PROG_RECT_LOC_Y+75,RECT_WIDTH,RECT_HEIGHT));
			add(DialogProgram);
		GRect GraphicsProgram=(new GRect(200,PROG_RECT_LOC_Y+75,RECT_WIDTH,RECT_HEIGHT));
			add(GraphicsProgram);
	}
	private void AddLabels() {
		GLabel Program=(new GLabel("Program",353,170));
			add(Program);
		GLabel ConsoleProgram=(new GLabel("ConsoleProgram",333,245));
			add(ConsoleProgram);
		GLabel DialogProgram=(new GLabel("DialogProgram",453,245));
			add(DialogProgram);
		GLabel GraphicsProgram=(new GLabel("GraphicsProgram",205,245));
			add(GraphicsProgram);
	}
	private void AddLines() {
		GLine ConsoleProgram=(new GLine(380,180,380,225));
			add(ConsoleProgram);
		GLine DialogProgram=(new GLine(380,180,495,225));
			add(DialogProgram);
		GLine GraphicsProgram=(new GLine(380,180,255,225));
			add(GraphicsProgram);
	}
}

