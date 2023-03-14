package com.shubhamklogic.practice.tricky.java.programs;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeArray4_SetMatrixZeroes_Leetcode_Medium {
	
	/**
	 * @author ssrivastava
	 * Problem Name: Set Matrix Zeroes
	 * Problem Desc: Given an m x n integer matrix matrix, if an element is 0, 
	 * set its entire row and column to 0's. You must do it in place.
	 *   Input:  <br>
	 *   [[0,1,2,0], <br>
	 *    [3,4,5,2], <br>
	 *    [1,3,1,5]] <br>
	 *   Output:  <br>
	 *   [[0,0,0,0], <br>
	 *    [0,4,5,0], <br>
	 *    [0,3,1,0]] <br>
	 * 
	 * Solution Video Link: https://youtu.be/DHJsjnnRCNg 	OR		https://youtu.be/M65xBewcqcI   
	 * Solution Code Link : 
	 */
	
	public static void main(String[] args) {
		int [][] matrix = new int[][] {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
		};
		// Above's Output:
		/* {{0,0,0,0},
		 *  {0,4,5,0},
		 *  {0,3,1,0}}
		 */
		
		SeleniumHelperUtil.log(matrix, "Before setting matrix with Zeros :");
		setMatrixWithZeros( matrix );
		SeleniumHelperUtil.log(matrix, "After setting matrix with Zeros :");
		
	}

	private static void setMatrixWithZeros(int[][] matrix) {
		
		int rows = matrix.length;		// Check rows and cols in matrix
		int cols = matrix[0].length;
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		// Check first row has zeros? if there = Save info.
		for ( int i : matrix[0]) {
			if( i == 0 ) {
				firstRowHasZero = true;
				break;
		}	}
		
		
		// Check first col has zeros? if there = Save info.
		for( int i=0;  i<= cols; i++ ) {
			if( matrix[i][0] == 0 ) {
				firstColHasZero = true;
				break;
		}	}
		

		// Set Red Flags..
		// Then I should always read throughout the rest of the Matrix excluding 
		// the first row and the First Column and we check for zeros 
		for ( int currR = 1; currR < rows; currR++ ) {
			for (int currC = 1; currC < cols; currC++) {
				
				// if you found that there're zeros  
				if (matrix[currR][currC] == 0) {
					
					// we modify the first row and column and set them as flags
					// as we know where there are zeros in The Matrix
					matrix[0][currC] = 0;
					matrix[currR][0] = 0;
		}	}	}
			
		// then we'll Loop over the rest of the  Matrix again and for every element and 
		// based on the red flags that we have made here we check 
		for ( int currR = 1; currR < rows; currR++ ) {
			for (int currC = 1; currC < cols; currC++) {
				
				// if the  elements in the same row of the First Column OR   
				// the element in the same column of the First Row is zero 
				// and we set all the element to be zero
				if ( matrix[currR][0] == 0 || matrix[0][currC] == 0 )
					matrix[currR][currC] = 0;
		}	}
		
		
		// then finally we use the information that  
		// we have stored at the beginning of the  code means if the first row or the First
		// Column has zero we set all the row and  column to be zero  
		// finally return The Matrix 
		
		if( firstRowHasZero ) {
			for ( int c=0; c < cols; c++ ) {
				matrix[0][c] = 0;
		}	}
		
		
		if( firstColHasZero ) {
			for ( int r=0; r < rows; r++ ) {
				matrix[r][0] = 0;
}	}	}	}
