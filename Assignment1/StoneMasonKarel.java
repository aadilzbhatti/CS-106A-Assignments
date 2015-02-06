/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		turnLeft();
		while (frontIsClear()) {
			beeperz();
		}
		if(frontIsBlocked()) {
			if (beepersPresent()) {
				turnRight();
			} else {
				putBeeper();
					turnRight();
				}
		}
		for (int i=0; i<4; i++) {
			move();
		}
		if (facingEast()) {
			turnLeft();
		}
		while (frontIsClear()) {
			beeperz();
		}
		if (frontIsBlocked()) {
			turnAround();
		}
		while (frontIsClear()) {
			beeperz();
		}
		if (frontIsBlocked()) {
			turnLeft();
		}
		for (int i=0; i<4; i++) {
			move();
		}
		turnLeft();
		while (frontIsClear()) {
			beeperz();
		}
		if (frontIsBlocked()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
				
			turnRight();
		}
		for (int i=0; i<4; i++) {
			move();
		}
		turnLeft();
		if (frontIsClear()) {
				while (frontIsClear()) {
					beeperz();
				}
			if (frontIsBlocked()) {
				turnAround();
				while (frontIsClear()) {
					move();
				}
				if (frontIsBlocked()) {
					turnLeft();
				}
			}
			} else {
			turnAround();
			while (frontIsClear()) {
				beeperz();
			if (frontIsBlocked()) {
				turnLeft();
			}
			}
		}
	}
	private void beeperz() {
		if (noBeepersPresent()) {
			putBeeper();
		}
		if (beepersPresent()) {
			move();
		}
	}
}
