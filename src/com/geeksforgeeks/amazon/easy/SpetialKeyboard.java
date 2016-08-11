package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class SpetialKeyboard {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();

	    while (t > 0)
	    {	    	
	    	int N = sc.nextInt();
	    	
	    	System.out.println(calcAs(N));
	    	
	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static long calcAs(int N)
	{
		if (N < 7)
			return N;
		
		long[] arr = new long[N];
		
		for (int i = 0; i < 6; i++)
			arr[i] = i+1;

		for (int n = 7; n <= N; n++)
		{
			arr[n-1] = 0;
			
			for (int i = 0; i < n-2; i++)
			{
				int B = n-2-i;
				long T = arr[i]*B;
				
				if (T > arr[n-1])
					arr[n-1] = T;
			}
		}

		return arr[N-1];
	}

}
