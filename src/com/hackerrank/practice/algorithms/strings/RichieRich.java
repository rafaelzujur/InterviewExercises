package com.hackerrank.practice.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class RichieRich {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int k = input[1];
		int n = input[0];
		char[] number = sc.nextLine().toCharArray();
		String result = "-1";
		Set<Integer> set = new HashSet<Integer>();
		
		int diff = 0; 
		
		// Transform it into palindrome
		for (int i = 0; i < n/2; i++)
		{
			boolean different = number[i] != number[n-1-i];
			
			if (different)
			{
				diff++;
				
				if (k > 0)
				{
					if ((number[i]-'0') > (number[n-i-1]-'0'))
						number[n-i-1] = number[i];
					else if ((number[i]-'0') < (number[n-i-1]-'0'))
						number[i] = number[n-i-1];
					set.add(i);
					k--;
				}	
				else
					break;
			}			
		}
		
		// Check if it is a palindrome
		if (diff > input[1])
			result = "-1";
		else
		{		
			// Use the remaining K's to make it a larger number
			for (int i = 0; i < n/2; i++)
			{	
				if (k > 0)
				{
					if (number[i] != '9')
					{
						if (set.contains(i))
						{
							number[i] = '9';
							number[n-i-1] = '9';
							k--;
						}
						else
						{
							if (k > 1)
							{
								number[i] = '9';
								number[n-i-1] = '9';
								k-=2;						
							}
							else
							{
								break;														
							}
						}					
					}					
				}
				else
					break;
			}
			
			if (n%2 != 0 && k > 0)
				number[n/2] = '9';
			
			result = String.valueOf(number);		
		}
		
		System.out.println(result);
		
		sc.close();
	}

}
