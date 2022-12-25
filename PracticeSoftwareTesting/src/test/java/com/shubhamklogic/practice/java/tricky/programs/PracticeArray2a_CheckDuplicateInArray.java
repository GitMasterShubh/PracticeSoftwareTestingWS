package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * This class only helps to check - Whether duplicates are present or not. 
 * Getting list of those duplicate objects, is covered in part 2b.
 */

public class PracticeArray2a_CheckDuplicateInArray {

	public static void main(String[] args) {

		// just check duplicacy ..
		checkDuplicatePresent(1, 2, 3, 3, 4, 6);

		// just check duplicacy ..
		checkDuplicatePresent("mango", "banana", "guava", "banana-shake", "mango");

	}

	private static void checkDuplicatePresent(Object... arr) {

		System.out.println("Array = " + Arrays.toString(arr));
		
		techniqueOneToCheckDuplicate(arr);			// technique 1..Insert no.s in Set, If returns False -- Got duplicate !!

		techniqueTwoToCheckDuplicate(arr);			// technique 2..Create List, Create Set, If both's size is diff -- Got duplicate !!

		techniqueThreeToCheckDuplicate(arr);		// technique 3..Compare each value, with whole array values..

	}
	// Insert no.s in Set, If returns False -- Got duplicate
	private static void techniqueOneToCheckDuplicate(Object[] arr) {
		
		Set set = new HashSet();
		
		boolean unique = true;
		for( Object n : arr ) {
			if(set.add(n) == false ) {
				System.out.println("Way 1) There are DUPLICATE element(s) in array\n\n");
				unique = false;
				break;
			}
		}
		if (unique)
			System.out.println("Way 1) There are NO duplicate element(s) in array\n\n");
	}

	// Using Java Collection Framework - Set
	private static void techniqueTwoToCheckDuplicate(Object[] arr) {
		// compare size of Set and Array

		// converting array to list -
		List list = Arrays.asList(arr);

		// creating Set from List -
		Set set = new HashSet(list);

		if (list.size() != set.size())
			System.out.println("Way 2) There are DUPLICATE element(s) in array\n\n");
		else
			System.out.println("Way 2) There are NO duplicate element(s) in array\n\n");

	}

	// BruteForce Technique -
	private static void techniqueThreeToCheckDuplicate(Object[] arr) {

		boolean notFoundDuplicate = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				if (i != j && arr[i] == arr[j]) {
					System.out.println("Way 3) There are DUPLICATE element(s) in array\n\n");
					notFoundDuplicate = false;
					break;
				}
			}
		}
		if (notFoundDuplicate) 
			System.out.println("Way 3) There are NO duplicate element(s) in array\n\n");
	}

}
