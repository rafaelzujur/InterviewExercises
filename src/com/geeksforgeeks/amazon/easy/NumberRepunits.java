package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

/*
	Every number whose unit’s digit is 3 has a repunit as its multiple. A repunit is a number which 
	has only ones. It is of the form (10n – 1)/9. Example: 3 divides 111, 13 divides 111111.
	
	A positive integer N will be given whose unit’s digit is 3. The task is to find the number of 
	1s in the smallest repunit which is divisible by the given number N.  
	
	Input: 
	The first line of input contains a single integer T denoting the number of test cases. Then T test 
	cases follow. Each test case consists of a single line containing a positive integer N whose unit’s digit is 3.
	
	Output:
	Corresponding to each test case, in a new line, print the number of 1s in the smallest repunit multiple of the number.
	
	Constraints:
	1 ≤ T ≤ 100
	1 ≤ N ≤ 107
	
	Example:
	Input
	2
	3
	23
	Output
	3
	22
 */

public class NumberRepunits {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the number
	    	int N = sc.nextInt();
	    	
	    	System.out.println(getMinRepunit(N));

	        t--;	            
	    }
	    
	    sc.close();			
	}
	
	// Every repunit is related to one another by using the function f(x) = 10*x + 1
	// This function allows the calculation of the following repunit: f(1) = 11; f(11) = 111; f(111) = 1111
	// How is this formula useful? I'll explain.
	// We could find out which is the repunit by dividing the given number (N) by
	// all the possible repunits starting from 1, 11, 111, and so on until we get a division whose mod is equal to 0. 
	// The problem with this approach is that eventually the repunit will become really big (e.g. 111111111111111111111111111111111) 
	// which will be difficult to calculate. So instead of this, we use a different approach. Since we don't want to use big numbers,
	// how about if we use a small one that can yield the same result? What if we use its mod? Lets make an example:
	// Say N is 3, so instead of doing 1%3 == 0, 11%3 == 0 and 111%3 == 0, we do 1%3 == 0, f(1%3)%3 == 0 and
	// f(f(1%3)%3) == 0. The number of times you repeat this step represent the number of digits of your minimum repunit.
	// 1%3 => 1, f(1%3)%3 => 11%3 => 2 and f(f(1%3)%3) => 21%3 => 0, so the repunit has 3 digits. 
	// Notice that the third step, which is 21%3, is equivalent to 111%3
	private static int getMinRepunit(int N)
	{
		long minRepunit = 1;
		int countDigits = 0;
		
		while (true)
		{
			// Get the mod of dividing the minimum repunit by the given number
			int mod = (int) (minRepunit%N);
			
			// Increase the number of digits the minimum repunit has
			countDigits++;
			
			// If the division is exact, then break
			if (mod == 0)
				break;
			else
			{
				// Apply the formula f(x) = 10*x + 1
				minRepunit = mod*10 + 1;
			}
		}
		
		return countDigits;	
	}
}
