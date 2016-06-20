package com.geeksforgeeks.amazon.basic;

import java.util.Scanner;

public class AngleClockHands {

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	    	String h = sc.next();
	    	
	    	String m = sc.nextLine().trim();
	    		            
	        // Print the prime numbers pair
	    	printMinAngle(Double.parseDouble(h), Double.parseDouble(m));
	        
	        t--;	            
	    }
	    
	    sc.close();

	}
	
	private static void printMinAngle(double h, double m)
	{
		if (h >= 12)
			h = 0;
		
		double hAngle = m >= 60 ? h*30 : h*30 + m/2;
		double mAngle = m*6;
		
		System.out.println(Math.min((int)Math.abs(hAngle-mAngle), (int)Math.abs(360 - Math.max(hAngle, mAngle) + Math.min(hAngle, mAngle))));
	}

}
