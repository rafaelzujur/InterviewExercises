package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class MinimumElement {

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

	    	// Create the value array
	    	int[] arr = new int[N];

	    	// Input values
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	System.out.println(getMinElement(arr));

	        t--;	            
	    }
	    
	    sc.close();	

	}

	private static int getMinElement(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		int min = 0;
		
		while (true)
		{	
			// Check if there are only two elements left or if the array was not rotated
			if ((end-start) == 1 || arr[start] <= arr[end])
			{
				// The smallest between those two elements is the minimum
				if (arr[end] < arr[start])
					min = arr[end];
				else
					min = arr[start];
				
				break;
			}
			// Get the middle position
			int middle = (start+end)/2;

			// Check the element of the middle is greater than the one at the beginning
			if (arr[middle] >= arr[start]) 
				start = middle;		// Discard the left side
			else 
				end = middle;		// Discard the right side
		}
		
		return min;
	}
	
}
