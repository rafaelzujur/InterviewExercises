package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ColumnNameForColumnNumber {

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
 
	        printColumn(N);

	        t--;	            
	    }
	    
	    sc.close();	
	}
	
	private static void printColumn(int N)
	{
		String columnName = "";
		
		while (N > 26)
		{
			int mod = N%26;
			columnName = intToAscii(mod) + columnName;
			
			N = N/26;
			
			if (mod == 0)
				N--;
		}

		columnName = intToAscii(N) + columnName;
		
		System.out.println(columnName.toUpperCase());
	}
	
	private static char intToAscii(int N)
	{
		if (N == 0)
			return 'z';
		
		return Character.toChars(N-1+'a')[0];
	}

}
