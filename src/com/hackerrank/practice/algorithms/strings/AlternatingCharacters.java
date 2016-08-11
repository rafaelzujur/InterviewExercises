package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/alternating-characters
public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		sc.nextLine();
		StringBuffer sb = new StringBuffer();
		
		while (T > 0)
		{
			String str = sc.nextLine();
			
			sb.append(countDeletions(str) + "\n");
			
			T--;
		}	
		
		System.out.println(sb.toString());
		
		sc.close();		
	}
	
	private static int countDeletions(String str)
	{
		char current = str.charAt(0);
		int count = 0;
		
		for (int i = 1; i < str.length(); i ++)
		{
			if (current == str.charAt(i))
				count++;
			else
				current = str.charAt(i);
		}
		
		return count;
	}

}
