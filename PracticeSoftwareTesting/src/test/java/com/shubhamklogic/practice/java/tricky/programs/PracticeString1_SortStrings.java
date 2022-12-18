package com.shubhamklogic.practice.java.tricky.programs;

import java.util.Arrays;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeString1_SortStrings {

	public static void main(String[] args) {
		
		String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"aug", "Sep", "Oct", "nov", "Dec" };

		String [] sortedList = sortStrings( inputList );
		
	}

	
	/*
	 * Using Collections Fmk. method to sort the String list --> Arrays.sort (Object[])
	 */
	private static String[] sortStrings(String[] inputList) {
		
		SeleniumHelperUtil.log("Before sorting :\n" , inputList);
		
		Arrays.sort(inputList);
		
		SeleniumHelperUtil.log("\n\nAfter sorting  :\n" , inputList);
		
		return null;
	}
}