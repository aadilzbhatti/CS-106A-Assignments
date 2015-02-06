/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;

import java.io.*;
import java.util.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return reader.size();
	}

/** Returns the word at the specified index. */
	public String getWord() {
		
		//Original stub index
		/*switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		
		}*/
		
		RandomGenerator rgen = new RandomGenerator();
		int idx = rgen.nextInt(reader.size());
		return reader.get(idx);
		
	}
	
	//Constructer for HangmanLexicon class. Essentially opens the file and reads words into an ArrayList.
	
	public HangmanLexicon() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		
		while (true) {
			
			try {
				
				read = br.readLine();
				if (read == null) break;
				
				reader.add(read);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		br.close();
		
		lex = getWord();
		
	}
	
	//Returns the word chosen by the constructor.
	
	public String returnWord() {
		
		return lex;
	}
	
	
	private String lex;
	private String read;
	public ArrayList<String> reader = new ArrayList<String>();
	
}
