package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class NumberHops {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the number of steps to hop
	    	int N = sc.nextInt();
	    	
	    	System.out.println(calc(N));

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static long calc(int N)
	{
		long[] arr = new long[N+1];
		
		// Set the base cases
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i = 3; i < arr.length; i++)
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		
		return arr[N];
	}

}
