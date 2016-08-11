package com.hackerrank.practice.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/cut-the-sticks
public class CutTheSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		IntStream intStream = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt);
		List<Integer> list = new ArrayList<>();
		
		intStream.forEach(list::add);
		
		while (list.size() > 0)
		{
			System.out.println(list.size());
			
			// get the min value
			int min = list.stream().min(Integer::compare).get();
			
			// remove all elements with value min
			list.removeIf(e -> e == min);
			
			// substract the min element from remaining values
			list.replaceAll(e -> e-min);			
		}
		
		sc.close();

	}

}
