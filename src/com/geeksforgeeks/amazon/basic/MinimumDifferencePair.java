package com.geeksforgeeks.amazon.basic;

import java.util.Arrays;
import java.util.Scanner;

// Given an unsorted array, find the minimum difference between any pair in given array.

public class MinimumDifferencePair {

	public static void main(String[] args) {
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	int N = sc.nextInt();
	    	
	    	// Create the array
	    	int[] arr = new int[N];
	    	
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	System.out.println(findMinimumDifference(arr));

	        t--;	            
	    }
	    
	    sc.close();
	}
	
	private static int findMinimumDifference(int[] arr)
	{
		// Sort the array
		Arrays.sort(arr);
		
		// Define the variable that will hold the minimum difference
		Integer minDiff = null;
		
		// Iterate over the array and calculates the difference between every pair
		for (int i = 0; i < arr.length-1; i++)
		{
			// Calculate the difference between a pair
			int diff = Math.abs(arr[i]-arr[i+1]);
			
			// Set the minimum difference value
			minDiff = minDiff == null ? diff : (diff < minDiff ? diff : minDiff);
		}
		
		return minDiff;
	}

}
