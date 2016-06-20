package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class ValueEqualIndex {

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
	    	
	    	printEquals(arr);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static void printEquals(int[] arr)
	{
		// Create a string buffer that contains all the elements to be found
		StringBuffer sf = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i]-1 == i)
				sf.append(arr[i] + " ");
		}
		
		if (sf.length() == 0)
			sf.append("Not Found");
		
		System.out.println(sf.toString().trim());
	}

}
