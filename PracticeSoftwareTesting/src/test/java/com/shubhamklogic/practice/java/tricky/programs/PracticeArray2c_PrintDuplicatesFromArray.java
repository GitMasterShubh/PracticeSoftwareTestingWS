package com.shubhamklogic.practice.java.tricky.programs;

import java.util.LinkedHashSet;
import java.util.Set;

// Problem : For a given array of integers/String values, print all duplicate values -
public class PracticeArray2c_PrintDuplicatesFromArray {

	public static void main(String[] args) {
		
		printDuplicateNumbers(new int[] {0,0,-1,-1,-1 ,10,30, 50,50 ,60, 70,70,70,70,70, 80,90,100, 70});
		
	}
	
	/**
	 * 
	 * @param arr
	 * Creating 2 Objects of LinkedHashSet. 
	 * 		Step-1 Create Set obj. -> To store Only Unique Objects/Integers/Strings..
	 * 		Step-2 Create Set obj. -> To store duplicate objects (uniquely, so that duplicate element can not store multiple times)
	 * 		Step-3 Add values in Set -> From the given list, Add value in first Set. If its return false, save that value in another Set, That's duplicate value.   
	 * 
	 */
	public static void printDuplicateNumbers(int[] arr){
		
		Set<Integer> uniqueNumSet = new LinkedHashSet<Integer>();	// To store 'unique numbers'
		Set<Integer> list = new LinkedHashSet<Integer>();			// To store 'duplicate numbers uniquely' 	
		System.out.println("All Numbers : ");
		
		// Adding unique num. and duplicate num.
		for( int num : arr ) {
			System.out.print( num + ", ");
			if( !uniqueNumSet.add( num )) 							// if got 'false' during add(), means, we found a duplicate num..
				list.add(num);										// store it..
		}
		
		System.out.println("\n\nDuplicate Numbers : \n"+ list.toString());
	}	
}
