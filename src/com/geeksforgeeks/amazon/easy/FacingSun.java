package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class FacingSun {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    sc.nextLine();
	    
	    while (t > 0)
	    {
	    	int N = sc.nextInt();
	    	
	    	int[] arr = new int[N];
	    	
	    	sc.nextLine();
	    	
	    	String line = sc.nextLine();
	        String[] lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	arr[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        System.out.println(getBuildings(arr));

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static int getBuildings(int[] arr)
	{
		int max = arr[0];
		int count = 1;
		
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
				count++;
			}
		}
		
		return count;
	}

}
