package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ArrayZigZag {

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
	        
	        printZigZagArray(arr);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void printZigZagArray(int[] arr)
	{
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i< arr.length-1; i++)
		{
			if (i%2 == 0) // even position
			{
				if (arr[i] > arr[i+1])
				{ // swap the elements
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			else // odd position
			{
				if (arr[i] < arr[i+1])
				{ // swap the elements
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			
			sb.append(arr[i] + " ");
		}
		
		sb.append(arr[arr.length-1]);
		
		System.out.println(sb.toString().trim());
	}

}
