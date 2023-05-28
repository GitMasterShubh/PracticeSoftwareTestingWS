package com.shubhamklogic.practice.tricky.java.programs;

import java.util.Arrays;

// Guide : 
/*
 * Problem : How to find 1 largest and 1 smallest number from a given integer array
 * 
 */

public class PracticeArray3_FindLargestSmallest {

	public static void main(String[] args) {

		findLargestAndSmallest( new int[] {20, -10, -5, 100, -2});
		
	}

	private static void findLargestAndSmallest(int []arr) {
		
		// set the largest -> MINIMUM value, so other value Bigger than that can be captured..
		int largest = Integer.MIN_VALUE;
		
		// set the smallest -> MAXIMUM value, so other value Smaller than that can be captured..
		int smallest = Integer.MAX_VALUE;
		
		// check complete array..
		for ( int n : arr) {
			if ( n > largest )					// Found new largest value, update it..
				largest = n;
			if ( n < smallest )					// Found new smallest value, update it..
				smallest = n;
		}
		
		System.out.println("Array =====>> " + Arrays.toString(arr));
		System.out.println("Largest  ==>> " + largest);
		System.out.println("Smallest ==>> " + smallest);
		
	}
}
