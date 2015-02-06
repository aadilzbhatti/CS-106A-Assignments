/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */
import stanford.karel.*;
public class CheckerboardKarel extends SuperKarel {
	public void run() {
		putBeeper();
		while (frontIsClear()) {
			movement();
		}
		beeperPut();
		while (frontIsBlocked()) {
			oddPatternBlock();
		}
	}
	private void movement() {
		if (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				if (noBeepersPresent()) {
					putBeeper();
				}
			} else {
				uTurn();
				putBeeper();
			}
		}
	}
	private void uTurn() {
		if (frontIsBlocked()) {
			if (facingEast()) {
				turnLeft();
				move();
				turnLeft();
			} else {
				if (facingWest()) {
					turnRight();
					move(); 
					turnRight();
				}
			}
		}
	}
	private void beeperPut() {
		if (beepersPresent()) {
			move();
		} else {
			putBeeper();
		}
	}
	private void oddPatternBlock() {
		if (frontIsBlocked()) {
			if (beepersPresent()) {
				uTurn();
				move();
				putBeeper();
				movement();
			} else {
				if (noBeepersPresent()) {
					uTurn();
				}
			}
		}
	}
}