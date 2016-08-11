package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class KClosestElement {

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
	    	
	    	// Create the value array
	    	int[] arr = new int[N];
	    	
	    	// Input values
	    	for (int i = 0; i < arr.length; i++)
	    		arr[i] = sc.nextInt();
	    	
	    	String line = sc.next();
	    	
	        // Input one of the array's elements
	    	int value = Integer.parseInt(line);
	    	
	        // Input the number of elements to be found
	    	int K = Integer.parseInt(sc.next());
	    	
	    	printClosest(arr, value, K);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void printClosest(int[] arr, int value, int K)
	{
		int position = getPosition(arr, value);
		int left = position-1;
		int right = position+1;
		StringBuffer sf = new StringBuffer();
		
		while (K > 0)
		{
			Integer leftDifference = left >= 0 ? (Math.abs(arr[left]-value)) : null;
			Integer rightDifference = right <= arr.length-1 ? (Math.abs(arr[right]-value)) : null;
			
			if (leftDifference == null && rightDifference == null)
				break;
			else if (leftDifference == null || (rightDifference != null && rightDifference <= leftDifference))
			{
				sf.append(arr[right] + " ");
				right++;	
			}
			else if (rightDifference == null || (leftDifference != null && leftDifference < rightDifference))
			{
				sf.append(arr[left] + " ");
				left--;
			}
				
			K--;
		}
		
		System.out.println(sf.toString().trim());
	}
	
	private static int getPosition(int[] arr, int value)
	{
		int start = 0;
		int end = arr.length-1;
		int position = -1;
		
		while (true)
		{
			if ((end-start)==1)
			{
				position = arr[start] == value ? start : end;
				break;
			}
			
			// Get the position in the middle
			int middle = (start+end)/2;

			if (arr[middle] > value)		// Discard the right side
				end = middle;
			else if (arr[middle] < value)							// Discard the left side
				start = middle;
			else
			{
				position = middle;
				break;
			}		
		}
		
		return position;
	}

}
