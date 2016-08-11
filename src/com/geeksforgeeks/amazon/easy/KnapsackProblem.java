package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

/*
	You are given weights and values of N items, put these items in a knapsack of capacity W to get the 
	maximum total value in the knapsack. Note that we have only one quantity of each item, In other words, 
	given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N 
	items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value 
	subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break 
	an item, either pick the complete item, or don’t pick it (0-1 property).
	 
	
	Input:
	
	The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines. The first line consists of N the number of items. The second line consists of W, the maximum capacity of the knapsack. In the next  line are N space separated positive integers denoting the values of the N items and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.
	 
	
	Output:
	
	Print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.
	 
	
	Constraints:
	
	1≤T≤100
	
	1≤N≤100
	
	1≤W≤100
	
	1≤wt[i]≤100
	
	1≤v[i]≤100
	
	
	Example:
	
	Input:
	1
	3
	4
	1 2 3
	4 5 1
	Output:
	3
 */
public class KnapsackProblem {
	private static int maxValueSum = 0;

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
	    	
	        // Input the weight threshold
	    	int W = sc.nextInt();
	    	
	    	// Create the value array
	    	int[] v = new int[N];
	    	
	    	// Create the weight array
	    	int[] wt = new int[N];
	    	
	    	// Input values
	    	for (int i = 0; i < v.length; i++)
	    		v[i] = sc.nextInt();
	    	
	    	// Input weights
	    	for (int i = 0; i < wt.length; i++)
	    		wt[i] = sc.nextInt();
	    	
	    	calc(v, wt, W, 0, 0);
	    	
	    	System.out.println(maxValueSum);
	    	maxValueSum = 0;

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void calc(int[] v, int[] wt, int W, int start, int valueSum)
	{
		// Base Case
		if (start >= v.length || W < 0)
		{
			if (valueSum > maxValueSum)
				maxValueSum = valueSum;
			return;
		}

		for (int i = start; i < v.length; i++)
		{	
			if (W-wt[i] >= 0)
				calc(v, wt, W-wt[i], i+1, valueSum+v[i]);
			else
				calc(v, wt, W-wt[i], i+1, valueSum);
		}
		
	}
	
	
	
//	public static void main(String[] args)
//	{
//		calc(new int[]{1,2,3,4,5},
//			new int[]{15,20,7,9,30},
//			37,
//			0,
//			0);
//		
//		System.out.println(maxValueSum);
//	}

}
