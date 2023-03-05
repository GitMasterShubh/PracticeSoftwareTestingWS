package com.shubhamklogic.practice.tricky.java.programs;

/* 
   Problem : 
*/

public class PracticeCalc5_TrickySysoutWithContinue {

	public static void main(String[] args) {
		
		checkSysout();
		System.out.println("\n\n*****\n\n");
		printRemainders(10);
		
	}

	private static void checkSysout() {
		
		for (int i=1; i<=5; i++) {
			if (i%2 == 0) {
				System.out.println(i);
				continue;
			}
			System.out.println("Hello Shubham (i=" + i + ")");
		}
	}
	
	private static void printRemainders(int i) {
		
		for(int k=1; k<=i; k++) {
			System.out.println(i+" % "+k+" = "+ i%k);
		}
	}
}
