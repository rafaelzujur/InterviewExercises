package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/camelcase
public class CamelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(findLetters(str));
		
		sc.close();

	}
	
	private static int findLetters(String str)
	{
		int countUpper = 0;
		
		for (int i = 0; i < str.length(); i++)
		{
			if (Character.isUpperCase(str.charAt(i)))
				countUpper++;
		}
		
		if (str.length() > 0)
			countUpper++;
		
		return countUpper;
	}

}
