package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

// Reverse a sub array in an array.

public class ReverseSubArray {

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
	    	int[] A = new int[N];
	    	
	    	for (int i = 0; i < A.length; i++)
	    		A[i] = sc.nextInt();
	    	
	    	// Input the left index of the subarray
	    	int L = sc.nextInt();
	    	
	    	// Input the right index of the subarray
	    	int R = sc.nextInt();
	    	
	    	// Reverse the subarray
	    	reverse(A, L, R);
	    	
	    	// Print the array
	    	for (int i = 0; i < A.length; i++)
	    	{
	    		if (i == A.length-1)
	    			System.out.println(A[i]);
	    		else
	    			System.out.print(A[i] + " ");
	    	}

	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static int[] reverse(int[] A, int L, int R)
	{
		// Iterate over the array starting from the position of the subarray
		for (int i = L-1; i < R-1; i++)
		{
			swap(A, i, R-1);
			R--;
		}
		
		return A;
	}
	
	public static void swap(int[] A, int L, int R)
	{
		int temp = A[L];
		A[L] = A[R];
		A[R] = temp;
	}

}


