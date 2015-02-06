/*
 * File: Breakout.java


 * -------------------
 * Name: Aadil Bhatti
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;


import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Container;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static int NTURNS = 3;

	/* Method: run() */
	/** Runs the Breakout program. */
	
	public void run() {
		LayBricks();
		PlacePaddle();		
		Ball();
	}
	
	//This method creates the breakout blocks and colors them. 
	private void LayBricks() {
		for (int i=0;i<NBRICK_ROWS;i++) {
			for (int s=0;s<NBRICKS_PER_ROW;s++) {
				block = new GRect (BRICK_SEP*i+BRICK_WIDTH*i,BRICK_SEP*s+BRICK_HEIGHT*s+BRICK_Y_OFFSET,BRICK_WIDTH,BRICK_HEIGHT);
				block.setFilled(true);	
				add(block);
				if (s<2) {
					block.setFillColor(Color.red);
				}
				if (s>1 && s<4) {
					block.setFillColor(Color.orange);
				}
				if (s>3 && s<6) {
					block.setFillColor(Color.yellow);
				}
				if (s>5 && s<8) {
					block.setFillColor(Color.green);
				}
				if (s>7 && s<10) {
					block.setFillColor(Color.cyan);
				}
			}
		}
	}
	//This method creates the breakout paddle and the subsequent methods deal with its trajectory.
	private void PlacePaddle() {
		paddle = new GRect ((WIDTH-PADDLE_WIDTH)/2,HEIGHT-PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		addMouseListeners();
	}
	//This method and the next method tie in the mouse as a controller for the paddle.
	public void mousePressed(MouseEvent e) {
		LastX = e.getX();
		LastY = e.getY();		
		Obj=getElementAt(LastX,LastY);
	}
	public void mouseDragged(MouseEvent e) {
		if (Obj != null) {
			Obj.move(e.getX()-LastX,(e.getY()-LastY)/(HEIGHT-PADDLE_Y_OFFSET));
			LastX=e.getX();
			LastY=e.getY();
			checkForCollisionPad();
		}
	}
	//This method stops the paddle from exiting the bounds of the window.
	private void checkForCollisionPad() {
		if (paddle.getX()+PADDLE_WIDTH > WIDTH) {
			paddle.setLocation(WIDTH-PADDLE_WIDTH,HEIGHT-PADDLE_Y_OFFSET);
		} else {
			if (paddle.getX() < 0) {
				paddle.setLocation(0,HEIGHT-PADDLE_Y_OFFSET);
			}
		}
	}
	
	/*The following methods detail the ball and its trajectory.
	 * The method below creates the ball.
	 */
	
	private void SetBall() {
		ball = new GOval (WIDTH/2, HEIGHT/2, 2*BALL_RADIUS,2*BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
		ball.sendToFront();
	}
	
	//The following method sets the ball's initial trajectory.
	private void MoveBall() {
		vx = rgen.nextDouble(1.0,3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		vy = 3.0;
		while (ball.getY() < HEIGHT) {
			ball.move(vx,vy);
			BallCollisionWall();			
			BallCollisionObject();
		}
	}
	
	//The following method details what happens when the ball hits a wall. 
	private void BallCollisionWall() {
		if (ball.getX() < 0) {
			pause (35);
			vx = -vx;
			ball.move(vx,vy);
		}
		if (ball.getX() + 2*BALL_RADIUS > WIDTH) {
			pause(35);
			vx = -vx;
			ball.move(vx,vy);
		}
		
		if (ball.getY() < 0) {
			pause(35);
			vy = -vy;
			ball.move(vx,vy);
		}
		if (ball.getY() +2*BALL_RADIUS > HEIGHT) {
			remove(ball);
			TurnEnd();
		}
	}
	//The following method assess what object the ball has hit (a brick or a paddle) and returns it.
	private GObject getCollidingObject() {
		ObjX = getElementAt (ball.getX(),ball.getY());
		if (ObjX != null) {
			return (ObjX);
		} else {
			ObjX = getElementAt (ball.getX() + 2*BALL_RADIUS, ball.getY());
			if (ObjX != null) {
				return (ObjX);
			} else {
				ObjX = getElementAt (ball.getX(), ball.getY() + 2*BALL_RADIUS);
				if (ObjX != null) {
					return (ObjX);
				} else {
					ObjX = getElementAt (ball.getX() + 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS);
					if (ObjX != null) {
						return (ObjX);
					}
				}
			}
		}
		return(ObjX);
	}
	//The following method assesses what the ball's trajectory is after hitting an object (a brick or the paddle). 
	private void BallCollisionObject() {
		collider = getCollidingObject();
		if (collider == paddle) {
			vy = -1.01*vy;
			pause(35);
			bounceClip.play();
			ball.move(vx,vy);
		} else {
			pause(35);			
			ball.move(vx, vy); 
		}
		if (collider != paddle && collider != null) {
			vy = -vy;
			pause(35);
			bounceClip.play();
			ball.move(vx, vy);
			remove(collider);
			AMT_BRICKS--;
			if (AMT_BRICKS == 0) {
				remove(ball);
				String str = "Congratulations! You've won the game!";
				label = new GLabel (str,(WIDTH-str.length()),HEIGHT/2);
				add(label);
				pause(500000);
			}
		}
	}
	
	//The following method combines all the ball-related methods to simplify for the run method. 
	private void Ball() {
		SetBall();
		MoveBall();
	}
	
	//The following method ends the turn for the player and begins a new one.
	private void TurnEnd() {
		NTURNS--;
		String str = "TURNS REMAINING: ";
		label = new GLabel (str + NTURNS,(WIDTH-str.length())/2,HEIGHT/2);
		add(label);
		pause(2000);
		remove(label);
		if (NTURNS > 0) {
			Ball();
		}
		if (NTURNS == 0) {
			removeAll();
			String s1 = "GAME OVER";
			label = new GLabel (s1,(WIDTH-s1.length())/2,HEIGHT/2);
			add(label);
		}
	}
	
	//constants and such
	private GRect block;
	private GRect paddle;
	private GObject Obj, ObjX;
	private GOval ball;
	private double LastX;
	private double LastY;
	private double vx,vy;
	private int AMT_BRICKS = 100;
	private GLabel label;
	private GObject collider;
	private int SCORE = 0;
	
	//Private instance variables
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
}
