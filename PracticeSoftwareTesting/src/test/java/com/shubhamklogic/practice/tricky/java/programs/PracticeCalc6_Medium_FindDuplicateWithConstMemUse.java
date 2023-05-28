package com.shubhamklogic.practice.tricky.java.programs;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

/**
 * 
 * @author ssrivastava
 * <br> Problem Link   : https://leetcode.com/problems/find-the-duplicate-number/
 * <br> Video Solution : https://youtu.be/32Ll35mhWg0?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2 (YT: Take U Forward)
 * <br> Problem Name : Find the Duplicate Number
 * <br> Problem Desc : Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <br> There is only one repeated number in nums, return this repeated number.
 * <br> You must solve the problem without modifying the array nums and uses only constant extra space. 
 * <br> Example 1:
 * <br> Input: nums = [1,3,4,2,2]
 * <br> Output: 2
 * <br> Example 2:
 * <br> Input: nums = [3,1,3,4,2]
 * <br> Output: 3
 * <br> KD: LeetCode_Medium_Level
 * 
 */

public class PracticeCalc6_Medium_FindDuplicateWithConstMemUse {
	
	public static void main(String[] args) {
		
		int []arr1 = { 1,3,4,2,2 };
		int []arr2 = { 3,1,3,4,2 };
		
		SeleniumHelperUtil.log( "Arrary1 : "+ java.util.Arrays.toString(arr1));
		SeleniumHelperUtil.log( "Duplicate Found : " + getDuplicateInd(arr1));

		SeleniumHelperUtil.log( "Arrary2 : "+ java.util.Arrays.toString(arr2));
		SeleniumHelperUtil.log( "Duplicate Found : " + getDuplicateInd(arr2));		
	}

	public static int getDuplicateInd(int[] arr) {
		
		int slow = arr[0];
		int fast = arr[0];
		
		do {
			slow = arr[ slow ];			// slow pointer will move 1 step..
			fast = arr[ arr[ fast ] ];	// fast pointer will move 2 step..
			
		}while (slow != fast);			// 1st collision.. reset the fast to start..
		
		fast = arr[0];
		
		while ( slow != fast ) {
			
			slow = arr [slow];
			fast = arr [fast];
		}
		return slow;
	}
}
