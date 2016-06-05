package com.geeksforgeeks.amazon.school;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EqualToProduct {
	
	public static String containProduct(int[] a, int p)
	{	
		Set<Integer> valuesSet = new HashSet<Integer>();
		
		// Add the values to a set so it can be searched later on
		for (int i = 0; i < a.length; i++)
			valuesSet.add(a[i]);
		
		// Iterate over each element of the array
		for (int i = 0; i < a.length; i++)
		{
			// Divide the product by the current element. If a[i] is a divisor, then 
			// the product is divided by it and the result stored
			Integer divisor = p % a[i] == 0 ? p/a[i] : null;
			
			// Check the divisor is present in the Set
			if (divisor != null && valuesSet.contains(divisor)){
				return "Yes";
			}		
		}
		
		return "No";
	}

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
	    	int[] a = new int[N];
	    	
	    	// Input the product
	    	int p = sc.nextInt();
	    	
	    	for (int i = 0; i < N; i++)
	    		a[i] = sc.nextInt();
	            
	        // Check if the rectangles overlap
	        System.out.println(containProduct(a, p));
	        
	        t--;	            
	    }
	    
	    sc.close();
	}

}
