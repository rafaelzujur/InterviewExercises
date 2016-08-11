package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ReachNthPoint {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();

	    while (t > 0)
	    {	    	
	    	int N = sc.nextInt();
	    	
	    	System.out.println(calc(N));
	    	
	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static long calc(int N)
	{
		long[] arr = new long[N+1];
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i < arr.length; i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		return arr[N];		
	}

}
