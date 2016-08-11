package com.hackerrank.contest.contest_1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TheLetterN {
	private static List<Point> points = new ArrayList<Point>();
	private static int count;
	private static Set<String> added = new HashSet<String>();

	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of points
    	int N = sc.nextInt();

    	sc.nextLine();
    	
    	for (int i = 0; i < N; i++)
    	{
    		// Input the point coordinates
    	    String line = sc.nextLine();
        	String[] lineArr = line.split(" ");
        	
        	// Add the point
        	points.add(new Point(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
    	}
    	
    	findN();
    	
    	System.out.println(count);
		
		//System.out.println(calcAngle(new Point(0,0), new Point(0,2), new Point(2,0)));
		//System.out.println(getPosition(new Point(2,2), new Point(0,2), new Point(2,0)));

	}
	
	private static void findN()
	{
		for (int i = 0; i < points.size(); i++)
		{
			Point a = points.get(i);
			
			for (int j = 0; j < points.size(); j++)
			{
				if (j == i)
					continue;
				
				Point b = points.get(j);
				
				List<Point> validPointsRight = dividePointsByLine(a, b, points, 1, false, null);

				if (validPointsRight.size() < 2)
					continue;
				
				for (int k = 0; k < validPointsRight.size(); k++)
				{
					Point c = validPointsRight.get(k);
					
					if (calcAngle(a, b, c) > 90)
						continue;
					
					List<Point> validPointsLeft = dividePointsByLine(b, c, validPointsRight, -1, true, a);
					
					for (int m = 0; m < validPointsLeft.size(); m++)
					{																		
						Point d = validPointsLeft.get(m);

//							System.out.print("["+a.x + "," + a.y+"] ");
//							System.out.print("[" + b.x + "," + b.y + "] ");
//							System.out.print("["+c.x + "," + c.y+"] ");
//							System.out.println("["+d.x + ", " + d.y+"]");
						
						added.add(a.x+""+a.y+""+b.x+""+b.y+c.x+""+c.y+""+d.x+""+d.y);
						added.add(d.x+""+d.y+""+c.x+""+c.y+b.x+""+b.y+""+a.x+""+a.y);
						count++;
					}					
				}		
			}
		}
	}
	
	private static double calcAngle(Point a, Point b, Point c)
	{
		// Calculate vector AB
		Point ba = new Point(a.x-b.x, a.y-b.y);
		
		// Calculate vector BC
		Point bc = new Point(c.x-b.x, c.y-b.y);
		
		// Calc the numerator
		double numerator = ba.x*bc.x + ba.y*bc.y;
		double denominator = Math.sqrt(ba.x*ba.x + ba.y*ba.y)*Math.sqrt(bc.x*bc.x + bc.y*bc.y);
		
		double angle = Math.acos(numerator/denominator);
		
		double degrees = Math.toDegrees(angle);
				
		return degrees;
	}
	
	private static List<Point> dividePointsByLine(Point a, Point b, List<Point> points, int position, boolean validateDegrees, Point initP)
	{
		List<Point> validPoints = new ArrayList<Point>();
		
		for (int i = 0; i < points.size(); i++)
		{
			Point p = points.get(i);
			
			if (p.equals(a) || p.equals(b))
				continue;
			
			if (getPosition(p, a, b) == position)
			{
				if (!validateDegrees || validateDegrees && calcAngle(a, b, p) <= 90)
					if (initP == null || !added.contains(initP.x+""+initP.y+""+a.x+""+a.y+b.x+""+b.y+""+p.x+""+p.y))
						validPoints.add(p);
			}
		}
		
		return validPoints;
	}
	
	private static int getPosition(Point a, Point b, Point c)
	{
		// Calculate the direction of the vector
		int direction_x = c.x-b.x;
		int direction_y = c.y-b.y ;
		
		// Calculate a formula that computes a line that passes through b and c (y = mx + d)
		double num = (c.y-b.y);
		double den = (c.x-b.x);
		
		double position = 0;
		
		if (den != 0)
		{
			double m = num/den;
			
			double d = c.y - m*c.x;
			
			position = a.y - m*a.x - d;
		}
		else
		{
			position = a.x - c.x;
		}
		
		if ((direction_x > 0 && direction_y < 0 && position < 0) || 
			(direction_x < 0 && direction_y < 0 && position > 0) ||
			(direction_x > 0 && direction_y > 0 && position < 0) ||
			(direction_x < 0 && direction_y > 0 && position > 0) ||
			(direction_x == 0 && direction_y > 0 && position > 0) ||
			(direction_x == 0 && direction_y < 0 && position < 0) ||
			(direction_x > 0  && direction_y == 0 && position < 0) ||
			(direction_x < 0  && direction_y == 0 && position > 0))
			return 1;	// right side
		else if ((direction_x > 0 && direction_y < 0 && position > 0) || 
				(direction_x < 0 && direction_y < 0 && position < 0) ||
				(direction_x > 0 && direction_y > 0 && position > 0) ||
				(direction_x < 0 && direction_y > 0 && position < 0) ||
				(direction_x == 0 && direction_y > 0 && position < 0) ||
				(direction_x == 0 && direction_y < 0 && position > 0) ||
				(direction_x > 0  && direction_y == 0 && position > 0) ||
				(direction_x < 0  && direction_y == 0 && position < 0)) // left side
			return -1;
		else 
			return 0;
	}

}
