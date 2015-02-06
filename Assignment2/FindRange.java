/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private int number;
	private int Smallest;
	private int Largest;
	public void run() {
		println("This program finds the largest and smallest numbers.");
		DetermineRange();
	}
	private void DetermineRange() {
		int n1 = readInt("? ");
		if (n1 == 0) {
			println("Invalid first entry.");
			println("Smallest: "+Smallest+"");
			println("Largest: "+Largest+"");
			Smallest=n1;
			Largest=n1;
			} else {
			while (n1!=0) {
				number=readInt("? ");
				if (number<Smallest) {
					if (number !=0) {
						Smallest = number;
					}
				} else {
					if (number > Largest) {
						if (number !=0) {
								Largest = number;
						}
					}	
				}
				if (number==0) {
					println("Smallest: "+Smallest+"");
					println("Largest: "+Largest+"");
				}
			}
		}
	}
}

