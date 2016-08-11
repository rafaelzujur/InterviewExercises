package com.hackerrank.contest.contest_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
Killgrave wants to use his mind control powers to get money from the Justice League superheroes living in houses in Happy Harbor that are numbered sequentially from  to . There are  roads, and each road connects two different houses,  and . Each superhero house  (where ) has  dollars stashed away for a rainy day.

As long as a superhero is home at house , Killgrave knows they will hand over all of their saved money, . Once he gets money from them, he moves on to the next house. However, the superheroes are cunning; when Killgrave comes to house , every neighbor immediately connected to house  by a single road skips town for a couple of days (making it impossible for Killgrave to get money from them). In other words, after Killgrave visits all the superheroes he wants, there will be no road in which he was able to get money from both houses on either end of the road.

What is the maximum amount of money Killgrave can collect from the superheroes, and how many different ways can Killgrave get that amount of money? Two ways are considered to be different if the sets of visited houses are different.

Note: Killgrave can start at an arbitrary house and doesn't have to only use the roads.

Input Format

The first line contains two space-separated integers,  (the number of houses) and  (the number of roads), respectively. 
The second line contains  space-separated integers, where each integer  describes the amount of money, , at house . 
Each line  of the  subsequent lines contains two space-separated integers defining a road connecting houses  and . Every road connects a different pair of houses.

Constraints

, where 
No unordered pair  will appear more than once.
Output Format

Print two space-separated integers:

The first integer must denote the maximum amount of money Killgrave can get out of the Justice League.
The second integer must denote the number of different ways he can collect that amount of money.
 */
public class DemandingMoney {
	private static boolean[] emptyHouseArr;
	private static boolean[][] connectedRoads;
	private static int[] moneyArr;
	private static int maxAmount = -1;
	private static Set<Set<Integer>> maxCombinationSet = new HashSet<Set<Integer>>();
	
	public static void main(String[] args) 
	{
		// Create the scanner object
	    Scanner sc = new Scanner(System.in);
	    
	    // Input the number of houses and number of roads
	    String line = sc.nextLine();
    	String[] lineArr = line.split(" ");
    	
    	// Set the number of houses
    	int N = Integer.parseInt(lineArr[0]);
    	
    	// Set the number of roads
    	int M = Integer.parseInt(lineArr[1]);
    	
    	// Initialize the class variables
    	emptyHouseArr = new boolean[N];
    	moneyArr = new int[N];
    	connectedRoads = new boolean[N][N];
    	
    	// Input the money located in each house
    	line = sc.nextLine();
    	lineArr = line.split(" ");
    	
    	for (int i = 0; i < N; i++)
    		moneyArr[i] = Integer.parseInt(lineArr[i]);
    	
    	// Input the roads that connect the houses
    	while (M > 0)
    	{
    		// Input the money located in each house
        	line = sc.nextLine();
        	lineArr = line.split(" ");
        	int i = Integer.parseInt(lineArr[0])-1;
        	int j = Integer.parseInt(lineArr[1])-1;
        	connectedRoads[i][j] = true;       	
        	connectedRoads[j][i] = true;
        	M--;
    	}
    	
    	// Execute recursive function
    	getMoney(0, new HashSet<Integer>());
    	
    	System.out.println(maxAmount + " " + maxCombinationSet.size());
    	
    	//for (Set<Integer> s : maxCombinationSet)
    	//	System.out.println(s);
	}
	
	private static void getMoney(int moneyCollected, HashSet<Integer> combination)
	{
		// Base case
		if (allHousesEmpty())
		{
			// Check the money collected is greater that the maximum
			if (moneyCollected > maxAmount)
			{
				maxAmount = moneyCollected;
				maxCombinationSet.clear();
				maxCombinationSet.add(new HashSet<Integer>(combination));
			}
			else if (moneyCollected == maxAmount)
			{
				maxCombinationSet.add(new HashSet<Integer>(combination));
			}
			
			return;
		}
		
		// Iterate over the array of empty houses
		for (int i = 0; i < emptyHouseArr.length; i++)
		{
			// Check the house is not empty
			if (!emptyHouseArr[i])
			{ // There is a superhero in the house
				
				// Add the element to the combination
				combination.add(i);
				
				// Collect the money
				moneyCollected+=moneyArr[i];
				
				// Create a clone of the array
				boolean[] beforeChanges = emptyHouseArr.clone();
				
				// Set the affected houses as empty
				setHouseStatus(i, true);
				
				// Recursive call
				getMoney(moneyCollected, combination);
				
				// Set the affected houses as busy (backtracking) and return the money
				emptyHouseArr = beforeChanges;				
				moneyCollected-=moneyArr[i];
				combination.remove(i);
			}
		}
	}
	
	private static void setHouseStatus(int i, boolean status)
	{
		// Set the current house as empty
		emptyHouseArr[i] = status;
		
		// Check which houses are connected to i
		for (int j = 0; j < emptyHouseArr.length; j++)
		{
			// Check if house is connected to i
			if (connectedRoads[i][j])
			{	// The houses are connected
				// Set the connected house as empty
				emptyHouseArr[j] = status;
			}
		}
	}
	
	private static boolean allHousesEmpty()
	{
		for (int i = 0; i < emptyHouseArr.length; i++)
			if (!emptyHouseArr[i] && moneyArr[i] > 0)
				return false;
		
		return true;
	}

}
