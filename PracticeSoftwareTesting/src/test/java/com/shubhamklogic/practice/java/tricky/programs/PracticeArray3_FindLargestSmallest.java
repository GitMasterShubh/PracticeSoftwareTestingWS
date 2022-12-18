package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;

// Guide : 
/*
 * This class help to find largest and smallest number from integer array
 * 
 */

public class PracticeArray3_FindLargestSmallest {

	public static void main(String[] args) {

		findLargestAndSmallest( new int[] {20, -10, -5, 100, -2});
		
	}

	private static void findLargestAndSmallest(int []arr) {
		
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		
		for ( int n : arr) {
			if ( largest < n )
				largest = n;
			if ( smallest > n )
				smallest = n;
		}
		
		System.out.println("Array =====>> " + Arrays.toString(arr));
		System.out.println("Largest  ==>> " + largest);
		System.out.println("Smallest ==>> " + smallest);
		
	}
}
