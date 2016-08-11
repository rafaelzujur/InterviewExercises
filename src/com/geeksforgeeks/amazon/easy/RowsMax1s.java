package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class RowsMax1s {

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
	        
	    	int n = Integer.parseInt(lineArr[0]);
	    	
	    	int m = Integer.parseInt(lineArr[1]);
	    	
	    	int[] arr = new int[n*m];

	    	line = sc.nextLine();
	        lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        System.out.println(findRow(arr, n, m));

	        t--;
	    }

	}
	
	private static int findRow(int[] arr, int n, int m)
	{
		int maxSum = 0;
		int maxRow = 0;
		
		for (int i = 0; i < n; i++)
		{
			int tempSum = 0;
			
			for (int j = i*m; j < i*m+m; j++)
			{
				tempSum += arr[j];
			}
			
			if (tempSum > maxSum)
			{
				maxSum = tempSum;
				maxRow = i;
			}
		}
		
		return maxRow;
	}

}
