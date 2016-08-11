package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/reduced-string
public class SuperReducedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(reduceStr(str));
		
		sc.close();
	}
	
	private static String reduceStr(String str)
	{
		StringBuffer sb = new StringBuffer();
		char current = str.charAt(0);
		int count = 1;
		
		for (int i = 1; i < str.length(); i++)
		{
			if (current == str.charAt(i))
				count++;
			else
			{	
				if (count%2 != 0)
				{
					count = 1;	
					sb.append(current);
				}
				else
				{
					count = 1;
					if (sb.length() > 0)
					{
						if (sb.charAt(sb.length()-1) == str.charAt(i))
						{
							sb.deleteCharAt(sb.length()-1);
							count = 2;
						}							
					}
				}
				
				current = str.charAt(i);
			}			
		}
		
		if (count%2 != 0)
			sb.append(current);
		
		if (sb.length() == 0)
			return "Empty String";
		else
			return sb.toString();
	}

}
