package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class GenerateBinaryNumbers {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the number
	    	int N = sc.nextInt();
	    	
	    	printBinaries(N);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}

	private static void printBinaries(int N)
	{
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= N; i++)
		{
			sb.append(Integer.toBinaryString(i) + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
