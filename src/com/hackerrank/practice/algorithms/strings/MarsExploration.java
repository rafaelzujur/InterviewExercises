package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mars-exploration
public class MarsExploration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(countAltered(str));
		
		sc.close();

	}
	
	private static int countAltered(String str)
	{
		int count = 0;
		
		for (int i = 0; i < str.length(); i+=3)
		{
			if (str.charAt(i) != 'S')
				count++;
			if (str.charAt(i+1) != 'O')
				count++;
			if (str.charAt(i+2) != 'S')
				count++;
		}
		
		return count;
	}

}
