package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

/*
	Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, write code to find the number of ways the 
	floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile.
	
	Input:
	
	The first line of input contains an integer T denoting the number of test cases.
	The first line of each test case is W.
	
	Output:
	
	Print number of ways the floor can be tiled in a separate line.
	
	Constraints:
	
	1 ≤ T ≤ 50
	1 ≤ W ≤ 70
	
	Example:
	
	Input
	2
	5
	3
	
	Output
	8
	3
 */
public class TileFloor {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the width 
	    	int w = sc.nextInt();
	    		            
	        // Print the prime numbers pair
	    	System.out.println(calc(w));
	        
	        t--;	            
	    }
	    
	    sc.close();

	}
	
	public static long calc(int W)
	{
		// Define an array the size of the width of the matrix
		long[] ways = new long[W];
		
		// Initialize the first two positions of the array the following way
		ways[0] = 1;			// Equivalent to the number of tiles that fit in a matrix width 1
		ways[1] = 2;			// Equivalent to the number of tiles that fit in a matrix width 2
		
		// Iterate over the matrix from position 2, and calculate all the following values
		for (int i = 2; i < W; i++)
		{
			// Calculate the number of ways of each position in the array
			// This means that the numbers of ways for position i is the sum of fixing one vertical tile and fixing two horizontal tiles
			ways[i] = ways[i-1] + ways[i-2];		
		}
		
		return ways[W-1];
	}

}
