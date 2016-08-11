package com.hackerrank.practice.implementation;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/equal-stacks
public class EqualStacks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] stack1 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] stack2 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] stack3 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] sum = new int[]{calcSum(stack1), calcSum(stack2), calcSum(stack3)};
		
		int[] pointer = new int[] {0, 0, 0};
		
		int max = 0;
		
		while (true)
		{
			// check that all sums are equal
			if (sum[0] == sum[1] && sum[1] == sum[2])
				break;
			
			// Get Max element
			max = getMax(sum);
			
			// substract the last element of the stack that has the max height
			if (max == 0)
				sum[max] -= stack1[pointer[max]];
			else if (max == 1)
				sum[max] -= stack2[pointer[max]];
			else
				sum[max] -= stack3[pointer[max]];
			
			// check if the substraction is equal to 0
			if (sum[max] == 0)
				break;
			
			// move the pointer to the previous element
			pointer[max]++;
			
		}
		
		System.out.println(sum[max]);
		
		sc.close();

	}
	
	private static int calcSum(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		return sum;
	}
	
	private static int getMax(int[] arr)
	{
		int max = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > arr[max])
				max = i;
		
		return max;
	}

}
