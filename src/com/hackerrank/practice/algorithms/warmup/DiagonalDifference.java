package com.hackerrank.practice.algorithms.warmup;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/diagonal-difference
public class DiagonalDifference {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] M = new int[N][N];
		
		sc.nextLine();
		
		for (int i = 0; i < N; i++)
		{
			M[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int diag1 = 0;
		int diag2 = 0;
		
		
		for (int i = 0; i < N; i++)
		{
			diag1 += M[i][i];
			diag2 += M[i][N-1-i];
		}
		
		System.out.println(Math.abs(diag2-diag1));
		
		sc.close();
	}

}
