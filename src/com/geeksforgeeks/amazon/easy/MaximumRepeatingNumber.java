package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

/*
Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a 
positive integer and k <= n. Find the maximum repeating number in this array. For example, 
let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum 
repeating number would be 2 if there are two or more maximum repeating numbers print the element 
having least value (See last sample case for the more clarifications). Expected time complexity 
is O(n) and extra space allowed is O(1).
 */

public class MaximumRepeatingNumber {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    sc.nextLine();
	    
	    while (t > 0)
	    {
	    	String line = sc.nextLine();
	        String[] lineArr = line.split(" ");
	        
	        int[] arr = new int[Integer.parseInt(lineArr[0])];
	        
	        int K = Integer.parseInt(lineArr[1]);
	        
	        line = sc.nextLine();
	        lineArr = line.split(" ");
	        
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        System.out.println(findRepeating(arr, K));

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static int findRepeating(int[] arr, int K)
	{
		int index = 0;
		
		// Iterate over the array and modify its elements by using the values in each position
		// as the index of the value in the array to modify. 
		for (int i = 0; i < arr.length; i++)
		{
			arr[arr[i]%K] += K;
		}
		
		// Iterate again to find the maximum repeating number
		for (int i = 1; i < arr.length; i++)
		{
			// One of the elements is repeated
			if (arr[i]/K > arr[index]/K)
				index = i;
			else if (arr[i]/K == arr[index]/K)	// The elements are repeated the same number of times
			{ // The smallest of them will be chosen
				if (i < index)
					index = i;					
			}		
		}
		
		return index;
	}

}
