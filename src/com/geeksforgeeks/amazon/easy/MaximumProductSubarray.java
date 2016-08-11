package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

/*
Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
Assumption: There is always a positive product possible, i.e., no array of this form: {0,-20,0,0} or {-20}.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    sc.nextLine();
	    
	    while (t > 0)
	    {
	    	int N = sc.nextInt();
	    	
	    	int[] arr = new int[N];
	    	
	    	sc.nextLine();
	    	
	    	String line = sc.nextLine();
	        String[] lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        System.out.println(getMaxProduct(arr));

	        t--;	            
	    }
	    
	    sc.close();	

	}
	
	private static long getMaxProduct(int[] arr)
	{
		long product = arr[0];
		
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] == 0)
				continue;
			
			long accum = 1;

			for (int j = i; j >= 0; j--)
			{
				if (arr[j] == 0)
					break;
				
				accum *= arr[j];
				
				if (accum > product)
					product = accum;
			}
		}
		
		return product;
	}

}
