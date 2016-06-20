package com.geeksforgeeks.amazon.basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
	Given an unsorted array of positive integers. Find the number of triangles that can be formed with three 
	different array elements as lengths of three sides of triangles. 
	
	Input: 
	The first line of the input contains T denoting the number of testcases. First line of test case is the length 
	of array N and second line of test case are its elements.
	
	Output:
	Number of possible triangles are displayed to the user.
	
	Constraints:
	
	1 <=T<= 100
	3 <=N<= 100
	1 <=arr[i]<= 1000
	
	
	Example:
	
	Input:
	2
	3
	3 5 4
	5
	6 4 9 7 8
	
	Output:
	1
	10
 */

public class CountPossibleTriangles {

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
	    	
	    	printPossibleTriangles(arr);
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static void printPossibleTriangles(int[] arr)
	{
		// Sort the array
		Arrays.sort(arr);
		
		System.out.println(count(arr));
		
	}
	
	private static int count(int[] arr)
	{
		int total = 0;
		
		for (int i = 0; i < arr.length-2; i++)
		{
			for (int j = i+1; j < arr.length-1;j++)
			{
				for (int k = j+1; k < arr.length; k++)
				{
					if (checkSides(arr[i], arr[j], arr[k]))
						total += 1;
					else
						break;
				}
			}
		}
		
		return total;
	}
	
	private static boolean checkSides(int a, int b, int c)
	{
		if ((a < (b + c)) &&
			(b < (a + c)) &&
			(c < (a + b)))
			return true;
		else
			return false;
	}
	

}
