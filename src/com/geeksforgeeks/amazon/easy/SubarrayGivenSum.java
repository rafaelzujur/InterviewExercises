package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class SubarrayGivenSum {

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
	        
	        int T = Integer.parseInt(lineArr[1]);
	        
	        line = sc.nextLine();
	        lineArr = line.split(" ");
	        
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        findSubarray(arr, T);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void findSubarray(int[] arr, int T)
	{
		int start = 0;
		int end = 0;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (sum == T)
			{
				break;
			}
			else
			{
				sum += arr[i];
				
				while (sum > T)
				{
					sum = sum - arr[start];
					start = start+1;
				}
			}
			
			end = i;
		}
		
		end++;
		start++;
		
		if (sum == T)
		{
			System.out.println(start + " " + end);
		}
		else
			System.out.println("-1");
	}

}
