/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.*;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		
		removeAll();
		
		GLine scaffold = new GLine (225 - BEAM_LENGTH, HEIGHT, 225 - BEAM_LENGTH, HEIGHT + SCAFFOLD_HEIGHT);
		GLine rope = new GLine (225, HEIGHT, 225, HEIGHT + ROPE_LENGTH);
		GLine beam = new GLine (225, HEIGHT, 225 - BEAM_LENGTH, HEIGHT);
		
		add(rope);
		add(beam);
		add(scaffold);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		guess = new GLabel(word);
		Font myFont = new Font("SansSerif", Font.PLAIN, 28);
		guess.setFont(myFont);
		guess.setLocation(225 - guess.getWidth()/2, 1.5 * HEIGHT + SCAFFOLD_HEIGHT);
		guess.setVisible(true);
		guess.sendToFront();
		add(guess);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */	
	public void noteIncorrectGuess(char letter) {
		
		reset();
		
		str += letter;
		incorrect = new GLabel(str);
		Font newFont = new Font ("SansSerif", Font.PLAIN, 16);
		incorrect.setFont(newFont);
		incorrect.setLocation(225 - guess.getWidth()/2, 2 * HEIGHT + SCAFFOLD_HEIGHT);
		incorrect.setVisible(true);
		incorrect.sendToFront();
		add(incorrect);
		
		wrongChoice++;
		
		switch (wrongChoice) {
		
			case 8:
				GLine foot2 = new GLine ((getWidth() - 2*HIP_WIDTH)/2 + 2*HIP_WIDTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, (getWidth() - 2 * HIP_WIDTH)/2 + 2 * HIP_WIDTH + FOOT_LENGTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
				add(foot2);
				foot2.setVisible(true);
				
				GOval mouth = new GOval ((getWidth() - (HEAD_RADIUS/3))/2, HEIGHT + 4*ROPE_LENGTH, HEAD_RADIUS/3, HEAD_RADIUS/3);
				add(mouth);
				mouth.setVisible(true);
				
				GLabel leftEye = new GLabel ("X");
				leftEye.setLocation((getWidth() - 2*HEAD_RADIUS)/2 + ROPE_LENGTH, (getWidth() - HEAD_RADIUS)/2 - 1.5 * HEAD_RADIUS);
				add(leftEye);
				
				GLabel rightEye = new GLabel ("X");
				rightEye.setLocation((getWidth() - 2*HEAD_RADIUS)/2 + 2.7*ROPE_LENGTH, (getWidth() - HEAD_RADIUS)/2 - 1.5 * HEAD_RADIUS);
				add(rightEye);
			
			case 7: 
				GLine foot1 = new GLine ((getWidth() - 2*HIP_WIDTH)/2, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, (getWidth() - 2 * HIP_WIDTH)/2 - FOOT_LENGTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);	
				add(foot1);
				foot1.setVisible(true);
		
			case 6:
				GLine leg2 = new GLine ((getWidth() - 2*HIP_WIDTH)/2 + 2*HIP_WIDTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, (getWidth() - 2*HIP_WIDTH)/2 + 2*HIP_WIDTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
				add(leg2);
				leg2.setVisible(true);
				
		
			case 5:
				GLine hip = new GLine ((getWidth() - 2*HIP_WIDTH)/2, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, (getWidth() - 2*HIP_WIDTH)/2 + 2*HIP_WIDTH, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
				add(hip);
				hip.setVisible(true);
				
				GLine leg1 = new GLine ((getWidth() - 2*HIP_WIDTH)/2, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH, (getWidth() - 2*HIP_WIDTH)/2, HEIGHT + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
				add(leg1);
				hip.setVisible(true);
		
			case 4:
				GLine upperArm2 = new GLine ((getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth() - 2 * HEAD_RADIUS)/2 + HEAD_RADIUS + UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
				add(upperArm2);
				upperArm2.setVisible(true);
				
				GLine lowerArm2 = new GLine ((getWidth() - 2 * HEAD_RADIUS)/2 + HEAD_RADIUS + UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth() - 2 * HEAD_RADIUS)/2 + HEAD_RADIUS + UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
				add(lowerArm2);
				lowerArm2.setVisible(true);
			
			case 3:
				GLine upperArm1 = new GLine ((getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS - UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
				add (upperArm1);
				upperArm1.setVisible(true);
				
				GLine lowerArm1 = new GLine ((getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS - UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS - UPPER_ARM_LENGTH, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
				add(lowerArm1);
				lowerArm1.setVisible(true);
				
			case 2:
				GLine body = new GLine((getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS, (getWidth() - 2*HEAD_RADIUS)/2 + HEAD_RADIUS, HEIGHT + ROPE_LENGTH + 2*HEAD_RADIUS + BODY_LENGTH);
				add(body);
				body.setVisible(true);
		
			case 1: 
				GOval head = new GOval ((getWidth() - 2*HEAD_RADIUS)/2, HEIGHT + ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
				add (head);
				head.setVisible(true);
				break;
				
				
		}
	}
	
	public void removeLabel() {
		
		guess.setVisible(false);
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int HEIGHT = 100;
	
	private String str = "";
	private GLabel guess, incorrect;
	int wrongChoice = 0;
	
	
}
