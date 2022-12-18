package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;
import java.util.BitSet;

// Guide : https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html
public class PracticeArray1_FindMissingNumbers {

	public static void main(String[] args) {
		
		// when there is ---> one missing number
		dummyPrintAllMissingNumbers(new int[]{1, 2, 3, 4, 6}, 6);
 
        // when there are --> multiple missing numbers
		dummyPrintAllMissingNumbers(new int[]{1, 2, 4, 5, 8, 7}, 8);

	}
	
	// Using BitSet method - 
	private static void dummyPrintAllMissingNumbers( int []arr, int totalCount ) {
		
		System.out.println("--> Curr Array: "+Arrays.toString(arr) + "\n--> Missing Numbers : ");
		
		// Convert array to BitSet (each set value index will target a FALSE value by default) -
		BitSet currSet = new BitSet( totalCount );
		
		// arr 	    = [1, 2, 4, 5, 8, 7]
		
		//       i	= {0, 1, 2, 3, 4, 5, 6, 7}
		// currSet  = (F, F, F, F, F, F, F, F)
		
		
		// Check how many numbers are missing in given array-
		int missingNumCount = totalCount - arr.length;
		
		// Update BitSet values through their indices (arr values-1 will be the indices) 
		for( int val : arr ) {

			// Set n-1 index value to t : True
			currSet.set(val-1);								// Notice : set() method
		}
		
		//       i = {0  1  2  3  4  5  6  7}
		// currSet = (t, t, F, t, t, F, t, t)

		int nextMissingIndex = 0;
		
		// For each missing number, get the INDEX of next CLEAR (FALSE) bit (or +1 to get missing VALUE) -
		for (int i=0; i<missingNumCount; i++) {
			
			nextMissingIndex = currSet.nextClearBit(nextMissingIndex);		// Notice : nextClearBit() method
			System.out.println( ++nextMissingIndex );
			
		}
	}
	
	
	private static void printAllMissingNumbers(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
 
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
 
        System.out.printf("---->>> Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
 
    }
	
	private static void printSingleMissingNumber(int []arr, int totalNumbersCount) {
		// expectedSum = n * (n + 1) / 2
		int expectedSum = totalNumbersCount * (totalNumbersCount + 1) / 2;
		
		int actualSum = 0;
		for (int k : arr) {
			actualSum += k;
		}
		
		System.out.print("Current List " + Arrays.toString(arr));
		
		System.out.println("====>>> Missing Number = "+ (expectedSum - actualSum));
		
	}

}
