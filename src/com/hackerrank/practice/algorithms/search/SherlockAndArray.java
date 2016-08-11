package com.hackerrank.practice.algorithms.search;

import java.util.Scanner;
import java.util.stream.Stream;

public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
				
		while (T > 0)
		{
			int N = sc.nextInt();
				
			sc.nextLine();
			
			int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			// Calculate the sum of the elements
			int sumRight = 0;
			for (int i = 0; i < arr.length; i++)
				sumRight+=arr[i];
			
			int sumLeft = 0;
			boolean found = false;
			// Iterate over the array to find is there are equal sums
			for (int i = 0; i < arr.length; i++)
			{
				if (sumLeft == (sumRight-arr[i]-sumLeft)) {
					found = true;
					break;
				}	
				
				sumLeft+=arr[i];
			}
			
			if (found)
				sb.append("YES\n");
			else
				sb.append("NO\n");
						
			T--;
		}
		
		System.out.println(sb.toString());
		sc.close();

	}

}
