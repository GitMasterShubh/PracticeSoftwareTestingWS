package com.shubhamklogic.practice.tricky.java.programs;

/* Problem : Print N to 1 using Backtracking and Recursion
   Solution:
   Video Link: https://youtu.be/69ZCDFy-OUo?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
*/

public class PracticeRecur1_SimplePrint {

	public static void main(String[] args) {
	
		printReverseTill1_withoutBacktracking(12);
		
	}

	private static void printReverseTill1_withoutBacktracking(int i) {
		
		if( i < 1 )
			return;
		
		System.out.println(i);
		printReverseTill1_withoutBacktracking( i-1 );
		
	}
}
