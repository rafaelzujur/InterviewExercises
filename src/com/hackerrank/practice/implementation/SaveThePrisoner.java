package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/save-the-prisoner
public class SaveThePrisoner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		while (T > 0)
		{			
			int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int N = input[0];
			int M = input[1];
			int S = input[2];
			
			int id = (S-1+(M%N))%N;
			
			if (id == 0)
				id = N;
			
			sb.append(id+"\n");
			
			T--;
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}

}
