package com.geeksforgeeks.amazon.basic;

import java.util.Arrays;
import java.util.Scanner;

// Print all pairs(sets) of prime numbers (p,q) such that p*q <= n, where n is given number.

public class PrimeNumberPairs {

	public static void main(String[] args) {
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the given number
	    	int N = sc.nextInt();
	    		            
	        // Print the prime numbers pair
	    	printPrimeNumberPairs(N);
	        
	        t--;	            
	    }
	    
	    sc.close();
	}
	
	/**
	 * Prints the prime number pairs.
	 * 
	 * @param N		Integer representing the given number
	 */
	private static void printPrimeNumberPairs(int N)
	{
		// Get the prime numbers
		boolean[] prime_arr = getPrimeNumbers(N);
		
		// Create a variable that will construct all the pair of prime numbers
		StringBuffer primeNumberPairs = new StringBuffer();
		
		// Calculate half of N
		int halfN = N/2;
		
		// Iterates over the arrays of boolean that represent the prime numbers
		for (int p = 2; p < prime_arr.length; p++)
		{
			// break the iteration when p is greater than half of the value
			if (p > halfN)
				break;
			
			if (prime_arr[p])
			{
				for (int q = 2; q < prime_arr.length; q++ )
				{
					if (prime_arr[q] && p*q <= N)
					{
						primeNumberPairs.append(p + " " + q + " ");
					}					
				}				
			}
		}
		
		System.out.println(primeNumberPairs.toString().trim());
	}
		
	/**
	 * Gets all the prime numbers up to a specified value.
	 * 
	 * @param MAX		Integer representing a threshold for the prime number values. In other words, all primer numbers must be lesser than this value
	 * @return			Array of Boolean where values indicate if the index value is a prime number
	 */
	private static boolean[] getPrimeNumbers(int MAX)
	{
		boolean[] prime_arr = new boolean[MAX];
		
		// Set all the values to true
		Arrays.fill(prime_arr, true);
		
		// Calculates the square root of the size of the array.
		// This value will represent the limit for the iteration
		int sqrRoot = (int) Math.sqrt(MAX);
		
		// Iterate over the array to set the numbers that are NOT prime
		for (int i = 2; i < sqrRoot; i++)
		{
			// Check if it is a prime number
			if (prime_arr[i])
			{
				// Cross-out all the multiples of i
				for (int j = 2; j < prime_arr.length; j++)
				{
					if (i*j < prime_arr.length)
						prime_arr[i*j] = false;
				}
			}
		}		
		return prime_arr;
	}

}
