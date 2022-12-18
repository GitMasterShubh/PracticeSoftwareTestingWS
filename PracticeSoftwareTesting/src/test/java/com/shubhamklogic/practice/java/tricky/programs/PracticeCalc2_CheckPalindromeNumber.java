package com.shubhamklogic.practice.java.tricky.programs;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

// Problem : Check Whether a Number is Palindrome or Not.
// Solution: An integer is a palindrome if the reverse of that number is equal to the original number
public class PracticeCalc2_CheckPalindromeNumber {

	public static void main(String[] args) {
		
		int n = 1001;		// Palindrome number...
		
		checkPalindrome( n );
		
	}

	// An integer is a palindrome, if the reverse of that number is equal to the original number
	private static void checkPalindrome(int n) {
		
		int rev = 0, rem = 0, actNum = n;
		
		// rem = n%10;
		// rev = rev * 10 + rem ; 
		// n = n/10;
		
		while (n > 0 ) {
			rem = n % 10;
			rev = rev * 10 + rem ;
			n = n / 10;
		}
		if ( actNum == rev) {
			SeleniumHelperUtil.log(" Number "+ actNum +" is a Palindrome Number");
		}else {
			SeleniumHelperUtil.log(" Number "+ actNum +" is NOT a Palindrome Number");
		}
	}
}
