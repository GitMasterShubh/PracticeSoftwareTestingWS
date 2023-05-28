package com.shubhamklogic.practice.tricky.java.programs;

import java.util.Arrays;
import java.util.Comparator;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeSorting_SortStrings {

	public static void main(String[] args) {

		// Mix of Capital letter and Small letters-
		String[] inputListStr = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",   
								  "Jul", "aug", "Sep", "Oct", "nov", "Dec" };
		String[] inputListNum1 = {"1","10","11","2","-3"};
		String[] inputListNum2 = {"1","10","11","2","-3"};
		
		sortStringsMethod1( inputListStr );		// String array of String words..
		
		// Below call will FAIL in Sorting: 
		// 		 Coz, sortStringsMethod1 would NOT be able to sort Numbers passed as String)
		sortStringsMethod1( inputListNum1 );	// String array of String Integers 
		
		// So for custom sorting, use Comparator :: apply() { compare (){...} }
		sortStringsMethod2( inputListNum2 );	// Using custom sorting with Comparator..
	}

	/*
	 * Using Collections Fmk. method to sort the String list --> Arrays.sort (Object[])
	 */
	private static void sortStringsMethod1(String[] inputList) {

		SeleniumHelperUtil.log("\n\n\nMethod1:: Before sorting :\n" , inputList);

		Arrays.sort(inputList);

		SeleniumHelperUtil.log("\n\nMethod1:: After sorting  :\n" , inputList);

	}
	
	/*
	 * Using custom sorting : Comparator with Integer.compare() -
	 */
	private static void sortStringsMethod2(String[] inputListNum) {
		
		SeleniumHelperUtil.log("\n\n\nMethod2:: Before sorting :\n" , inputListNum);

		// Passing inputListNum, and an anonymous class obj. that implements Comparator:compare()
		Arrays.sort(inputListNum, new Comparator<String>() {
			
			public int compare(String newVal, String prevVal) {
				
				int diff = Integer.valueOf(newVal)
								.compareTo(Integer.valueOf(prevVal));
				
				// Returns the value 0      		--> if newVal object is equals to prevVal  
				//  a value LESSER than  0 (-ive)   --> if newVal should come BEFORE prevVal 
				//  a value GREATER than 0 (+ive)  	--> if newVal should come AFTER prevVal
				return diff;
			}
		});
		SeleniumHelperUtil.log("\n\nMethod2:: After sorting  :\n" , inputListNum);
	}
}