package com.hackerrank.practice.algorithms.strings;

import java.util.Scanner;
import java.util.stream.Stream;

public class BuildAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		sc.nextLine();
				
		while (T > 0)
		{
			int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = input[0];
			int A = input[1];
			int B = input[2];
			
			String S = sc.nextLine();
			int cost = 0;
			
			StringBuilder left = new StringBuilder();
			left.append(S.charAt(0));
			cost += A;
			
			for (int i = 1; i < N; i++)
			{
				String largest = getOptimalSubstr(left.toString(), S.substring(i).toCharArray(), A, B);
				
				if (largest == null)
				{
					cost+=A;
					left.append(S.charAt(i));
				}
				else 
				{
					if (largest.length()*A < B)
					{
						cost+=A;
						left.append(S.charAt(i));
					}
					else
					{
						cost+=B;
						i+=largest.length()-1;
						left.append(largest);
					}
				}				
			}
			
			sb.append(cost+"\n");
			T--;
		}
		
		System.out.println(sb.toString().trim());

		sc.close();
	}
	
	private static String getOptimalSubstr(String left, char[] right, int A, int B)
	{
		StringBuffer s = new StringBuffer();
		String largest = null;
		
		for (int i = 0; i < right.length; i++)
		{
			s.append(right[i]);
			
			if (left.contains(s.toString()))
				largest = s.toString();
			else
			{
				if (largest != null &&
					largest.length() > 1 && 
					left.contains(s.substring(1)) &&
					A < B)
				{
					largest = largest.substring(0,1);
				}
				else
					break;
			}
			
			if (i+1 > left.length())
				break;
		}
		
		return largest;
	}
	
	/*
	 1
	 300 8987 8990
	 cbcbdbcapcdbcbehbsdkbcapccapcdcbedgscdgscdmhbsdkapccapcdapbcbdbcapcnhcdapbcbdbaedgscdgsclbaedgscdgaegcbdbaedtpbcbdbaedpcaedgscdgaehhmbeoaedtpbcdnbhhmbeocdapblbdbcbcbdbcimhbsdkapccdojbcascdgaehccdnbhhkcdgaqmbhhmbeocdkadiccipridrapcdcbedlblbdbcbcbddojbcascdgbmmhhkcdgaqmbhmbiepccapcdiinrmdcbedlrmcntbfd
	 RESULT = 943764
	 */

}
