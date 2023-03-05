package com.shubhamklogic.practice.tricky.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 * Problem Statement: 
 * 	1. How to remove duplicates elements from Array ? (Without Preserving the order of items)
 * 
 * 
 * Other Scenarios: 
 * 	2. How to remove duplicates elements from ArrayList preserving their order of items-
 * 
 */

public class PracticeArray2b_RemoveDuplicatesFromArray {

	public static void main(String[] args) {

		int arr[] = {10,20,30,30,40,60,20,50};
		
		System.out.println("Array with duplicates = " + Arrays.toString(arr));
		
		techniqueOneToRemoveDuplicate(arr);

		techniqueTwoToRemoveDuplicate(arr);
	}

	// Solution of Scenario 1: 
	//	Q. How to remove duplicates elements from Array ? (Without Preserving the order of items)
	//  A. Use conversions :- new ArrayList -> new HashSet -> new ArrayList
	private static void techniqueOneToRemoveDuplicate(int[] arr) {
		
		// Primitive array to ArrayList conversion can be possible with this simple solution ONLY -
		ArrayList arrList = new ArrayList();
		for(int n : arr) arrList.add(n);					
		
		HashSet set = new HashSet(arrList);
		
		ArrayList uniqueArrList = new ArrayList( set );
		
		System.out.print("Array without duplicates = ");
		
		print(uniqueArrList);
	}


	// Scenario 2 : 
	//  Q. How to remove duplicates elements from ArrayList ? (Saving order of items) -
	//  A. Use : new ArrayList -> new LinkedHashSet -> new ArrayList
	private static void techniqueTwoToRemoveDuplicate(int[] arr) {
		
		ArrayList aList = new ArrayList( arr.length );
		for(int n:arr) aList.add(n);
		
		LinkedHashSet set = new LinkedHashSet(aList);
		
		ArrayList bList = new ArrayList(set);
		
		System.out.print("Array without duplicates = ");
		
		print(bList);
		
	}

	private static void print(ArrayList uniqueArrList) {
		
		for (Object i : uniqueArrList) {
			System.out.print(i.toString()+", ");
		}
		
		
	}
}
