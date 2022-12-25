package com.shubhamklogic.practice.java.tricky.programs;

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
		
		int largest = Integer.MIN_VALUE;		// set the largest -> MINIMUM value, so other value Bigger than that can be captured..
		int smallest = Integer.MAX_VALUE;		// set the smallest -> MAXIMUM value, so other value Smaller than that can be captured..
		
		for ( int n : arr) {					// Check complete array..
			if ( n > largest )
				largest = n;
			if ( n < smallest )
				smallest = n;
		}
		
		System.out.println("Array =====>> " + Arrays.toString(arr));
		System.out.println("Largest  ==>> " + largest);
		System.out.println("Smallest ==>> " + smallest);
		
	}
}
