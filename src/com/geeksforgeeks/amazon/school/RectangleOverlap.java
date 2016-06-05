package com.geeksforgeeks.amazon.school;

import java.util.Scanner;

public class RectangleOverlap {

	public static int overlap(int[] a_coord, int[] b_coord)
    {
        // Check the conditions for when the rectangles DO NOT overlap
        if (a_coord[3] > b_coord[1] ||
            b_coord[3] > a_coord[1] ||
            a_coord[0] > b_coord[2] ||
            b_coord[0] > a_coord[2])
            {
                return 0;
            }
        else
            return 1;
    }
    
	public static void main (String[] args) 
	{
	    // Define the coordinate for rectangle a
	    int[] a_coord = new int[4];
	    
	    // Define the coordinate for rectangle b
	    int[] b_coord = new int[4];
	    
	    // Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    while (t > 0)
	    {
	        // Input the coordinate for rectangle a
	        for (int i = 0; i < a_coord.length; i++)
	            a_coord[i] = sc.nextInt();
	        
	        // Input the coordinate for rectangle b
	        for (int i = 0; i < b_coord.length; i++)
	            b_coord[i] = sc.nextInt(); 
	            
	        // Check if the rectangles overlap
	        System.out.println("Result is: " + overlap(a_coord, b_coord));
	        
	        t--;
	            
	    }
	    
	    sc.close();
	}

}
