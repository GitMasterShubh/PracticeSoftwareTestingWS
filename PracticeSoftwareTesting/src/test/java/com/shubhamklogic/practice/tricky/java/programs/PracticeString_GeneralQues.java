package com.shubhamklogic.practice.tricky.java.programs;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* Problem :  (In this class, multiple interview level questions have been covered).
   Solution:
*/


interface SomeInterface 
{
	int age = 0;				// Declared variable : public, static, final
	void someFunction();		// Declared methods  : public, abstract
	
	default void logGM() 		// Defined 'Default Methods' in Interface
	{							//   These methods are implicitly 'default'
		System.out.println("Good morning !!");
	}
	
	static void logTimeStamp()
	{
		System.out.println("Timestamp : "+ LocalDateTime.now());
	}
}

class SomeClass implements SomeInterface
{
	@Override
	public void someFunction()	// Overridden the interface methods 
	{
		// Some code..
		logGM();				// Calling a 'Default Method' of Interface
		
		SomeInterface.logTimeStamp();	// Calling Static Method of Interface
	}
}


interface WhiteCarInterface
{
	default void logCarDetails()
	{	System.out.println("White car looks awesome..");	}
}

interface BlackCarInterface
{
	default void logCarDetails()
	{	System.out.println("Black car looks cool..");	}
}

class SomeCarCompany implements WhiteCarInterface, BlackCarInterface
{

	@Override
	public void logCarDetails() 
	{
		BlackCarInterface.super.logCarDetails();
		
		// OR Both can be used in the overridden method..
		
		WhiteCarInterface.super.logCarDetails();
	}	 
}





public class PracticeString_GeneralQues {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static public void main(String[] args) {
		
		handlingHashMap();
		
		Character ch = ' ';
		
		
		
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void handlingTreeMap() {
		
		TreeMap tMap = new TreeMap();
		Iterator itr = null;
		
		tMap.put("1", "one");
		tMap.put("2", null);
		System.out.println(tMap);
		
		// Use of put() method:
		tMap.put("E101", "Shubham"); 
		tMap.put("E102", "Aaditya");
		tMap.put("E103", "Ravi");
		
		// Value "Ravi" will be replaced by new value "Kriti"
		String oldVal = tMap.put("E103", "Kriti").toString();		
		tMap.put("E105", "aakriti");
		
		System.out.println(oldVal);		// Output: Ravi
		System.out.println("\n\ntMap======>"+tMap);		
		// Output: tMap======>{E101=Shubham, E102=Aaditya, E103=Kriti, E105=aakriti}
		
		
		// Get All Keys - keySet()
		Set keys = tMap.keySet();
		itr = keys.iterator();
		System.out.print("\n\nGet All Keys itr.next()s======>");
		while(itr.hasNext()) 
			System.out.print(itr.next().toString()+", ");
		//	Output : Get All Keys itr.next()s======>E101, E102, E103, E105,
		
		
		// Get All Values - values() 
		//	[Values can be duplicate, so, it returns 'Collection' ]
		Collection c = tMap.values();
		itr = c.iterator();
		System.out.print("\n\nGet All Values itr.next()s======>");
		while( itr.hasNext() )
			System.out.print(itr.next().toString()+", ");
		// Output : Get All Values itr.next()s======>Shubham, Aaditya, Kriti, aakriti
		
		
		// Get All Entries (Key+Values)
		Set eSet = tMap.entrySet();
		itr = eSet.iterator();
		System.out.print("\n\nGet All Entries\nitr.next()s======>");
		while( itr.hasNext()) 
			System.out.print(itr.next()+",");
			//	Output : Get All Entries 
			//			 itr.next()s======>E101=Shubham,E102=Aaditya,E103=Kriti,E105=aakriti
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void handlingLinkedHashMap() {
		
		LinkedHashMap hMap = new LinkedHashMap();
		Iterator itr = null;
		
		// Use of put() method:
		hMap.put("E101", "Shubham"); 
		hMap.put("E102", "Aaditya");
		hMap.put("E103", "Ravi");
		
		// Value "Ravi" will be replaced by new value "Kriti"
		String oldVal = hMap.put("E103", "Kriti").toString();		
		hMap.put("E105", "aakriti");
		
		System.out.println(oldVal);		// Output: Ravi
		System.out.println("\n\nhMap======>"+hMap);		
		// Output: hMap======>{E101=Shubham, E102=Aaditya, E103=Kriti, E105=aakriti}
		
		
		// Get All Keys - keySet()
		Set keys = hMap.keySet();
		itr = keys.iterator();
		System.out.print("\n\nGet All Keys itr.next()s======>");
		while(itr.hasNext()) 
			System.out.print(itr.next().toString()+", ");
		//	Output : Get All Keys itr.next()s======>E101, E102, E103, E105,
		
		
		// Get All Values - values() 
		//	[Values can be duplicate, so, it returns 'Collection' ]
		Collection c = hMap.values();
		itr = c.iterator();
		System.out.print("\n\nGet All Values itr.next()s======>");
		while( itr.hasNext() )
			System.out.print(itr.next().toString()+", ");
		// Output : Get All Values itr.next()s======>Shubham, Aaditya, Kriti, aakriti
		
		
		// Get All Entries (Key+Values)
		Set eSet = hMap.entrySet();
		itr = eSet.iterator();
		System.out.print("\n\nGet All Entries\nitr.next()s======>");
		while( itr.hasNext()) 
			System.out.print(itr.next()+",");
			//	Output : Get All Entries 
			//			 itr.next()s======>E101=Shubham,E102=Aaditya,E103=Kriti,E105=aakriti
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void checkingHashMapVsHashtable() {
		
		HashMap hMap = new HashMap();
		Hashtable hTbl = new Hashtable();
		
		hMap.put("One", "Eleven");
		hMap.put(null, null);
		hMap.put("Two", "Twelve");
		hMap.put(null, null);
		System.out.println("hMap= "+hMap);
		
		// Output : hMap= {null=null, One=Eleven, Two=Twelve}
		
		
		hTbl.put("One", "Eleven");
		hTbl.put(null, null);			// Throws: Exception
		hTbl.put("Two", "Twelve");
		System.out.println(hTbl);
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void handlingHashMap() {
		
		HashMap hMap = new HashMap();
		Iterator itr = null;
		
		
		hMap.put("E101", "Shubham");
		hMap.put(102, "Aaditya");
		hMap.put("E103", "Ravi");
		
		// Use of put() method:
		hMap.put("E101", "Shubham");
		hMap.put("E102", "Aaditya");
		hMap.put("E103", "Ravi");
		
		// Value "Ravi" will be replaced by new value "Kriti"
		String oldVal = hMap.put("E103", "Kriti").toString();		
		hMap.put("E105", "aakriti");
		
		System.out.println(oldVal);		// Output: Ravi
		System.out.println(hMap);		
		// Output: {E105=aakriti, E101=Shubham, E102=Aaditya, E103=Kriti}
		
		
		// Get All Keys - keySet()
		Set keys = hMap.keySet();
		itr = keys.iterator();
		while(itr.hasNext()) {		   // Output : E105, E101, E102, E103
			System.out.print(itr.next().toString()+", ");
		}
		
		
		// Get All Values - values() 
		//	[Values can be duplicate, so, it returns 'Collection' ]
		Collection c = hMap.values();
		itr = c.iterator();
		while( itr.hasNext() ){ // Output: aakriti, Shubham,Aaditya, Kriti
			System.out.print(itr.next().toString()+", ");
		}
		
		
		// Get All Entries (Key+Values)
		Set eSet = hMap.entrySet();
		itr = eSet.iterator();
		while( itr.hasNext()) {
			System.out.print(itr.next()+",");
			//	Output : E105=aakriti,E101=Shubham,E102=Aaditya,E103=Kriti
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void StrAndStrBfrInsertionInTreeSet() {

		TreeSet s1 = new TreeSet();
		s1.add(new String("A"));   s1.add(new String("D"));
		s1.add(new String("Z"));   s1.add(new String("C"));
		System.out.println(s1);	 	// Prints : A D Z C
		
		TreeSet s2 = new TreeSet();
		s2.add(new StringBuffer("A"));  s2.add(new StringBuffer("D"));
		s2.add(new StringBuffer("Z"));  s2.add(new StringBuffer("C"));
		System.out.println(s2);		// Exception.. 
		
		/* Above sysout(s2) gives ClassCastException,
		   Because: 
		   	1) We created TreeSet with default constructor 
		   	   This constructor sorts on the basis of 
		   	   "Default Natural Sorting Order"
		   	   which works with Homogeneous + Comparable types of Objects.
		   	   
		   	2) And, String implements Comparable.
		   	   But, StringBuffer does NOT implements Comparable !!
		   	   
		   	   So, StringBuffer Object's insertion failed with Exception.
		*/
	
		
	}

	public void NullInsertionInTreeSet() {
		TreeSet<String> s = new TreeSet<String>();
		s.add(null);
		
		System.out.println(s);		// java.lang.NullPointerException
	}
	
}
