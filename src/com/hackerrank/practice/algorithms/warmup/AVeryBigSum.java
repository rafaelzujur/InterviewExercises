package com.hackerrank.practice.algorithms.warmup;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/a-very-big-sum
public class AVeryBigSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		long[] input = Stream.of(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		long result = 0;
		
		for (int i = 0; i < input.length; i++)
			result += input[i];
		
		System.out.println(result);
		
		sc.close();

	}

}
