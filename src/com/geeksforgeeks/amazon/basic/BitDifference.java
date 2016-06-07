package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

// You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.

public class BitDifference {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the first int
	    	int a = sc.nextInt();
	    	
	    	// Input the second int
	    	int b = sc.nextInt();
	    	
	    	System.out.println(calcDifference(a,b));

	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static int calcDifference(int a, int b)
	{
		// Execute XOR between A and B
		int C = a^b;
		
		// Create a variable that counts the number of 1's in the result
		int count = 0;
		
		// Iterate over the bits of the result
		for (char c : Integer.toBinaryString(C).toCharArray())
			if (c == '1')
				count++;
		
		return count;
	}

}
