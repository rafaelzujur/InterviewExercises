package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds
public class JumpingOnTheClouds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int jumps = 0;
		int i = 0;
		
		while(true){
			
			if (i == arr.length-1)
				break;
			
			if (i+2 < arr.length && arr[i+2] == 0) {
				i+=2;
				jumps++;
			}
			else if (i+1 < arr.length && arr[i+1] == 0) {
				i++;
				jumps++;
			}
		}
		
		System.out.println(jumps);
		
		sc.close();

	}

}
