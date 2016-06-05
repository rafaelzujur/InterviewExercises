package com.geeksforgeeks.amazon.school;

import java.util.Scanner;

public class StudentRecord {
	
	public static void main(String[] args) 
	{
	    // Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();

	    while (t > 0)
	    {
		    // Create the variable that holds the student with the maximum avg
		    String maxStudent = null;
		    
		    // Create the variable that holds the max avg
		    int maxAvg = -1;
		    
	    	// Input the number of students
	    	int N = sc.nextInt();
	    	
	    	for (int i = 0; i < N; i++)
	    	{
	    		String student = sc.next();
	    		int avg = 0;
	    		
	    		for (int j = 0; j < 3; j++)
	    			avg += sc.nextInt();
	    		
	    		avg = avg/3;
	    		
	    		if (avg > maxAvg)
	    		{
	    			maxAvg = avg;
	    			maxStudent = student;
	    		}	
	    	}
	            
	        // Check if the rectangles overlap
	        System.out.println(maxStudent + " " + maxAvg);
	        
	        t--;
	            
	    }
	    sc.close();
	}
}
