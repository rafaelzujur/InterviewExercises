package com.geeksforgeeks.amazon.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxSubarray {

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
	        
	    	int N = Integer.parseInt(lineArr[0]);
	    	
	    	int K = Integer.parseInt(lineArr[1]);
	    	
	    	int[] arr = new int[N];

	    	line = sc.nextLine();
	        lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        printMax(arr, K);

	        t--;
	    }

	}
	
	private static void printMax(int[] arr, int K)
	{
		List<Integer> sub = new ArrayList<Integer>();
		StringBuffer sb = new StringBuffer();
		int start = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			sub.add(arr[i]);
			
			if (sub.size() == K)
			{
				Collections.sort(sub);
				sb.append(sub.get(K-1) + " ");
				sub.remove((Object)arr[start]);
				start++;
			}
		}
		
		System.out.println(sb.toString().trim());
	}

}
