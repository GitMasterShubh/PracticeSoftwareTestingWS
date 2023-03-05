package com.shubhamklogic.practice.tricky.java.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

/**
 * 
 * @author ssrivastava
 * <br> Problem Name : Sort Colors
 * <br> Problem Link   : https://leetcode.com/problems/sort-colors/
 * <br> Video Solution : https://youtu.be/oaVa-9wmpns?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2 (YT: Take U Forward)
 * <br> Problem Desc : 
 * <br> Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <br> We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <br> You must solve this problem without using the library's sort function.
 * <br> Example 1:
 * <br> Input: nums = [2,0,2,1,1,0]
 * <br> Output: [0,0,1,1,2,2]
 * <br> Example 2:
 * <br> Input: nums = [2,0,1]
 * <br> Output: [0,1,2]
 * <br> KD: LeetCode_Medium_Level, Algorithm - Dutch National Flag Algorithm
 */

public class PracticeCalc7_Medium_SortArr012WithoutSortMethod {
	
	public static void main(String[] args) {
		
		int []arr = { 2,2,2,0,1 };
//		int []arr = { 2,1,0,1,0 };
//		int []arr = { 1,1,1,2,0 };
		
//		SeleniumHelperUtil.log("\nArrary1 : "+ java.util.Arrays.toString(arr));
//		SeleniumHelperUtil.log( "Sorted  : " + sorting1a_WithSortMethod( arr ));		// Arrays.sort(arr)

//		SeleniumHelperUtil.log("\nArrary2 : "+ java.util.Arrays.toString(arr));
//		SeleniumHelperUtil.log( "Sorted  : " + sorting1b_WithoutSortMethod( arr ));		// FAILING: Giving wrong output :: Using TreeMap (Impl. of SortedMap)

		SeleniumHelperUtil.log("\nArrary3 : "+ java.util.Arrays.toString(arr));
		SeleniumHelperUtil.log( "Sorted  : " + goodWay_SortingWithoutSortMethod( arr ));
	}

	private static String goodWay_SortingWithoutSortMethod(int[] arr) {
		
		int low = 0, mid = 0, high = arr.length-1, tmp;
		
		while ( mid <= high ) {
			
			switch( arr[mid] ) {
				case 0:						// When mid gets value = 0, swap and incre. : low & mid
					tmp = arr[mid];
					arr[mid] = arr[low];
					arr[low] = tmp;
					
					low++; mid++;
					break;
		
				case 1:						// When mid gets value = 1, incre. mid
					mid++;
					break;
		
				case 2:						// When mid gets value = 2, swap mid & high, & decre. high
					tmp = arr[mid];
					arr[mid] = arr[high];
					arr[high] = tmp;
	
					high--;
					break;
			}			
		}
		return Arrays.toString(arr);
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private static String sorting1b_WithoutSortMethod(int[] arr) {
		
		TreeMap tMap = new TreeMap( );
		for (int i = 0; i < arr.length; i++) {
			int k =1; Object oldVal = null;
			
			oldVal = tMap.put(arr[i], k);
			if( oldVal != null )
				tMap.put(arr[i], (Integer)oldVal + k );
		}
		
		Collection val = tMap.values();
//		SeleniumHelperUtil.log(" tMap.values=" + val.toString());
		Iterator itr = val.iterator();
		
		for (int i = 0; i < 2; i++) {
			itr.hasNext();
			int k = Integer.parseInt( itr.next().toString() );
			
			for (int j = 0; j < k; j++) {
				arr[ i+j ] =  i;
			}
		}
		return Arrays.toString( arr );
	}

	private static String sorting1a_WithSortMethod(int[] arr) {
		Arrays.sort( arr );
		return Arrays.toString(arr);
	}
}
