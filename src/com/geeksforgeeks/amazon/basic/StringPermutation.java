package com.geeksforgeeks.amazon.basic;

import java.util.Arrays;
import java.util.Scanner;

/*
	Given a string, print all permutations of a given string.
	
	Input:
	
	The first line of input contains an integer T denoting the number of test cases.
	Each test case contains a single string in capital letter.
	
	Output:
	
	Print all permutations of a given string with single space and all permutations should be in lexicographically increasing order.
	
	Constraints:
	
	1 ≤ T ≤ 10
	1 ≤ size of string ≤ 5
	
	Example:
	
	Input:
	2
	ABC
	
	ABSG
	
	Output:
	ABC ACB BAC BCA CAB CBA 
	
	ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA 
 */

public class StringPermutation {
	
	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	String str = sc.next();
	    	
	    	init(str);
	    	
	        t--;	            
	    }	    
	    sc.close();
	}
	
	private static void init(String str)
	{
		boolean[] used = new boolean[str.length()];
		StringBuffer sf = new StringBuffer();
		StringBuffer result = new StringBuffer();
		
		// Sort the string alphabetically
		char[] sortedStr = str.toCharArray();
		Arrays.sort(sortedStr);
		
		permute(sortedStr, used, sf, result);
		
		System.out.println(result.toString().trim());
	}
	
	private static void permute(char[] str,  boolean[] used, StringBuffer sf, StringBuffer result)
	{
		// Base case
		if (sf.length() == str.length)
		{
			result.append(sf.toString().trim() + " ");
			return;
		}
		// Recursion Case
		else
		{
			// Iterate over each letter of the string
			for (int i = 0; i < str.length; i++)
			{
				// Check the letter is not being used
				if (!used[i])
				{ // The letter is NOT being used
					sf.append(str[i]);
					
					// Mark the letter as used
					used[i] = true;
					
					// Recursive call
					permute(str, used, sf, result);
					
					// Remove the last letter from the string buffer
					sf = sf.deleteCharAt(sf.length()-1);
					
					// Mark the letter as not used
					used[i] = false;
				}
			}
		}
	}

}
