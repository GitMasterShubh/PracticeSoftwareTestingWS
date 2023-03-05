package com.shubhamklogic.practice.tricky.java.programs;

import java.util.Arrays;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeSorting_SortIntegers {

	public static void main(String[] args) {

		int[] arrInt1 = {10,-40,0,30,-5};
		// int[] arrInt1 = {-1,-1,+0,-2,-1};
		sortMethod1( arrInt1 );					// Method 1: Use Arrays.sort(arrInt)
		
		arrInt1 = new int[]{10,-40,0,30,-5};
		sortMethod2_SelectionSort(arrInt1);		// Method 2: Use Selection Sort algorithm
		
		arrInt1 = new int[]{10,-40,0,30,-5};
		sortMethod3_BubbleSort(arrInt1);		// Method 3: Use Bubble Sort algorithm
		
		arrInt1 = new int[]{10,-40,0,30,-5};
		sortMethod4_InsertionSort(arrInt1);		// Method 4: Use Insertion Sort algorithm
		
		arrInt1 = new int[]{10,-40,0,30,-5};
		sortMethod5_MergeSort(arrInt1);			// Method 5: Use Merge Sort algorithm
		
		arrInt1 = new int[]{10,-40,0,30,-5};
		sortMethod6_QuickSort(arrInt1);			// Method 6: Use Quick Sort algorithm
	}

	private static void sortMethod1(int[] arrInt) {
		
		SeleniumHelperUtil.log("\n\n***\nMethod1:: Before sorting :\n" + Arrays.toString( arrInt ));
		
		Arrays.sort(arrInt);
		
		SeleniumHelperUtil.log("\n\nMethod1:: After sorting  :\n" + Arrays.toString( arrInt ));
	}
	
	/**
	 * 
	 * @param arr
	 * Desc: Using Selection Sort Algorithm to sort an integer array-
	 * 
	 */
	
	private static void sortMethod2_SelectionSort( int[] arr) {

		SeleniumHelperUtil.log("\n\nMethod2:: Before Selection Sort: "+ Arrays.toString(arr) );
		
		int arrSize = arr.length;
		for( int i=0; i < arrSize-1; i++ ) {
			int iMin = i;					// assumed minimum val. index..
			
			for( int j=i+1; j < arrSize; j++ ) {
				
				if( arr[j] < arr[iMin] )	// check presence of any other array value, which is smaller than assumed minimum val.
					iMin = j;				// j found as new minimum
			}
			
			int tmp = arr[i];				// store the new minimum val. and swap with assumed minimum val.. 
			arr[i] = arr[iMin];
			arr[iMin] = tmp;
		}
		SeleniumHelperUtil.log("\n\nMethod2:: After Selection Sort : "+ Arrays.toString(arr) );
	}

	
	/**
	 * 
	 * @param arr
	 * Desc: Using Bubble Sort Algorithm to sort an integer array-
	 * 
	 */
	
	private static void sortMethod3_BubbleSort( int[] arr) {
		
		SeleniumHelperUtil.log("\n\n***\nMethod3:: Before Bubble sort:\n" + Arrays.toString( arr ));
		int arrSize = arr.length;
		
		for(int pass = 0; pass < arrSize-1; pass++) {
			
			for(int j = 0; j < arrSize-1-pass; j++) {
				
				if( arr[j] > arr[j+1] ) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		SeleniumHelperUtil.log("\n\n***\nMethod3:: After Bubble sort :\n" + Arrays.toString( arr ));
	}
	
	
	/**
	 * 
	 * @param arr
	 * Desc: Using Inserting Sort Algorithm to sort an Integer array-
	 * 
	 */
	
	private static void sortMethod4_InsertionSort( int[] arr) {
		
		SeleniumHelperUtil.log("\n\nMethod4:: Before Insertion Sort: "+ Arrays.toString(arr) );
		
		for( int i=1; i<arr.length; i++ ) {
			
			int hole = i;
			int value = arr[hole];
			
			while ( hole > 0 && arr[hole-1] > arr[hole]) {
				int tmp = arr[hole];
				arr[hole] = arr[hole-1];
				arr[hole-1] = tmp;
				
				hole = hole-1;
			}
			arr[hole] = value;
		}
		SeleniumHelperUtil.log("\n\nMethod4:: After Insertion Sort : "+ Arrays.toString(arr) );
	}


	/**
	 * 
	 * @param arrInt1
	 * Desc: Using Merge Sort Algorithm to sort an Integer array-
	 * MERGE_SORT is Not An In-place sorting algorithm
	 * 		Space Complexity => O(n)
	 * 		Time  Complexity => O(nLogn)
	 * 
	 */
	
	//					arrInt1 = new int[]{10,-40,0,30,-5};
	//					sortMethod5_MergeSort(arrInt1);			// Method 5: Use Merge Sort algorithm
	
	
	private static void sortMethod5_MergeSort(int[] arr) {
		
		SeleniumHelperUtil.log("\n\nMethod5:: Before Merge Sort: "+ Arrays.toString(arr) );
		
		mergeSort(arr);
		
		SeleniumHelperUtil.log("\n\nMethod5:: After Merge Sort: "+ Arrays.toString(arr) );
		
	}

	// part1 of : sortMethod5_MergeSort() :: mergeSort Logic
	private static void mergeSort(int[] arr) {
		
		int i = 0, j = 0, mid = arr.length/2;
		int leftArr[] = new int[ mid] ;
		int rightArr[] = new int[ arr.length - mid ] ;
		
		if( arr.length < 2)
			return;
		
		while ( i < leftArr.length ) {
			leftArr[i] = arr[i];
			i++;
		}
		while ( j < rightArr.length ){
			rightArr[j] = arr[j+mid];
			j++;
		}
		//		SeleniumHelperUtil.log("Left : "+Arrays.toString(leftArr));
		//		SeleniumHelperUtil.log("Right : "+Arrays.toString(rightArr));
		
		mergeSort(leftArr);
		mergeSort(rightArr);
		merge(leftArr, rightArr, arr);
		
	}

	// part2 of : sortMethod5_MergeSort() :: merge logic
	private static void merge(int[] leftArr, int[] rightArr, int[] arr) {
		
		int l=0, r=0, a=0;
		
		while ( l < leftArr.length && r < rightArr.length ) {
			
			if( leftArr[l] < rightArr[r] ) {
				arr[a] = leftArr[l];
				l++;
			} else {
				arr[a] = rightArr[r];
				r++;
			}
			a++;
		}
		while ( l < leftArr.length) {
			arr[a] = leftArr[l];
			l++;
			a++;
		}
		while ( r < rightArr.length) {
			arr[a] = rightArr[r];
			r++;
			a++;
		}
	}
	
	/**
	 * 
	 * @param arrInt1
	 * Desc: Using Quick Sort Algorithm to sort the array -
	 * Time complexity : O(nlogn) Average case running time.
	 * 				   : O(n^2) Worst case running time. But, in real time, its pretty fast and efficient.
	 * 				   : 	Using Randomized version of QuickSort, we avoid this worst case time comp. O(n^2)
	 * 
	 * Space complexity: In-place algo. Uses fix size of memory for N size of array. 
	 * 
	 */
	private static void sortMethod6_QuickSort(int[] arr) {
		
		SeleniumHelperUtil.log("\n\n***\nMethod6:: Before sorting:\n" + Arrays.toString( arr ));
		
		quickSort( arr, 0, arr.length-1 );						// Call and pass arr with Starting Index & Ending Index
		
		SeleniumHelperUtil.log("\n\n***\nMethod6:: After sorting :\n" + Arrays.toString( arr ));
		
	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		
		if( startIndex < startIndex )				// Base Condition : start < end ::
		{											// 	coz there may be some calls when  start OR end can have negative values	
			// Get Partition Index
			int partitionIndex = getPartitionIndex( arr, startIndex, startIndex );	
			quickSort( arr, startIndex, partitionIndex-1 );		// Call Again and pass   Prev Section from 	Partition Index
			quickSort( arr, partitionIndex+1 , startIndex );	// Call Again and pass   Next Section from 	Partition Index
		}
	}

	private static int getPartitionIndex(int[] arr, int startIndex, int endIndex) {
		
		int partiVal = arr[endIndex];				// Take the partition Value...the end Element
		int partiInd = startIndex;					// Take the partition Index...the start index
		
		for( int i=startIndex; i<=endIndex; i++)	// Loop through : start to end...
		{
			if( arr[i] < partiVal )					// check : if CurrVal < partiVal
			{
				int temp = arr[i];					// swap CurrVal ~ arr[partiInd]		
				arr[i] = arr[partiInd];				//		coz we want All Elements    lesser than the PivotVal must be   
				arr[partiInd] = temp;
				partiInd++;							//									earlier than PartiInd..
			}
		}
		int temp = arr[endIndex];					// swap LastValOfArr ~ PartiIndVal
		arr[endIndex] = arr[partiInd];	
		arr[partiInd] = temp;
		
		return partiInd;
	}
}
