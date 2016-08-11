package com.hackerrank.practice.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/non-divisible-subset
public class NonDivisibleSubset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long[] arr = Stream.of(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		int k = input[1];
		int count = 0;
		
		if (k == 1 || k == 2)
			count = k;
		else if (k > 2)
		{
			int[] modArr = new int[k];
			
			for (int i = 0; i < arr.length; i++)
			{
				int mod = (int)arr[i]%k;
				modArr[mod]++;
				
				//System.out.println("arr[i]:" + arr[i] + " has mod " + mod);
			}
			
			count = modArr[0] != 0 ? 1 : 0;
			
			for (int i = 1; i <= k/2; i++)
			{
				int a = modArr[i] == 0 ? 0 : (i*2 == k ? 1 : modArr[i]);
				int b = modArr[k-i] == 0 ? 0 : ((k-i)*2 == k ? 1 : modArr[k-i]);
				count += Math.max(a,b);
			}
				
		}
		
		System.out.println(count);

		sc.close();
	}
}
