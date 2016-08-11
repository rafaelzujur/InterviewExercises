package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

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
	        
	        System.out.println(calcSum(arr));

	        t--;	            
	    }
	    
	    sc.close();		
	}

	private static int calcSum(int[] arr)
	{
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++)
		{
			sum[i] = arr[i];
			
			for (int j = i-1; j >= 0; j--)
			{
				if (arr[i] > arr[j] && arr[i]+sum[j] > sum[i])
				{
					sum[i] = arr[i]+sum[j];
				}
			}
						
			if (sum[i] > max)
				max = sum[i];
		}
		
		return max;
	}
}
