package com.hackerrank.contest.contest_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {
	
	public static void main(String[] args) 
	{
		int sum = 0;
		
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int N = Integer.parseInt(sc.next());
	    
	    int K = Integer.parseInt(sc.next());
	    
	    List<Integer> list = new ArrayList<Integer>();

	    while (N > 0)
	    {
	    	int luck = Integer.parseInt(sc.next());
	    	int importance = Integer.parseInt(sc.next());
	    	
	    	if (importance == 0)
	    		sum += luck;
	    	else
	    		list.add(luck);
	    	N--;
	    }
	    
	   list.sort((a, b) -> Integer.compare(a,  b));
	   
	   for (int i = list.size()-1; i >= 0; i--)
	   {
		   int value = list.get(i);
		   if (K > 0)
			   sum += value;
		   else
			   sum -= value;
		   
		   K--;
	   }
	   
	   System.out.println(sum);
	    
	    sc.close();	
	}
}
