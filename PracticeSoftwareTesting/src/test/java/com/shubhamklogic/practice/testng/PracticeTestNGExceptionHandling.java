package com.shubhamklogic.practice.testng;

import org.testng.annotations.Test;

public class PracticeTestNGExceptionHandling { 
	
	@Test
	public void printMathResult_v1() {
		System.out.println("9/0="+ (9/0) );
	}
	
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void printMathResult_v2() {
		System.out.println("9/0="+ (9/0) );							// Throws - ArithmeticException
	}																// Exception will be handled by 'expectedExceptions' attribute
	
	@Test(expectedExceptions = {NullPointerException.class, ArithmeticException.class})
	public void printMathResult_v3() {
		
		String name="ShubhamKLogic.com";
		
		if(name != null ) {											// Throws - NullPointerException
			name=null;
			System.out.println( "Name length="+name.length());		// Exception will be handled by 'expectedExceptions' attribute
		}
	}																// Once thrown, No below code of that method will be executed - 
}
