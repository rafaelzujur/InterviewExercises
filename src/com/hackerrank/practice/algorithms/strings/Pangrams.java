package com.hackerrank.practice.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/pangrams
public class Pangrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(checkPangram(str));
		
		sc.close();

	}
	
	private static String checkPangram(String str)
	{
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < str.length(); i++)
		{
			char c = Character.toLowerCase(str.charAt(i));
			if (Character.isAlphabetic(c) && !set.contains(c))
				set.add(c);
		}
		
		if (set.size() == 26)
			return "pangram";
		else
			return "not pangram";
	}

}
