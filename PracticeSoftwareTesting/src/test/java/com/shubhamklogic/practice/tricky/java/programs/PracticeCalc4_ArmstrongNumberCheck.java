package com.shubhamklogic.practice.tricky.java.programs;

/* 
   Problem : Display Armstrong Number Between Two Intervals 
   Formula of Arm.Num => abcd...n = a*a*..n + b*b*b..n + c*c*c..n ... n
	   Eg: 	Armstrong Num => 153 = 1*1*1 + 5*5*5 + 3*3*3 = 153
	   Eg:  Armstrong Num => ABYZ = A*A*A*A + B*B*B*B + C*C*C*C + D*D*D*D  
*/

public class PracticeCalc4_ArmstrongNumberCheck {

	public static void main(String[] args) {
		
		printArmstrongNumbersBetween(1,1000);
		//	Eg:	Armstrong number between : 0 <--> 1000
		//		0, 1, 153, 370, 371, 407
		
	}

	public static void printArmstrongNumbersBetween(int i, int j) {
		
		System.out.println("Armstrong number between : "+i+" <--> "+ j + " :");
		for (int k = i; k<=j; k++)
			if( isArmstrong( k ))
				System.out.print(k + ", ");
		
	}

	private static boolean isArmstrong(int num) {
		
		int n = num, nDigits=0, rem=0, sum = 0;
		
		while (n > 0) {
			 n /= 10;
			 nDigits++;
		}
		
		n = num;
		
		while ( n > 0 ) {
			rem = n % 10;
			sum += (int)Math.pow(rem, nDigits);
			n /= 10;
		}
		
		if ( sum == num ) 
			return true;
		else 
			return false;
		
	}
}
