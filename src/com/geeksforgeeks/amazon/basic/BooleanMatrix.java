package com.geeksforgeeks.amazon.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) 
// then make all the cells of ith row and jth column as 1.

public class BooleanMatrix {

	public static void main(String[] args) {
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the rows of the matrix
	    	int r = sc.nextInt();
	    	
	    	// Input the columns of the matrix
	    	int c = sc.nextInt();
	    	
	    	// Create the array
	    	int[] arr = new int[r*c];
	    	
	    	// Input the values for the array
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	change(arr, r, c);
	    	
	    	// Print the array
	    	for (int i = 0; i < arr.length; i++)
	    	{
	    		if (i == arr.length-1)
	    			System.out.println(arr[i]);
	    		else
	    			System.out.print(arr[i] + " ");
	    	}

	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static int[] change(int[] arr, int r, int c)
	{
		// Create set that contains the row indexes that must change
		Set<Integer> rowSet = new HashSet<Integer>();
		
		// Create set that contains the column indexes that must change
		Set<Integer> columnSet = new HashSet<Integer>();
		
		// Scan the array to find the rows and columns that must be changed
		for (int i = 0; i < arr.length; i++)
		{
			// Check the value is 1
			if (arr[i] == 1)
			{
				// Add the row index to the set
				rowSet.add(i/c);
				
				// Add the column index to the set
				columnSet.add(i%c);
			}
		}
		
		// Scan the array, but now it will check against the set if a position must be changed or not
		for (int i = 0; i < arr.length; i++)
		{			
			if (rowSet.contains(i/c) || columnSet.contains(i%c))
				arr[i] = 1;
		}
		
		return arr;
	}

}
