package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class HandShakes {

	public static void main(String[] args) 
	{
	    // Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the size of the array
	    	int N = sc.nextInt();
	    	
	            
	        // Check if the rectangles overlap
	        System.out.println(calc_handshakes(N));
	        
	        t--;	            
	    }
	    
	    sc.close();
	}
	
	public static int calc_handshakes(int N)
	{
		// Recursion base case
		if (N == 0)
			return 1;
		
		int res = 0;
		
		// Iterate over even elements. This will generate all the possible combinations of handshakes.
		// E.g. If there are 8 elements, the final formula will be =
		// calc_handshake(0)*calc_handshake(6) +  ***THIS MEANS THAT IF 0 AND 1 ARE SHAKING HANDS, THEN CALCULATE POSSIBLE HANDSHAKES FOR 2-7
		// calc_handshake(2)*calc_handshake(4) +  ***THIS MEANS THAT IF 0 AND 3 ARE SHAKING HANDS, THEN CALCULATE POSSIBLE HANDSHAKES FOR 1-2 AND 4-7
		// calc_handshake(4)*calc_handshake(2) +  ***THIS MEANS THAT IF 0 AND 5 ARE SHAKING HANDS, THEN CALCULATE POSSIBLE HANDSHAKES FOR 1-4 AND 6-7
		// calc_handshake(6)*calc_handshake(0) +  ***THIS MEANS THAT IF 0 AND 7 ARE SHAKING HANDS, THEN CALCULATE POSSIBLE HANDSHAKES FOR 1-6
		for (int i = 0; i < N; i+=2)
		{
			res += calc_handshakes(i)*calc_handshakes(N-2-i);
		}
		
		return res;
	}

}
