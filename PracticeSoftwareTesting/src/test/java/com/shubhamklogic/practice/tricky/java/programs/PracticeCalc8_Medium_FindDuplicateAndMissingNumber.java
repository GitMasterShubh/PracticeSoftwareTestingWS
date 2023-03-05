package com.shubhamklogic.practice.tricky.java.programs;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

/**
 * 
 * @author ssrivastava <br>
 *         Problem Name : Find Duplicate and Missing Number<br>
 *         Problem Link : <br>
 *         Video Solution : https://youtu.be/5nMGY4VUoRY?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2 (YT : Take u Forward<br>
 *         Many solutions : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ <br>
 *         KD: LeetCode_Medium_Level
 * 
 */

public class PracticeCalc8_Medium_FindDuplicateAndMissingNumber {

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 4, 2, 2 };
		int[] arr2 = { 3, 1, 3, 4, 2 };

		SeleniumHelperUtil.log("Arrary1 : " + java.util.Arrays.toString(arr1));
		findDuplicateAndMissed(arr1);
	}

	public static void findDuplicateAndMissed(int[] arr) {

		SeleniumHelperUtil.log("Print Duplicate and Missed Numbers: ");
		Map<Integer, Boolean> nMap = new HashMap<>();

		int max = arr.length;

		for (Integer i : arr) {

			if (nMap.get(i) == null) {
				nMap.put(i, true);
			} else {
				System.out.println("Duplicate = " + i);
			}
		}
		for (int i = 1; i <= max; i++) {
			if (nMap.get(i) == null) {
				System.out.println("Missing = " + i);
			}
		}
	}
}
