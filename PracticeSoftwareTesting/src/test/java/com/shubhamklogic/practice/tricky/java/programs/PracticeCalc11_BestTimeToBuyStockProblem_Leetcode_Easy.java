package com.shubhamklogic.practice.tricky.java.programs;

import java.util.Arrays;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeCalc11_BestTimeToBuyStockProblem_Leetcode_Easy {
	public static void main(String[] args) {

		int[] dailyPrices = { 7, 1, 5, 3, 6, 4 };
		SeleniumHelperUtil.log("Prices List : "+ Arrays.toString( dailyPrices ));
		
		SeleniumHelperUtil.log("Max Profit="+ getMaxProfit( dailyPrices ));
		
	}

	private static int getMaxProfit(int[] dailyPrices) {
		int minPriceSoFar = dailyPrices[0], maxProfit = 0;
		
		for (int i = 0; i < dailyPrices.length; i++) {
			
			if(minPriceSoFar > dailyPrices[i])
				minPriceSoFar = dailyPrices[i];						 // Buy the stock on ith day
			
			else if ( maxProfit < dailyPrices[i] - minPriceSoFar )	 // Checking max profit
				maxProfit = dailyPrices[i] - minPriceSoFar;
		}
		return maxProfit;
	}
}