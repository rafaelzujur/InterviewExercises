package com.hackerrank.practice.algorithms.warmup;

import java.util.Scanner;
import java.util.stream.Stream;

public class CircularArrayRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] inputLine1 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] query = new int[inputLine1[2]];
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < query.length; i++)
		{
			query[i] = sc.nextInt();
			int position = (arr.length - (inputLine1[1]%arr.length) + query[i])%arr.length;
			sb.append(arr[position]+"\n");
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}

}
