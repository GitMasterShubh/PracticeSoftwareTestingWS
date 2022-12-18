package com.shubhamklogic.practice.java.tricky.programs;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeCalc1_ReverseAnIntegerNumber {

	// Problem : To reverse the number given by the user.
	public static void main(String[] args) {
		
		int n = 234456;
		
		reverseNumber(n);

	}

	private static void reverseNumber(int n) {
		
		/* 	formula :: Until, Num > 0 
		 		Remainder = Number % 10;
				Reverse = Reverse * 10 + Remainder 
				Number = Number / 10;
		*/
		
		int rem = 0, rev = 0, act = n;
		
		while(n > 0) {
			rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}
		
		SeleniumHelperUtil.log( "\nActual Number  = " + act + "\n\n" + 
								"Reverse Number = " + rev );
		
	}

}
