package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ArraytoBST {

	public static StringBuffer sb;
	
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
	        
	        sb = new StringBuffer();
	        arrToBST(arr, 0, arr.length-1);
			System.out.println(sb.toString().trim());

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void arrToBST(int[] arr, int start, int end)
	{
		// base case
		if (start == end)
		{
			sb.append(arr[end] + " ");
			return;
		}
		else
		{
			int middle = (start+end)/2;
			sb.append(arr[middle] + " ");
			
			if (middle > start)
				arrToBST(arr, start, middle-1);
			
			if (middle < end)
				arrToBST(arr, middle+1, end);
		}
	}

}
