package com.hackerrank.practice.implementation;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/minimum-distances
public class MinimumDistances {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		HashMap<Integer, Integer> map = new HashMap<>();
		int min = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int pos = map.get(arr[i]);
				int d = i-pos;
				min = min == -1 ? d : (d < min ? d : min);
				
			}
			map.put(arr[i], i);
		}
			
		System.out.println(min);
		
		sc.close();
	}

}
