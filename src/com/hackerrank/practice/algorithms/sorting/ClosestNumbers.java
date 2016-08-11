package com.hackerrank.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(arr);
		
		int difference = arr[1]-arr[0];

		for (int i = 1; i < arr.length; i++)
		{
			if ((arr[i]-arr[i-1]) < difference) {
				difference = arr[i]-arr[i-1];
				sb = new StringBuffer();
				sb.append(arr[i-1] + " " + arr[i] + " ");
			}
			else if ((arr[i]-arr[i-1]) == difference)
				sb.append(arr[i-1] + " " + arr[i] + " ");
			
		}
		
		System.out.println(sb.toString().trim());

	}

}
