package com.hackerrank.practice.implementation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/strange-code
public class StrangeCounter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long t = sc.nextLong();
		long time = 1;
		long value = 3;
		
		while (time <= t) {
			time = time+value;
			value = value*2;
		}

		System.out.println(time-t);
		
		sc.close();

	}

}
