/*
 * File: Hailstone.java
 * Name: Aadil Bhatti
 * Section Leader: Poopface McGee
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int cycle=0; 	// this will keep track of how many cycles have been executed 
		int n=readInt("Enter a number:");
		while (n!=1) {		// this ensures that n is an integer
			if (n % 2 != 0) { 	// this tests whether or not n is odd, by checking if it is divisible by 2
				print(n + " is odd, so I make 3n+1:"); 	// if it is not, the commands will be executed
				n=3*n+1; 	// this evaluates 3n+1. 
				println(n); 	// this prints the current value of n
			} else { 	// if n is divisible by 2, the following lines of code are executed
				if (n % 2 == 0) {	// added for clarity
					print(n + " is even, so I take half:");
					n=n/2;
					println(n);
				}
			}
			cycle++; // this will evaluate how many cycles have taken place to achieve the goal
		}
		println("The process took "+cycle+" cycles to reach 1.");
	}
}

