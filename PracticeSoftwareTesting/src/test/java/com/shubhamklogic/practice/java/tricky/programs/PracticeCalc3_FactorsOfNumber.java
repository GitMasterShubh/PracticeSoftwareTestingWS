package com.shubhamklogic.practice.java.tricky.programs;

import java.util.LinkedList;
import java.util.List;

// Problem : How to calculate factor ?
// Given   : 20
// Output  : 1,2,4,5,10

public class PracticeCalc3_FactorsOfNumber {

	public static void main(String[] args) {
		
		printAllFactorsOf(63);
		
	}

	public static void printAllFactorsOf(int num) {
		
		List facList = new LinkedList();
		int tempNum = num, k = 1;
		
		while (k <= tempNum/2) {
			int rem = tempNum % k;
			if( rem == 0 )
				facList.add( k );
			k++;
		}
		
		System.out.println("All Factors of "+ num +" = \n"+ facList);
	}
}
