package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/lisa-workbook
public class LisasWorkbook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0];
		int k = input[1];
		int page = 1;
		int special = 0;
		
		for (int i = 0; i < arr.length; i++) {

			for (int p = 1; p <= arr[i]; p+=k ) {
				int limit = (p+k) <= arr[i] ? p+k-1 : arr[i];
				if (page >= p && page <= limit)
					special++;	
				
				page++;
			}
		}
		
		System.out.println(special);
		
		sc.close();

	}

}
