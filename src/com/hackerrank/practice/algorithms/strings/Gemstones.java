package com.hackerrank.practice.algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/gem-stones
public class Gemstones {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] arr = new String[N];
		
		sc.nextLine();
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLine();
		
		System.out.println(countCommonGems(arr));
		
		sc.close();

	}
	
	private static int countCommonGems(String[] arr)
	{
		int count = 0;
		HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
		
		for (int i = 0; i < arr.length; i++)
		{
			HashSet<Character> set = new HashSet<Character>();
			
			for (int j = 0; j < arr[i].length(); j++)
			{
				char c = arr[i].charAt(j);
				if (!set.contains(c))
				{
					set.add(c);
					
					if (!map.containsKey(c))
						map.put(c, 1);
					else
						map.put(c, map.get(c)+1);
				}
			}
		}
		
		for (char c : map.keySet())
			if (map.get(c) == arr.length)
				count++;
		
		return count;		
	}

}
