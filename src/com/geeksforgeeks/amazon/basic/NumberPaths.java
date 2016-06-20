package com.geeksforgeeks.amazon.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPaths {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the rows of the matrix
	    	int M = sc.nextInt();
	    	
	    	// Input the columns of the matrix
	    	int N = sc.nextInt();
	    	
	    	System.out.println(countPaths(0, M, N));

	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static int countPaths(int start, int M, int N)
	{
		// Define the variable that contains the number of paths
		int totalPaths = 0;
		
		// Define base case
		if (start == (M*N)-1) // Check the starting index is the element at the bottom right corner of the matrix
			return 1;
		// Define recursive case
		else
		{
			// Create a list containing the elements where this element can move to
			List<Integer> nextList = new ArrayList<Integer>();
					
			// Check the current element can go right
			if (start%N < N-1)
			{ // The current element is not at the end of the row. It can go right
				nextList.add(start+1);
			}
			
			// Check the current element can go down
			if (start/N < M-1)
			{ // The current element is not in the last row
				nextList.add(start+N);
			}
			
			// Iterate over the next possible elements
			for (Integer i : nextList)
			{
				// Recursive call
				totalPaths += countPaths(i, M, N);
			}
		}
		
		return totalPaths;
	}

}
