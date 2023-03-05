package com.shubhamklogic.practice.tricky.java.programs;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

/**
 * @author ssrivastava <br>
 *         Problem Name : Find Maximun Subarray Sum using For loops, OR Kadane Algo <br>
 *         Problem Link : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ <br>
 *         Video Solution : https://youtu.be/w_KEocd__20?list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2 (YT : Take u Forward<br>
 *         Many solutions : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ <br>
 *         Description : Given an array arr[], the task is to find the elements of a contiguous subarray of numbers that has the largest sum. <br>
 *         Examples: <br>
 *             Input: arr = [-2, -3, 4, -1, -2, 1, 5, -3]  <br>
 *             Output: [4, -1, -2, 1, 5] <br>
 *             Explanation:  <br>
 *             In the above input the maximum contiguous subarray sum is 7 and the elements of the subarray are [4, -1, -2, 1, 5] <br>
 *             Input: arr = [-2, -5, 6, -2, -3, 1, 5, -6]  <br>
 *             Output: [6, -2, -3, 1, 5]  <br>
 *             Explanation:  <br>
 *             In the above input the maximum contiguous subarray sum is 7 and the elements  <br>
 *             of the subarray are [6, -2, -3, 1, 5] <br>
 *         	   
 *         KD: LeetCode_Medium_Level
 */

public class PracticeCalc9_Medium_FindMaximunSubarraySum_KadaneAlgo {

	public static void main(String[] args) {

		// int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3 };		/* Max sum = 7 */
		// int[] arr1 = { -2, -5, 6, -2, -3, 1, 5, -6 };	/* Max sum = 7 */
		// int[] arr1 = { -2, -5, -1, -3 };					/* Max sum = -1 */
		int[] arr1 = { 4,4,4,4,-3 };						/* Max sum = 16 */

		SeleniumHelperUtil.log("Arrary1 : " + java.util.Arrays.toString(arr1));
		SeleniumHelperUtil.log("Max.Sum :" + way3_findMaxSubarrayWithSum(arr1));
	}

	public static int way3_findMaxSubarrayWithSum(int[] nums)	// Good and Complete : Gives SubArray with Sum of SubArray
    {
		// T.C.=> O(n)
		// S.C.=> O(1)
		
		// Given arr1 = {-2, -3, 4, -1, -2, 1, 5, -3 };		/* Max sum = 7 [4, -1, -2, 1, 5] */
		// Given arr2 = { -2, -5, 6, -2, -3, 1, 5, -6 };	/* Max sum = 7 [ 6, -2, -3, 1, 5]*/

		
        int currMax = nums[0], globalMax = nums[0];		// Initialize currMax and globalMax with first value of nums
        int endIndex = 0, startIndex = 0, 				// Initialize endIndex, startIndex, globalStartIndex
        	globalMaxStartIndex = 0;
        
        for (int i = 1; i < nums.length; ++i) {			// Iterate for all the elements of the array
 
            if ( nums[i] + currMax < nums[i] )			// If, Sum of currNum and currMax is giving even less than currNum,  
            {											//		then there is no need of carry forwarding Sum. Start subArr from here.
                currMax = nums[i];						// Set currMax with currNum
                startIndex = i; 						// Start index will be from current pass.
            }
            else if (nums[i] + currMax > nums[i]) 		// Else If, Sum of currNum and currMax is giving more than currNum, 
            {		 									// then update currMax to carry forward.
                currMax = nums[i] + currMax;
            }
 
            if (currMax > globalMax) {					// In the end of each pass, If currMax becomes greater than the globalMax. 																								
                globalMax = currMax;					// Then, Update globalMax and globalMaxStartIndex 
                globalMaxStartIndex = startIndex;		// Save the Global max subArr as curr startIndex
                endIndex = i;							// Save the Global max End index as curr pass.
            }
        }
 
        System.out.print("SubArray : ");					// Printing the elements of subarray with max sum
        for (int i = globalMaxStartIndex; i <= endIndex; ++i) 
            System.out.print(nums[i] + " ");
        
        System.out.print("\n");								// Returning Max. SubArray Sum
        return globalMax;
    }
	
	public static int way2_findMaximunSubarraySum(int[] nums) {
		// YT Commented Solution : For all neg. val. in Array
		// T.C.=> O(n)
		// S.C.=> O(1)
		
		int n = nums.length;
		int maxi = nums[0], sum = nums[0];
		
		for (int i = 1; i < n; i++) {
			if (sum < 0)
				sum = nums[i];
			else
				sum += nums[i];
			maxi = max(sum, maxi);
		}
		return maxi;
	}

	public static int way1_findMaximunSubarraySum(int[] nums) {// Good : Gives Sum of SubArray
		// YT Solution : Raj ones - Kadane Algo
		// T.C.=> O(n)
		// S.C.=> O(1)
		
		int sum = 0;
		int maxi = nums[0];
		
		
		for ( int i = 0; i < nums.length; i++ )
		{
			sum += nums[i];
			
			if( sum > maxi ) {
				maxi = sum;
			}
			
			if( sum < 0 ) {
				sum = 0;
			}
		}
		// SeleniumHelperUtil.log("For SubArray = " + list);
		return maxi;
	}
	
	public static int way0_findMaximunSubarraySum(int[] nums) {// Okok: Gives Sum of SubArray
		
		// TC -> O(n^3)
		// SC -> O(1)
		//		int sum=0, globalMax = 0;
		//		for ( int i = 0; i < nums.length; i++ ) {
		//			
		//			for (int j = i; j < nums.length; j++) {		// i to j is my Sub-Array
		//				
		//				for ( int k = i; k <= j; k++)
		//				{
		//					sum += nums[k];
		//				}
		//				globalMax = Integer.max( sum, globalMax);
		//			}
		//		}
		
		return 0;
	}
	
	public static int max( int a , int b) {
		if ( a > b)
			return a;
		else 
			return b;
	}
}
