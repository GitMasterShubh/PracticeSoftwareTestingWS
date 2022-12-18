package com.shubhamklogic.practice.java.tricky.programs;

// Problem : Display Armstrong Number Between Two Intervals
// Eg: Armstrong Num => 153 = 1*1*1 + 5*5*5 + 3*3*3 = 153

public class PracticeCalc4_ArmstrongNumberCheck {

	public static void main(String[] args) {
		
		printArmstrongNumbersBetween(1,1000);
		//		Armstrong number between : 0 <--> 1000 :
		//		0, 1, 153, 370, 371, 407,
		
	}

	public static void printArmstrongNumbersBetween(int i, int j) {
		
		System.out.println("Armstrong number between : "+i+" <--> "+ j + " :");
		for (int k = i; k<=j; k++)
			if( isArmstrong( k ))
				System.out.print(k + ", ");
		
	}

	private static boolean isArmstrong(int num) {
		
		int n = num, rem, sum = 0; 
		
		while ( n > 0 ) {
			rem = n%10;
			sum += rem*rem*rem;
			n /= 10;
		}
		
		if ( sum == num ) 
			return true;
		else 
			return false;
		
	}
}
