package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/divisible-sum-pairs
public class DivisibleSumPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++)
			for (int j = i+1; j < arr.length; j++)
				if ((arr[i]+arr[j])%input[1] == 0)
					count++;
		
		
		System.out.println(count);
		
		sc.close();

	}

}
