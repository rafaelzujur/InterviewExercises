package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ArraySum {

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

	    	int[] arr1 = new int[Integer.parseInt(lineArr[0])];
	    	int[] arr2 = new int[Integer.parseInt(lineArr[1])];	    	
	    	
	    	line = sc.nextLine();
	        lineArr = line.split(" ");
	    	
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr1[i] = Integer.parseInt(lineArr[i]);
	        }

	    	line = sc.nextLine();
	        lineArr = line.split(" ");
	    	
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr2[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        printSum(arr1, arr2);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void printSum(int[] arr1, int[] arr2)
	{
		int i = arr1.length-1;
		int j = arr2.length-1;
		int rest = 0;
		String result = "";
		
		while (i >= 0 || j >= 0)
		{
			if (i >=0 && j >= 0)
			{
				result = (arr1[i]+arr2[j]+rest)%10 + " " + result;
				rest = (arr1[i]+arr2[j]+rest)/10;
				i--;
				j--;
			}
			else if (i >= 0)
			{
				result = (arr1[i]+rest)%10 + " " + result;
				rest = (arr1[i]+rest)/10;
				i--;
			}
			else
			{
				result = (arr2[j]+rest)%10 + " " + result;
				rest = (arr2[j]+rest)/10;
				j--;
			}
		}
		
		if (rest > 0)
			result = rest + " " + result;
		
		System.out.println(result.trim());
	}

}
