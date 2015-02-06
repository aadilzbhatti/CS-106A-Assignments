/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.io.IOException;
import java.lang.*;

public class Hangman extends ConsoleProgram {
	
	int lexLength;
	String lexicon;
	String guessWork = "";
	String st = "-";
	
	int num_guesses = 8;
	
	HangmanCanvas canvas = new HangmanCanvas();
	
	//Main method
	
	public static void main (String[] args) {
		new Hangman().start(args);
	}
	
    public void run() {
    	
    	setCanvas(canvas);
    	
    	try {
    		
			chooseWord();
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
    	
    	guessWord(lexicon, canvas);
    	
    }
    
   /*
    * The following statements coincide with the original stub consisting of nine words. 
    * RandomGenerator rgen = new RandomGenerator();
    * int rand = rgen.nextInt(9);
    */
   
    //Chooses the word based on the HangmanLexicon class
    
    public void chooseWord() throws IOException {
    	
    	HangmanLexicon newLex = new HangmanLexicon();
    	lexicon = newLex.returnWord();
    	lexLength = lexicon.length();
    	
    	for (int i = 0; i < lexLength; i++) {
    		guessWork += st;
    	}
    	
    	println("Welcome to Hangman!");
    	
    }
    
    //Reads a guess in the form of a character
    
    public char readGuess() {
    	
    	String str = readLine ("Your guess: ");
    	
    	if (str.length() > 1) {
    		
    		println("Illegal guess. Try again: ");
    		readGuess();
    		
    	}
    	
    	str = str.toUpperCase();
    	char ch = str.charAt(0);
    	return ch;
    }
    
    //Based on the guess, determines if the guess is correct and if so updates the string, else deducts a guess + adds body parts.
    
    public void guessWord(String s, HangmanCanvas canvas) {
    	    	
    	while (true) {
    		
    		
    		println("The word now looks like this: " + guessWork);
    		println("You have " + num_guesses + " guesses left.");
    		drawWord(canvas, guessWork);
    		
        	StringBuilder temp = new StringBuilder(guessWork);
    		char guess = readGuess();
        	checkGuess(guess, s, temp, canvas);
        	
        	if (checkLoss()) {
        		println("You're completely hung.\nThe word was: " + s);
        		break;
        	}
        	
        	if (checkWin(guessWork, s)) {
        		drawWord(canvas, guessWork);
        		println("You guessed the word: " + s);
        		break;
        	}
    		
    	}
    	
    }
    
    //Checks if the guess was correct or not
    
    public void checkGuess(char ch, String str, StringBuilder str2, HangmanCanvas canvas) {
    	
    	boolean wrongGuess = true;
    	
    	for (int i = 0; i < lexLength; i++) {
    		
    		if (str.charAt(i) == ch) {
    			
    			str2.setCharAt(i, ch);
        		wrongGuess = false;
        		
    		}
    	}
    	
    	guessWork = str2.toString();
    	
		if (wrongGuess) {
			
			println("There are no " + ch + "'s in the word.");
			num_guesses--;
			canvas.reset();
			canvas.noteIncorrectGuess(ch);
			
		} else {
			
			canvas.removeLabel();
			println("That guess is correct.");
			
		}
    }
    
    //Checks if the game has been won or not
    
    public boolean checkWin(String str1, String str2) {
    	
    	boolean win = false;
    	
    	if (str1.equalsIgnoreCase(str2)) {
    		
    		win = true;
    	}
    	
    	return win;
    }
    
    //Likewise, this method checks if the game has benen lost or not
    
    public boolean checkLoss() {
    	
    	boolean loss = false;
    	
    	if (num_guesses == 0) {
    		
    		loss = true;
    	}
    	
    	return loss;
    }
    
    //This method sets up the canvas
    
    public void setCanvas(HangmanCanvas canvas) {
    	
    	setSize(900, 600);
    	canvas.reset();
    	setLayout(new GridLayout(1, 2));
    	add(canvas);
    	validate();
    	
    }
    
    //This method draws the initial word
    
    public void drawWord(HangmanCanvas canvas, String s) {
    	
    	canvas.displayWord(s);
    	
    }
}
