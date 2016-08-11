package com.geeksforgeeks.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NMeetingsRoom {
	
	public class Meeting {
		public int start;
		public int end;
		public int index;
		
		public Meeting(){}
	}

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of test cases
	    int t = sc.nextInt();
	    
	    sc.nextLine();
	    
	    while (t > 0)
	    {	        
	    	int N =  sc.nextInt();
		    
		    sc.nextLine();
	    	
	    	int[] start = new int[N];
	    	int[] end = new int[N];

	    	String line = sc.nextLine();
	        String[] lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	start[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        line = sc.nextLine();
	        lineArr = line.split(" ");

	        for (int i = 0; i < lineArr.length; i++)
	        {
	        	end[i] = Integer.parseInt(lineArr[i]);
	        }
	        
	        printMeetings(start, end);

	        t--;
	    }
	}
	
	private static void printMeetings(int[] start, int[] end)
	{
		NMeetingsRoom.Meeting[] m = new NMeetingsRoom.Meeting[start.length];
		
		for (int i = 0; i < m.length; i++)
		{
			NMeetingsRoom mr = new NMeetingsRoom();
			
			m[i] = mr.new Meeting();
			m[i].start = start[i];
			m[i].end = end[i];
			m[i].index = i+1;
		}

		Arrays.sort(m, new Comparator<NMeetingsRoom.Meeting>(){
			@Override
			public int compare(Meeting m1, Meeting m2) {
				return m1.end-m2.end;
			}			
		});
		
		StringBuffer sb = new StringBuffer();
		NMeetingsRoom.Meeting meeting = m[0];
		sb.append(meeting.index + " ");
		
		for (int i = 1; i < m.length; i++)
		{
			if (meeting.end < m[i].start)
			{
				sb.append(m[i].index + " ");
				meeting = m[i];
			}
		}
		
		System.out.println(sb.toString().trim());	
	}

}
