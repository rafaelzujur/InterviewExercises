package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

/*
	Given an array of size n, rotate it by d elements. 
	
	Input: The first line of the input contains T denoting the number of testcases. First line of test case is the number of elements 'n' and elements 'd' to be rotated. Second line of test case will be the array elements.
	Output: Rotated array is displayed to the user.
	
	
	Constraints:
	
	1 <=T<= 50
	1 <=n<= 100
	d<=n
	1 <=arr[i]<= 100
	
	
	Example:
	
	Input:
	2
	5 2
	1 2 3 4 5 
	10 3
	2 4 6 8 10 12 14 16 18 20
	
	Output:
	3 4 5 1 2
	8 10 12 14 16 18 20 2 4 6
 */
public class RotateArray {

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
	    	
	    	// Input the number of rotations
	    	int d = sc.nextInt();
	    	
	    	// Create the array
	    	int[] arr = new int[N];
	    	
	    	// Input the values for the array
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();

	    	rotate(arr, d);
	    	
	        t--;	            
	    }	    
	    sc.close();
	}
	
	public static void rotate(int[] arr, int d)
	{
		StringBuffer sf = new StringBuffer();
		
		// Add to the string buffer the elements of the array from the value of the rotations
		for (int i = d; i < arr.length; i++)
			sf.append(arr[i] + " ");
		
		// Add to the string buffer the elements of the array from beginning to the value of the rotations
		for (int i = 0; i < d; i++)
			sf.append(arr[i] + " ");
		
		// Print the string buffer
		System.out.println(sf.toString().trim());
	}

}
