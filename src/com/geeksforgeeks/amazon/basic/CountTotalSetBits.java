package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

// Find the sum of all bits from numbers 1 to N.

public class CountTotalSetBits {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input N
	    	int N = sc.nextInt();
	    	
	    	System.out.println(countTotalBits(N));

	        t--;	            
	    }
	    
	    sc.close();
	}
	
	public static int countTotalBits(int N)
	{
		// Create variable that counts total bits
		int sum = 0;
		
		for (int i = 1; i <= N; i++ )
			sum += countBits(i);
		
		return sum;
	}
	
	public static int countBits(int number)
	{
		// Create variable that counts the number of bits
		int count = 0;
		
		while (number != 0)
		{
			// Perform AND operator with 1
			if ((number & 1) == 1)
				count++;
			
			// Shift right one bit. E.g. 1111 >>> 1 => 0111
			number = number >>> 1;
		}
		
		return count;
	}

}
