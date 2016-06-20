package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

/*
	Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of 
	values on each face when all the dice are thrown.
	
	Input: The first line of the input contains T denoting the number of testcases. First line of test case is faces 
	'm', number of throws 'n' and the sum to obtain 'x'.
	Output: Number of ways to get sum 'x' are displayed.
	Constraints:
	1 <=T<= 100
	1 <=m,n,x<= 50
	
	
	Example:
	
	Input: 
	2
	6 3 12
	10 8 25
	
	Output:
	25
	318648
 */

public class DiceThrow {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the number of sides of each dice
	    	int m = sc.nextInt();
	    	
	    	// Input the number of dices
	    	int n = sc.nextInt();
	    	
	    	// Input the value of the sum
	    	int x = sc.nextInt();
	    	
	    	// Using recursion
	    	System.out.println(countThrowsDynamic(m, n, x));
	    	
	        t--;	            
	    }	    
	    sc.close();
	}
	
	// Recursive Way. Very Inneficient
	public static int countThrowsRecursive(int m, int n, int x)
	{
		int count = 0;

		int currentDiceValue = x-((n-1)*m) <= 0 ? 1 : x-((n-1)*m);		
		
		for (int i = currentDiceValue; i <= m && x-i > 0; i++)
		{	
			if (n-1 == 1)
				count += 1;
			else
				count += countThrowsRecursive(m, n-1, x-i); 
		}
				
		return count;
	}
	
	// Dynamic programming way.
	public static long countThrowsDynamic(int m, int n, int x)
	{
		// Create a matrix size [n,x]. This matrix will contain all the possibilities:
		// From getting the sum 0 with 0 dice, to getting the sum x with n dice
		long[][] M = new long[n+1][x+1];
		
		// Fill the first row of the matrix.
		// The first row contains the number of possibilities to get a sum <= x with 0 die
		// Of course the possibilities in all cases is 0
		for (int i = 0; i < x+1; i++)
			M[0][i] = 0;
		
		// Fill the second row of the matrix
		// The second row contains the number of possibilities to get a sum <= x with 1 die
		// Only the columns >= 1 and <= m will have the value 1. For the rest obviously is 0
		for (int i = 0; i < x+1; i++)
		{
			if (i >= 1 && i <= m)
				M[1][i] = 1;
			else
				M[1][i] = 0;
		}
		
		// Now iterate the matrix from row 2 till the end
		// In each step is necessary to calculate the value of the cell
		// To calculate the value of a cell it is necessary to know the value
		// of all previous cells. That is why it was important to fill
		// the first and second rows, since they represent the base cases
		for (int i = 2; i < n+1; i++)
		{
			for (int j = 0; j < x+1; j++)
			{
				for (int k = 1; k <= m && k < j; k++)
				{
					M[i][j] += M[i-1][j-k]; 
				}
			}
		}
		
		// Print the matrix
//		for (int i = 0; i < n+1; i++)
//		{
//			for (int j = 0; j < x+1; j++)
//			{
//				System.out.print(M[i][j] + " ");
//			}
//			System.out.print(System.lineSeparator());
//		}
				
		
		// return the value that is at the bottom-right corner of the matrix
		return M[n][x];
	}

}
