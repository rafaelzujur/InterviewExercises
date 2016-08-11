package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

public class JumpingOnTheCloudsRevisited {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int k = input[1];
		int E = 100;
		int i = 0;
		
		do {
			i = (i+k)%N;
			
			if (arr[i] == 0)
				E--;
			else 
				E = E-3;
			
		} while (i > 0);
		
		System.out.println(E);
		
		sc.close();

	}

}
