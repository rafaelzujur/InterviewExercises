package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class CountZero {

	public static void main(String[] args) {
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the number of digits
	    	int D = sc.nextInt();
	    	
	    	System.out.println(calc(D));

	        t--;	            
	    }
	    
	    sc.close();
	}
	
	public static long calc(int D)
	{
		long total = 0;
		
		for (int i = D; i > 1; i--)
		{
			for (int j = 1; j < i; j++)
			{
				total+= Math.pow(9, j)*comb(i-1,i-j);
			}
		}
		
		return total;
	}
	
	public static long comb(int N, int K)
	{
		return fact(N)/(fact(K)*fact(Math.abs(N-K)));
	}
	
	public static long fact(int N)
	{
		if (N <=1)
			return 1;
		else
			return N*fact(N-1);
	}

}
