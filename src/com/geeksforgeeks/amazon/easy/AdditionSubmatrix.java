package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class AdditionSubmatrix {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    sc.nextLine();
	    
	    while (t > 0)
	    {
	    	String line = sc.nextLine();
	        String[] lineArr = line.split(" ");

	    	int n = Integer.parseInt(lineArr[0]);
	    	int m = Integer.parseInt(lineArr[1]);
	    	
	    	int[][] M = new int[n][m];
	    	
	    	line = sc.nextLine();
	        lineArr = line.split(" ");
	    	
	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	int row = i/m;
	        	int col = i%m; 
	        	M[row][col] = Integer.parseInt(lineArr[i]);
	        }

	    	line = sc.nextLine();
	        lineArr = line.split(" ");

	        int r1 = Integer.parseInt(lineArr[0]);
	        int c1 = Integer.parseInt(lineArr[1]);
	        int r2 = Integer.parseInt(lineArr[2]);
	        int c2 = Integer.parseInt(lineArr[3]);
	        
	        System.out.println(addSubMatrix(M, r1-1, c1-1, r2-1, c2-1));

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static int addSubMatrix(int[][] M, int r1, int c1, int r2, int c2)
	{
		int sum = 0;
		
		for (int i = r1; i <= r2; i++)
		{
			for (int j = c1; j <= c2; j++)
			{
				sum += M[i][j];
			}
		}
		
		return sum;
	}

}
