package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/beautiful-binary-string
public class BeautifulBinaryString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		String str = sc.nextLine();
		
		System.out.println(countChanges(str));
		
		sc.close();

	}
	
	private static int countChanges(String str)
	{
		int count = 0;

		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != '0')
				continue;
			
			if (i+3 <= str.length())
			{
				String part = str.substring(i, i+3);
				
				if (part.equals("010"))
				{
					count++;
					i+=2;
				}
			}			
		}
		
		return count;
	}

}
