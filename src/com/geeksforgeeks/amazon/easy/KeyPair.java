package com.geeksforgeeks.amazon.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KeyPair {
	
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
	        
	        int S = Integer.parseInt(lineArr[1]);
	        
	        line = sc.nextLine();
	        lineArr = line.split(" ");
	        
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        check(arr, S);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void check(int[] arr, int S)
	{
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] <= S)
			{
				int value = Math.abs(arr[i]-S);
				if (set.contains(value))
				{
					System.out.println("Yes");
					return;
				}
				else
				{
					set.add(arr[i]);
				}
			}			
		}
		
		System.out.println("No");
	}

}
