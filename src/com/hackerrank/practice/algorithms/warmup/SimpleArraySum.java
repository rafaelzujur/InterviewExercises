package com.hackerrank.practice.algorithms.warmup;

import java.util.Scanner;

public class SimpleArraySum {
	
	public static void main(String args[])
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int N = sc.nextInt();
	    
	    int[] arr =  new int[N];

	    sc.nextLine();
		
		String line = sc.nextLine();
	    String[] lineArr = line.split(" ");
	    int sum = 0;

	    for (int i = 0; i < lineArr.length; i++)
	    {
	    	sum += Integer.parseInt(lineArr[i]);
	    }
	    
	    System.out.println(sum);
	    
	    sc.close();
	}
	
}
