package com.geeksforgeeks.amazon.school;

import java.util.Scanner;

public class InmediateSmallerElement {
	
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
	    	
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	for (int i = 0; i < arr.length-1; i++)
	    	{
    			if (arr[i] > arr[i+1])
    				System.out.print(arr[i+1] + " ");
    			else
    				System.out.println(-1 + " ");  		
	    	}
	    	
	    	System.out.println(-1);

	        t--;	            
	    }
	    
	    sc.close();
	}
}
