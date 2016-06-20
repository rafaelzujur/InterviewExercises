package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

/*
	Given an unsorted integer (positive values only) array of size ‘n’, we can form a group of two or 
	three only, the group should be such that the sum of all elements in that group is a multiple of 3. 
	Count all possible number of groups that can be generated in this way.
	
	Input: arr[] = {3, 6, 7, 2, 9}
	Output: 8
	Groups are {3,6}, {3,9}, {9,6},
	           {7,2}, {3, 6,9}, 
	           {3, 7, 2}, {7, 2, 6}, 
	           {7, 2, 9}
	Input:
	
	The first line of input contains an integer T denoting the number of test cases.
	The first line of each test case is N, where N is the size of array.
	The second line of each test case contains N elements of input array.
	
	Output:
	
	Print number of all possible group.
	
	Constraints:
	
	1 ≤ T ≤ 50
	1 ≤ N ≤ 80
	1 ≤ arr[i] ≤ 100
	
	Example:
	
	Input
	2
	5
	3 6 7 2 9
	4
	2 1 3 4
	
	Output
	8
	4
 */
public class PossibleGroups {

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
	    	
	    	System.out.println(calc(arr));
	    	
	        t--;	            
	    }	    
	    sc.close();

	}
	
	public static int calc(int[] arr)
	{
		// Define the variable that counts the possible groups
		int count = 0;
		
		// Iterate over the array starting from the first element
		for (int i = 0; i < arr.length; i++)
		{
			// Iterate over the array starting from the next element
			for (int j = i+1; j < arr.length; j++)
			{
				// Check the sum of the two selected elements is multiple of three
				if ((arr[i]+arr[j])%3 == 0)
					count++;
				
				// Iterate over the array starting from the next element
				for (int k = j+1; k < arr.length; k++)
				{
					// Check the sum of the three selected elements is multiple of three
					if ((arr[i]+arr[j]+arr[k])%3 == 0)
						count++;
				}
			}
		}
		
		return count;
	}

}
