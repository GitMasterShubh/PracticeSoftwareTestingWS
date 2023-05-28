package com.shubhamklogic.practice.tricky.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Problem :  Print your name from Mixed String.
   Solution:
   		 
*/

public class PracticeString_FindNameInMixedString {

	public static void main(String[] args) {
		
		String name = "SH%&^U^&&BH^&AM";
		System.out.println("Before: Name=>"+name);
//		printMyNameFromMixedString(name);
		printMyNameFromMixedString_v2(name);
	
	}
	
	// Method : 
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	private static void printMyNameFromMixedString(String s) {
		
		ArrayList nameList = new ArrayList( s.length() );
		char []arrName = s.toCharArray();

		for(char c : arrName)
			nameList.add( c + "" );		//	Converted char to String ..
		
		// remove() Returns true, if this list contained the specified element..
		while ( nameList.remove("%")) { }
		
		while ( nameList.remove("&") ) { }
		
		while ( nameList.remove("^") ) { }
		
		System.out.print("After : Name=>");
		for(Object c : nameList) {
			System.out.print(""+c);
		}
	}
	
	// Method : 2 
	private static void printMyNameFromMixedString_v2(String s) {
		
		ArrayList<Character> nameList = new ArrayList<Character>( s.length() );

		for( int i=0; i<s.length(); i++ )
			nameList.add( s.charAt(i) );	//	Converted char to Character Object
		
		// remove() Returns true, if this list contained the specified element..
		while ( nameList.remove( Character.valueOf( '%' )) ) { }
		
		while ( nameList.remove( Character.valueOf('&') )) { }
		
		while ( nameList.remove( Character.valueOf('^')) ) { }
		
		System.out.print("After : Name=>");
			for(Object c : nameList) {
				System.out.print(c);
		}
	}
}
