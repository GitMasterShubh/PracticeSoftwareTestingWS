package com.shubhamklogic.practice.java.tricky.programs;

import java.util.LinkedHashSet;
import java.util.Set;

public class PracticeArray2c_PrintDuplicatesFromArray {

	public static void main(String[] args) {
		
		printDuplicateNumbers(new int[] {0,0,-1,-1,-1 ,10,30, 50,50 ,60, 70,70,70,70,70, 80,90,100, 70});
		
	}
	
	/**
	 * 
	 * @param arr
	 * Creating 2 Objects of LinkedHashSet. 
	 * 		1 obj. -> To store Only Unique Objects/Integers/Strings..
	 * 		2 obj. -> To store duplicate objects (uniquely, so that duplicate element can not store multiple times) 
	 * 
	 */
	public static void printDuplicateNumbers(int[] arr){
		
		Set<Integer> uniqueNumSet = new LinkedHashSet<Integer>();	// To store 'unique numbers'
		Set<Integer> list = new LinkedHashSet<Integer>();			// To store 'duplicate numbers uniquely' 	
		System.out.println("All Numbers : ");
		
		// Adding unique num. and duplicate num.
		for( int n : arr ) {
			System.out.print(n+", ");
			if( !uniqueNumSet.add( n )) 
				list.add(n);
		}
		
		
		System.out.println("\n\nDuplicate Numbers : \n"+ list.toString());
	}	
}
