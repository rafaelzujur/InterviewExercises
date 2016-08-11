package com.hackerrank.contest.contest_1;

import java.util.Scanner;

public class CountingWays {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of points
    	int N = sc.nextInt();
    	int[] wt = new int[N];

    	sc.nextLine();

	    String line = sc.nextLine();
    	String[] lineArr = line.split(" ");
    	
    	for (int j = 0; j < lineArr.length; j++)
    		wt[j] = Integer.parseInt(lineArr[j]);

    	line = sc.nextLine();
    	lineArr = line.split(" ");
    	
    	int L = Integer.parseInt(lineArr[0]);
    	int R = Integer.parseInt(lineArr[1]);

		System.out.println(calcWays(wt.length, wt, L, R));

	}
	
	private static long calcWays(int N, int[] wt, int L, int R)
	{
		long[][] M = new long[N+1][R+1];
		long mod = (long) (Math.pow(10, 9)+7);
		//System.out.println(mod);
		
		for (int i = 0; i < N+1; i++)
		{
			for (int w = 0; w < R+1; w++)
			{
				if (i==0 || w == 0)
					M[i][w] = 0;
				else
				{
					long p = wt[i-1] == w ? 1 : (wt[i-1] < w ? M[i][w-wt[i-1]] : 0);
					M[i][w] = M[i-1][w]%mod + p%mod;
				}
			}
		}
		
		// Print the matrix
//		for (int i = 0; i < N+1; i++)
//		{
//			for (int j = 0; j < R+1; j++)
//			{
//				System.out.print("["+M[i][j]+"] ");
//			}
//			System.out.println("");
//		}
		
		long result = 0;
		
		for (int i = L; i < R+1; i++)
			result += M[N][i];
		
		return (long)(result%(mod));
	}

}
