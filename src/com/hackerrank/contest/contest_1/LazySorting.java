package com.hackerrank.contest.contest_1;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LazySorting {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);

        // Input the size of the array
    	int N = sc.nextInt();
    	
    	int[] arr = new int[N];
    	sc.nextLine();
    	
    	String line = sc.nextLine();
    	String[] arrStr = line.split(" ");

    	for (int i = 0; i < N; i++)
    	{
    		arr[i] = Integer.parseInt(arrStr[i]);
    	}
    	
    	System.out.println(getMinute(N, arr));

	    sc.close();	
	}
	
	private static String getMinute(int N, int[] arr)
	{
		// Sort the array
		Map<Integer, Integer> elemCount = new HashMap<Integer, Integer>();
		
		for (int i : arr)
		{
			if (elemCount.containsKey(i))
				elemCount.put(i, elemCount.get(i)+1);
			else
				elemCount.put(i, 1);
		}
		
		long numerator = 1;
		
		for (int i : elemCount.keySet())
		{
			numerator *= fact(elemCount.get(i));
		}
		
		// Get all the permutations
		long denominator = fact(N);
		
		double P = (double)numerator/denominator;
		
		if (P == 1)
			return "1.000000";
		
		double sum = (double)1/P;
		
		//double sum = 0.000000;
		
//		for (int i = 1; i < 10000; i++)
//		{
//			sum += i*Math.pow(P, i);
//		}
		
		DecimalFormat dm = new DecimalFormat("0.000000");
        
		return dm.format(Math.round(sum*1000000.0) / 1000000.0);
	}
	
	private static long fact(int N)
	{
		long result = 1;
		
		while (N > 1)
		{
			result *= N;
			N--;
		}
		
		return result;
	}

}
