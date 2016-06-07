package com.geeksforgeeks.amazon.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveCharacter {

	public static void main(String[] args) {
		
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	String s1 = sc.next();
	    	
	    	// Input the size of the array
	    	String s2 = sc.next();
	    	
	    	System.out.println(removeCharacters(s1, s2));

	        t--;	            
	    }
	    
	    sc.close();
	}

	private static String removeCharacters(String s1, String s2)
	{
		// Create a string buffer that will contain the final string
		StringBuffer sb = new StringBuffer();
		
		// Create a Set of chars containing the second string
		Set<Character> set = new HashSet<Character>();
	
		for (Character c : s2.toCharArray())
		{
			set.add(c);			
		}
		
		// Iterate over the first string characters
		for (Character c : s1.toCharArray())
		{
			// Include the character only if it does not exist in the set
			if (!set.contains(c))
			{
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
}
