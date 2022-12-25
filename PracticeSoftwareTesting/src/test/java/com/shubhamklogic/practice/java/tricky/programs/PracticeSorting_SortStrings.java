package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;
import java.util.Comparator;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeSorting_SortStrings {

	public static void main(String[] args) {

		// Mix of Capital letter and Small letters-
		String[] inputListStr = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "aug", "Sep", "Oct", "nov", "Dec" };
		
		String[] inputListNum1 = {"1","10","11","2","-3"};
		String[] inputListNum2 = {"1","10","11","2","-3"};

		sortStringsMethod1( inputListStr );			// String array of String words..
		sortStringsMethod1( inputListNum1 );		// String array of String Integers (FAIL : sortStringsMethod1 would NOT be able to sort Numbers passed as String)
		sortStringsMethod2( inputListNum2 );		// Using custom sorting with Comparator..
	}

	/*
	 * Using custom sorting : Comparator with Integer.compare() -
	 */
	private static void sortStringsMethod2(String[] inputListNum) {
		
		SeleniumHelperUtil.log("\n\n***\nMethod2:: Before sorting :\n" , inputListNum);

		Arrays.sort(inputListNum, new Comparator<String>() {		// Passing inputListNum, and an anonymous class obj. that implemented Comparator:compare()
			
			public int compare(String o1, String o2) {
				
				int diff = Integer.valueOf(o1)
								.compareTo(Integer.valueOf(o2));
				
				//Returns the value 0      --> if this Integer is equal to the argument Integer; 
				//  a value less than 0    --> if this Integer is numerically less than the argument Integer; and 
				//  a value greater than 0 --> if this Integer is numerically greater than the argument Integer (signed comparison).
				return diff;
			}
		});
		SeleniumHelperUtil.log("\n\nMethod2:: After sorting  :\n" , inputListNum);
	}


	/*
	 * Using Collections Fmk. method to sort the String list --> Arrays.sort (Object[])
	 */
	private static String[] sortStringsMethod1(String[] inputList) {

		SeleniumHelperUtil.log("\n\n***\nMethod1:: Before sorting :\n" , inputList);

		Arrays.sort(inputList);

		SeleniumHelperUtil.log("\n\nMethod1:: After sorting  :\n" , inputList);

		return null;
	}
	
	
	
}