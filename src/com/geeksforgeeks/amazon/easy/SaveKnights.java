package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class SaveKnights {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the chess board
	    	int N = sc.nextInt();
	    	
	    	System.out.println(calc(N));

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static int calc(int N)
	{
		// Calculate the number of knights in a single even row
		int knightsInEvenRow = N-(N/2);
		
		// Calculate the number of knights in a single odd row
		int knightsInOddRow = N%2 == 0 ? knightsInEvenRow : knightsInEvenRow-1;
		
		return knightsInEvenRow*knightsInEvenRow + knightsInOddRow*knightsInOddRow;
	}

}
