package com.geeksforgeeks.amazon.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeypadTyping {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the given number
	    	String str = sc.next();
	    		            
	        // Print the prime numbers pair
	    	printKeys(str);
	        
	        t--;	            
	    }
	    
	    sc.close();

	}
	
	private static void printKeys(String str)
	{
		Map<Character, Integer> keymap = getKeyMap();
		StringBuffer sf = new StringBuffer();
		
		// converts the string to lower case
		str = str.toLowerCase();
		
		// Iterate over the string
		for (int i = 0; i < str.length(); i++)
		{
			if (keymap.containsKey(str.charAt(i)))
				sf.append(keymap.get(str.charAt(i)));
		}
		
		System.out.println(sf.toString().trim());
	}
	
	private static Map<Character, Integer> getKeyMap()
	{
Map<Character, Integer> keyRef = new HashMap<Character, Integer>();
		
		// Fill the map with all letters
		keyRef.put('a', 2);
		keyRef.put('b', 2);
		keyRef.put('c', 2);
		keyRef.put('d', 3);
		keyRef.put('e', 3);
		keyRef.put('f', 3);
		keyRef.put('g', 4);
		keyRef.put('h', 4);
		keyRef.put('i', 4);
		keyRef.put('j', 5);
		keyRef.put('k', 5);
		keyRef.put('l', 5);
		keyRef.put('m', 6);
		keyRef.put('n', 6);
		keyRef.put('o', 6);
		keyRef.put('p', 7);
		keyRef.put('q', 7);
		keyRef.put('r', 7);
		keyRef.put('s', 7);
		keyRef.put('t', 8);
		keyRef.put('u', 8);
		keyRef.put('v', 8);
		keyRef.put('w', 9);
		keyRef.put('x', 9);
		keyRef.put('y', 9);
		keyRef.put('z', 9);
		
		return keyRef;
	}

}
