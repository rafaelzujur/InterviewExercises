package com.geeksforgeeks.amazon.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AlternateValues {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	int N = sc.nextInt();
	    	
	    	// Create the array
	    	int[] arr = new int[N];
	    	
	    	// Input the values for the array
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	printAlternates(arr);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static void printAlternates(int[] arr)
	{
		Queue<Integer> pos = new LinkedList<Integer>();
		Queue<Integer> neg = new LinkedList<Integer>();
		
		StringBuffer sf = new StringBuffer();
		
		// Iterate over the array and extract positive and negative numbers
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] >= 0)
				pos.add(arr[i]);
			else
				neg.add(arr[i]);
		}
		
		// Add the element to the buffer in alternate order
		while (!pos.isEmpty() || !neg.isEmpty())
		{
			if (!pos.isEmpty())
				sf.append(pos.poll() + " ");
			
			if (!neg.isEmpty())
				sf.append(neg.poll() + " ");
		}
		
		System.out.println(sf.toString().trim());
	}

}
