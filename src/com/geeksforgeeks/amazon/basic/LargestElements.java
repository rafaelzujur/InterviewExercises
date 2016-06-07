package com.geeksforgeeks.amazon.basic;

import java.util.Arrays;
import java.util.Scanner;

// Given an array, print k largest elements from the array.

public class LargestElements {

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
	    	int[] C = new int[N];
	    	
	    	// Input the number of elements to be fetched
	    	int K = sc.nextInt();
	    	
	    	for (int i = 0; i < C.length; i++)
	    		C[i] = sc.nextInt();
	    	
	    	printLargestElements(C, K);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	public static void printLargestElements(int[] C, int K)
	{
		// Sorts the array
		Arrays.sort(C);
		
		// Prints the largest elements from end to beginning
		for (int i = C.length-1; i > C.length-1-K; i--)
		{
			if (i == C.length-K)
				System.out.println(C[i]);
			else
				System.out.print(C[i] + " ");
		}
	}

}
