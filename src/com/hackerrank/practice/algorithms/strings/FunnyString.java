package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/funny-string
public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		sc.nextLine();
		StringBuffer sb = new StringBuffer();
		
		while (T > 0)
		{
			String str = sc.nextLine();
			
			sb.append(checkFunny(str) + "\n");
			
			T--;
		}	
		
		System.out.println(sb.toString());
		
		sc.close();	
	}
	
	private static String checkFunny(String str)
	{
		for (int i = 1; i < str.length(); i++)
		{
			int a = (int)str.charAt(i);
			int b = (int)str.charAt(i-1);
			int c = (int)str.charAt(str.length()-1-i);
			int d = (int)str.charAt(str.length()-i);
			if (Math.abs(a-b) != Math.abs(c-d))
				return "Not Funny";
		}
		
		return "Funny";
	}

}
