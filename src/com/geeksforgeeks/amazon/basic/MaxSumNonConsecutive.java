package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class MaxSumNonConsecutive {

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
	    	
	    	for (int i = 0; i < C.length; i++)
	    		C[i] = sc.nextInt();
	    	
	    	System.out.println(sum(C, N));

	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static int sum(int[] C, int size)
	{
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			// Recursion base case
			if (i == 0)
				arr[i] = C[i];
			// Recursion base case
			else if (i == 1)
				arr[i] = Math.max(C[i-1], C[i]);
			else
			{
				arr[i] = Math.max(arr[i-2] + C[i], arr[i-1]);
			}
		}
		
		return arr[size-1];	
	}

}
