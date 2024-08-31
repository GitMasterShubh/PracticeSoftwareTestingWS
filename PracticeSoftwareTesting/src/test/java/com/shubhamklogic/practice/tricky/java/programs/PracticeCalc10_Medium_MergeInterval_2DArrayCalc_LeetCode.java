package com.shubhamklogic.practice.tricky.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

/**
 * @author ssrivastava <br>
 *          Problem Name : Merge Intervals - Merge Pairs<br>
 *          Problem Link : https://leetcode.com/problems/merge-intervals/ <br>
 *          Video Solution : https://youtu.be/2JzRBPFYbKE?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2 (YT : Take u Forward)<br>
 *          Other solutions :  <br>
 *          Description:  <br>
 *          Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, <br> 
 *          and return an array of the non-overlapping intervals that cover all the intervals in the input. <br>
 *          Example 1: <br>
 *          Input: intervals = [[1,3],[2,6],[8,10],[15,18]] <br>
 *          Output: [[1,6],[8,10],[15,18]] <br>
 *          Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]. <br>
 *          Example 2: <br>
 *          Input: intervals = [[1,4],[4,5]] <br>
 *          Output: [[1,5]] <br>
 *          Explanation: Intervals [1,4] and [4,5] are considered overlapping. <br>
 *          KD: LeetCode_Medium_Level
 */

public class PracticeCalc10_Medium_MergeInterval_2DArrayCalc_LeetCode {

	public static void main(String[] args) {

		int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
		sortIntervals(intervals);																// Sort given intervals Or pairs
		SeleniumHelperUtil.log( "Before Merge : Pairs: " + Arrays.deepToString(intervals) );
		intervals = way1_MergeInterval_GivenUnSorted2dArr( intervals );							// Merge the pairs
		SeleniumHelperUtil.log( "After Merge  : Pairs: " + Arrays.deepToString(intervals) );
	}

	public static int[][] way1_MergeInterval_GivenUnSorted2dArr(int[][] intervals) {
		// T.C.=> O(nLogn) + O(n)	=> Sorting time + Traversing
		// S.C.=> O(n) in Worst case
		
		List res = new ArrayList<Integer>();				// Create a List to store result.
		
		if( intervals == null || intervals.length == 0 )	// Return if given intervals size == 0
			return (int[][]) res.toArray( new int[0][]);
			
		intervals = sortIntervals( intervals );		// Sort the intervals based on lower points.

													// Store the 1st pair to compare further pairs..
		int start = intervals[0][0];				// Save the start point of 1st pair
		int end = intervals[0][1];					// Save the end point of 1st pair
		
		
		for( int i[] : intervals ) {				// Linearly iterate in the sorted pairs
			// Merge logic : For eg. [1,3] & [2,4]	// TimeStamp in Lecture : https://youtu.be/2JzRBPFYbKE?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&t=265
			// Here, [1,3] will already be availabe as variables = start, end
			
			// To Check if both pairs are Mergeable or Not? -
			// > Check if '3' >= '2' 				// In code, 3 is 'end', while 2 is 'i[0]' in if block for 2nd pass-
			// > Then pairs are Mergable..
			// >> To merge left points, Keep the 1st pair's left point AS IT IS : [1, ] 	
			// >>> No code change required for it, as 'start' will already containing that
			
			// > Now, To merge right points, compare the 1st pair's RIGHT point with 2nd pair's RIGHT point, 
			// >> and take the MAX of RIGHT points 3 ? 4 = 4	
			// So, Merged pair = [1,4] 
			
			// Else, If these pairs are Not Mergable : For eg. some calculated pair [1,6] with unCalc. new pair [8,9]
			// Then, Save the pair as [start, end] in your List as a result - of So far merged pairs result
			// Then, update 'start' and 'end' with the unmergeable second pair values.
			
			if( end >= i[0]) {							// Pairs are Mergable : [start,end] with (i[0],i[1])
				// start : Leave the 'start' 			// as it is containing the 1st pairs starting limit.
				end = java.lang.Math.max(end, i[1]);	// Update 'end' limit of merged pair  
			}											// And try to merge this pair (start,end) with next pair..
			
			else {										// Pairs are NOT Mergeable..
				res.add( new int[] {start, end});		// Then, Save the calculated pair
				start = i[0];							// Create fresh pair [start,end] to compare it with further pairs 
				end = i[1];
			}
		}
		// Once you traverse the all pairs, add the last calculated pairs in result list of pairs
		res.add( new int[] {start, end});
		return (int[][]) res.toArray(new int[0][]);		// Return the list as a 2-d Array, as we already provided bland 2-d Array.. 
	}

	public static int[][] sortIntervals(int [][] intervals) {
		// Sample Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
		java.util.Arrays.sort( intervals, new Comparator<int []>() {
			public int compare( int []interval1, int[] interval2) {
				return Integer.compare(interval1[0], interval2[0] );
//				OR return new Integer( interval1[0] ).compareTo( new Integer(interval2[0]) );
			}
		});
		return intervals;
	}
}
