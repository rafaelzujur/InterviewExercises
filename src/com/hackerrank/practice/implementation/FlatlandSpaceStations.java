package com.hackerrank.practice.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/flatland-space-stations
public class FlatlandSpaceStations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0];
		
		Arrays.sort(arr);
		
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			int d = (arr[i]-arr[i-1])/2;
			
			if (d > max)
				max = d;
		}
		
		if (arr[arr.length-1] != (n-1)) {
			int d = ((n-1)-arr[arr.length-1]);
			if (d > max)
				max = d;
		}
		
		System.out.println(max);
		
		sc.close();
	}

}
