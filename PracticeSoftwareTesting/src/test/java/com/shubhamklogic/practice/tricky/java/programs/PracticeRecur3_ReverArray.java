package com.shubhamklogic.practice.tricky.java.programs;

/* Problem : Print sum of first N numbers
   Solution: 
   Video Link: https://youtu.be/69ZCDFy-OUo?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
*/

public class PracticeRecur3_ReverArray {

	public static void main(String[] args) {
	
		// System.out.println( printSum_withoutExtraParam(3) );
		
		printSum_usingExtraParam(3,0);		// Passed params : N=3, initial sum : 0
		
	}

	private static void printSum_usingExtraParam(int n, int sumSoFar) {
		
		if( n < 1 ) {
			System.out.print( sumSoFar );
			return;
		}
		printSum_usingExtraParam( n-1, sumSoFar+n);
	}

	private static int printSum_withoutExtraParam(int n) {
		
		if( n == 1 )
			return n;
		
		int sum = n + printSum_withoutExtraParam(n-1);
		return sum;
	}
}
