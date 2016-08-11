package com.geeksforgeeks.amazon.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KthDistance {

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
	        
	    	int K = Integer.parseInt(lineArr[0]);
	    	
	    	int N = Integer.parseInt(lineArr[1]);
	    	
	    	int[] arr = new int[N];

	    	line = sc.nextLine();
	        lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        checkDuplicates(arr, K);

	        t--;	            
	    }
	    
	    sc.close();

	}
	
	private static void checkDuplicates(int[] arr, int K)
	{
		K++;
		Set<Integer> set = new HashSet<Integer>();
		int start = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (i-start >= K)
			{
				set.remove(arr[start]);
				start++;
			}
			
			if (set.contains(arr[i]))
			{
				System.out.println("True");
				return;
			}
			else
			{
				set.add(arr[i]);
			}
			
		}
		
		System.out.println("False");
		
	}

}
