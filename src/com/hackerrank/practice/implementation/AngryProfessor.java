package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/angry-professor
public class AngryProfessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		while (T > 0)
		{			
			int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] time = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int count = 0;
			boolean canceled = true;
			
			for (int i = 0; i < time.length; i++)
			{
				if (time[i] <= 0)
					count++;
				if (count >= input[1])
				{					
					canceled = false;
					break;
				}
			}
			
			if (canceled)
				sb.append("YES\n");
			else
				sb.append("NO\n");
			
			T--;
		}
		
		System.out.println(sb.toString());
		
		sc.close();

	}

}
