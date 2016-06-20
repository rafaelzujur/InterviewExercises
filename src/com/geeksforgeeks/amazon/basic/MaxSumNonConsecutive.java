package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

/*
	Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the 
	sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
	
	Input:
	
	The first line of input contains an integer T denoting the number of test cases.
	The first line of each test case is N,N is the size of array.
	The second line of each test case contains N input C[i].
	
	Output:
	
	Print the maximum sum of a subsequence.
	
	Constraints:
	
	1 ≤ T ≤ 80
	1 ≤ N ≤ 100
	1 ≤ C[i] ≤ 500
	
	Example:
	
	Input:
	2
	6
	5 5 10 100 10 5
	4
	3 2 7 10
	
	Output:
	110
	13
 */

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
