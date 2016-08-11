package com.hackerrank.practice.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/string-construction
public class StringConstruction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] arr = new String[N];
		
		sc.nextLine();
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLine();
		
		for (int i = 0; i < N; i++)
			System.out.println(calcCost(arr[i]));
		
		sc.close();

	}
	
	private static int calcCost(String str)
	{
		int cost = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < str.length(); i++)
		{
			if (!set.contains(str.charAt(i)))
			{
				cost++;
				set.add(str.charAt(i));
			}
		}		
		
		return cost;
	}

}
