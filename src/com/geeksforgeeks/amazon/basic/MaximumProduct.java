package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class MaximumProduct {

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
	    	int[] arr = new int[N];
	    	
	    	// Input the values for the array
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	printProduct(arr);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static void printProduct(int[] arr)
	{
		// Iterate 2 times over the array
		for (int i = 0; i < 2; i++)
		{
			findMax(arr, i);
		}
		
		System.out.println(arr[0]*arr[1]);
	}
	
	private static void findMax(int[] arr, int start)
	{
		int maxIndex = start;
		
		for (int i = start+1; i < arr.length; i++)
		{
			if (arr[i] > arr[maxIndex])
			{
				maxIndex = i;
			}
		}
		
		// Swap the maximum element
		int temp = arr[start];
		arr[start] = arr[maxIndex];
		arr[maxIndex] = temp;
	}

}
