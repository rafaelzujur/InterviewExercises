package com.hackerrank.practice.algorithms.warmup;

import java.util.Scanner;
import java.util.stream.Stream;

public class CompareTheTriplets {

	public static void main(String[] args) 
	{		
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);

	    int[] A = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    
	    int[] B = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    
	    int pointsA = 0;
	    int pointsB = 0;
	    
	    for (int i = 0; i < A.length; i++)
	    {
	    	if (A[i] > B[i])
	    		pointsA++;
	    	else if (A[i] < B[i])
	    		pointsB++;
	    }
	    
	    System.out.println(pointsA + " " + pointsB);
	    
	    sc.close();
	}

}
