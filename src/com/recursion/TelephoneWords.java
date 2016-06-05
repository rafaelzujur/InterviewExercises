package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class TelephoneWords {
	private Map<Integer, String[]> keypadMap;
	private StringBuilder output;
	private int count = 0;
	
	public static void main(String[] args) {
		/*
		TelephoneWords tw = new TelephoneWords();
		
		String phoneNumber = "4971927";
		
		tw.printTelephoneWords(phoneNumber);
		
		System.out.println("N is " + phoneNumber.length());
		System.out.println("BigO " + tw.count);
		*/
		System.out.println("2".compareTo("1"));
	}

	public TelephoneWords() {
		this.output = new StringBuilder();
		loadKeypadMap();
	}

	private void loadKeypadMap()
	{
		this.keypadMap = new HashMap<Integer, String[]>();
		
		// Loads keypad #1
		this.keypadMap.put(1, new String[]{"1"});
		
		// Loads keypad #2
		this.keypadMap.put(2, new String[]{"A","B","C"}); 
		
		// Loads keypad #3
		this.keypadMap.put(3, new String[]{"D","E","F"});
		
		// Loads keypad #4
		this.keypadMap.put(4, new String[]{"G","H","I"});
		
		// Loads keypad #5
		this.keypadMap.put(5, new String[]{"J","K","L"});
		
		// Loads keypad #6
		this.keypadMap.put(6, new String[]{"M","N","O"});
		
		// Loads keypad #7
		this.keypadMap.put(7, new String[]{"P","R","S"});
		
		// Loads keypad #8
		this.keypadMap.put(8, new String[]{"T","U","V"});
		
		// Loads keypad #9
		this.keypadMap.put(9, new String[]{"W","X","Y"});
		
		// Loads keypad #0
		this.keypadMap.put(0, new String[]{"0"});
		
	}
	
	public void printTelephoneWords(String phoneNumber)
	{
		
		print(phoneNumber, 0);
	}

	private void print(String phoneNumber, int currentIndex)
	{
		if (this.output.length() == phoneNumber.length()) 		// Base case
		{
			// Prints the word that has been generated so far
			System.out.println(this.output);
			
			// Increases the counter
			this.count++;
			
			// Exits the function
			return;
		}
		else {													// Recursive case
			// Gets the number with the current index
			Integer key = phoneNumber.charAt(currentIndex) - '0';
			
			// Gets the array of letters associated to the keypad
			String[] letters = this.keypadMap.get(key);
			
			// Creates a boolean array to keep track of the keys already used
			//boolean[] usedLetters = new boolean[letters.length];
			
			// Iterates over the keys
			for (int i = 0; i < letters.length; i++)
			{
				// If the letter has been used, continue iterating
				//if (usedLetters[i]) continue;
				
				// Adds the letter to the output
				this.output.append(letters[i]);
				
				// Marks the letter as used
				//usedLetters[i] = true;
				
				// Recursion call with the following number
				print(phoneNumber, currentIndex+1);
				
				// Deletes the last character of the output
				this.output.setLength(this.output.length()-1);
			}
		}	
	}
	
}
