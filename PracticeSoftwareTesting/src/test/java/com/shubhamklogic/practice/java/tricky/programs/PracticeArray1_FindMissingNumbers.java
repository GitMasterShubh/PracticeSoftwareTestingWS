package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;
import java.util.BitSet;

/* Problem : How to Find Missing Number on Integer Array of 1 to 100 ?
   Solution:
   		Solving the problem with BitSet 
*/
public class PracticeArray1_FindMissingNumbers {

	public static void main(String[] args) {
		
		printSingleMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);		// Passing array with 1 missing number..
		System.out.println("\n\n\n**************** \n\n");
		printAllMissingNumbers(new int[]{1, 2, 4, 5, 8, 7}, 8);		// Passing array with 2 missing numbers..
		
	}
	
	// Method : BitSet class-
	// This method will work in finding MULTIPLE MISSING NUMBERs from array-
	private static void printAllMissingNumbers(int[] arr, int count) {
		
		// Step-1: Check how many numbers are missing in given array-
		int missingCount = count - arr.length;
        
		
		// Step-2 : Create BitSet array of size=totalNumbersCount, to set given array values on BitSet index..
		BitSet bitSet = new BitSet(count);
        for (int number : arr)
            bitSet.set(number - 1);				// BitSet array index starts from 0..
        
 
        System.out.println("--> Curr Array: " + Arrays.toString(arr) + "\n--> " + missingCount + " Missing Numbers : ");

        
        int nextMissingIndex = 0;

        // Step 3 : 
        // 	Run the loop for all missing numbers,
        //  Then, Find the next clear bit, and print the index+1 number as missing number,
        //  Then, Jump to lastMissingIndex
        for (int i = 0; i < missingCount; i++) {
        	
        	// Current situation :
        	// 		  index = {0  1  2  3  4  5  6  7}
        	// 		currSet = (t, t, F, t, t, F, t, t)		You can assume as, currSet.set(0); will change that BitSet index 0 value from FALSE to TRUE;

        	
        	// Find nextClearBit (next FALSE bit), it's 2 for the first run..
        	int missingNumber = bitSet.nextClearBit( nextMissingIndex );
            System.out.println( missingNumber+1 );
            ++nextMissingIndex;
        }
    }
	
	// Method: Using simple loop - This method will work in finding SINGLE MISSING NUMBER from array- 
	private static void printSingleMissingNumber(int []arr, int totalNumbersCount) {
		// expectedSum = n * (n + 1) / 2
		int expectedSum = totalNumbersCount * (totalNumbersCount + 1) / 2;
		
		int actualSum = 0;
		for (int k : arr)
			actualSum += k;
		
		System.out.println("Current List " + Arrays.toString(arr));
		
		System.out.println("One Missing Number = "+ (expectedSum - actualSum));
	}
}
