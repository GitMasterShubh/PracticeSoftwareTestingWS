package com.shubhamklogic.practice.selenium;

public class DriverMain {
	
	public static void main(String[] args) {
		
		printVariableArgsPractice(10, 20.2, 30, "Shubh", 's');
	}
	
	public static void printVariableArgsPractice(Object... varArgs) {
		
		System.out.println("Total Number of args="+varArgs.length);
		
		for(int n = 0; n < varArgs.length; n++) {
			
			System.out.println("arg="+varArgs[n]);
			
		}
	}
}
