package com.geeksforgeeks.amazon.easy;

import java.util.Scanner;

public class ReverseBits {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();

	    while (t > 0)
	    {	    	
	    	int N = sc.nextInt();
	    	
	    	System.out.println(reverse(N));
	    	
	        t--;	            
	    }
	    
	    sc.close();		
	}
	
	private static long reverse(int x)
	{
		StringBuffer sf = new StringBuffer();
		String bits = Integer.toBinaryString(x);
		
		for (int i = bits.length()-1; i >= 0; i--)
			sf.append(bits.charAt(i));
		
		if (sf.toString().length() < 32)
			sf.append(new String(new char[32-sf.toString().length()]).replace("\0", "0"));
		
		return Long.parseLong(sf.toString(), 2);
	}

}
