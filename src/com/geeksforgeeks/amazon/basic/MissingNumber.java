package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

// Given an array of size n-1 and given that there are numbers from 1-n with one missing, the missing number is to be found.

public class MissingNumber {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	int N = sc.nextInt();
	    	
	    	// Create the array
	    	int[] arr = new int[N-1];
	    	
	    	// Input the values for the array
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	printMissing(arr);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static void printMissing(int[] arr)
	{
		// Get the size of the array plus 1
		int N = arr.length + 1;
		
		// Calculate the sum of all numbers from 1 to N
		int sum = (N*(N+1))/2;
		
		// Create variable that contains the sum of all the elements inside the array
		int acum = 0;
		
		for (int i : arr)
			acum+=i;
		
		// Print the missing element
		System.out.println(sum-acum);
	}

}
