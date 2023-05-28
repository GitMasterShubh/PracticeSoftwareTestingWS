package com.shubhamklogic.practice.selenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.GsonBuilder;

import au.com.bytecode.opencsv.CSVReader;


/**
 * 
 * @author ssrivastava
 * Desc: This TestClass will read data from CSV Files-
 * Video: https://youtu.be/rHkWFqBqjpw
 * 
 */
public class FetchTestDataFromCSVTest {

	public static void main(String[] args) throws Exception{
		
		String fullFilePath = "/Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/test/resources/dummyFile.csv";
		
		// readAllRowsInCSVWithoutAnyPlugin_Way1( fullFilePath );			// Using Scanner + File classes
		// readFirstNRowsInCSVWithoutAnyPlugin_Way1( fullFilePath , 2);		// Using Scanner + File classes
		// List<String> firstNamesList = 
		//			getOnlyFirstNamesAsListFromCSV_Way1( fullFilePath );	// Using Scanner + File classes
		
		
		
		// readAllRowsInCSVWithoutAnyPlugin_Way2( fullFilePath );			// Using BufferedReader + FileReader
		
		
		// readAllRowsUsingOpenCSVPlugin_Way3( fullFilePath );				// Using plugin-OpenCSV's CSVReader + FileReader
		
		String json =								// Using plugins- 1) OpenCSV (Fetch), 2) Gson (Converting to JSON) 
				readAllRowsUsingOpenCSV_ConvertPojoToJsonUsingGson_Way3( fullFilePath );
	}

	private static void readAllRowsUsingOpenCSVPlugin_Way3(String fullFilePath) throws Exception{
		// Bytecode company's Open CSV dependency is added in POM.xml file
		
		au.com.bytecode.opencsv.CSVReader csvData = 						// Creating OpenCSV's CSVReader + FileReader
			new au.com.bytecode.opencsv.CSVReader(new FileReader(fullFilePath));
		
		System.out.println("CSV Data Rows :-");
		String []lineData = null;											// Creating String[] array for Row data
		
		while ( (lineData = csvData.readNext()) != null)					// Getting each Row values in array :: readNext() 
			System.out.println( "-->" + Arrays.toString(lineData) );
	}
	
	
	
	private static String readAllRowsUsingOpenCSV_ConvertPojoToJsonUsingGson_Way3(String fullFilePath) throws Exception {
		
		au.com.bytecode.opencsv.CSVReader csvReader 
			= new CSVReader( new FileReader(fullFilePath), ',' , '\'' , 1 ); 	
						// Args : reader, separatorChar, quoteChar, skipFirstNLines 
		
		List<Person> listPeople = new ArrayList();
		
		
		// Task 1: Read All Rows Using OpenCSV -
		
		String []lineData = null;
		while ( (lineData = csvReader.readNext() ) != null) {
			System.out.println("Row Data-->"+ Arrays.toString(lineData));
		
		
			// Task 2: Converting full fetched data --> to PoJo List --> to JSON String
			Person peoplePoJo = new Person( lineData[0], lineData[1]);				// PoJo Created
			
			listPeople.add(peoplePoJo);
			
		}
		// After Loop, Converting saved list of People to Json-
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(listPeople);
		System.out.print("Json Data from CSV :-\n" + json);
		
		return json;
	}
	
	
	
	
/*
		class Person{														// PoJo class to save CSV Data - 
			
			private String firstName;
			private String fathersName;
			
			public Person(String firstName, String fathersName) {
				super();
				this.firstName = firstName;
				this.fathersName = fathersName;
			}
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getFathersName() {
				return fathersName;
			}
			public void setFathersName(String fathersName) {
				this.fathersName = fathersName;
			}
		}
	*/
	
	
	
	private static void readAllRowsInCSVWithoutAnyPlugin_Way2(String fullFilePath) throws Exception{
		
		BufferedReader bRdr =												// BufferedReader + FileReader 
			new BufferedReader( new FileReader( fullFilePath ) );
		
		String line = bRdr.readLine();										// .readLine(), to Ignore headings
		
		System.out.println("CSV Data :- ");
		while ( (line = bRdr.readLine()) != null ) 							// Checks last line (& empty string)
			System.out.println("-->" + line);
		
	}

	
	
	public static void readAllRowsInCSVWithoutAnyPlugin_Way1(String fullFilePath) throws Exception {
		
		// 1. Create Scanner obj by providing File(path)
		// 2. Use scannerObj.hasNext() and scannerObj.next().toString() methods  
		
		java.util.Scanner sc = new Scanner( new File( fullFilePath ));		// Scanner + File
		
		if( sc.hasNext() ) {												// Use :: hasNext() + nextLine()
			sc.nextLine();													// To Ignore the First Line having headings
			while (sc.hasNext()) 
				System.out.println("CSV File Data >>>"+ sc.nextLine());
		}		
	}
	
	
	
	private static void readFirstNRowsInCSVWithoutAnyPlugin_Way1(String fullFilePath, int firstNRowsOnly) throws Exception {
		
		Scanner scanner = new Scanner ( new File(fullFilePath) );		// Fetch CSV file using Scanner + FileReader
		
		boolean isSkipHeading = true;
		if ( isSkipHeading && scanner.hasNext()) 						// .hasNext() +  .nextLine()
			scanner.nextLine();

		System.out.println("\n\nCSV File Data First "+firstNRowsOnly+" Rows :-");
		
		while ( scanner.hasNext() && firstNRowsOnly-- > 0 ) 
			System.out.println("-->>"+scanner.nextLine() );
	}

	private static List<String> getOnlyFirstNamesAsListFromCSV_Way1(String fullFilePath) throws Exception {
		
		List<String> firstNamesList = new ArrayList();
		
		Scanner sc = new Scanner( new File( fullFilePath ) );			// Fetch CSV file using Scanner + FileReader
		
		if(sc.hasNext())
			sc.nextLine();		// Ignore the Headings-
		
		System.out.println("All First names in CSV :-");				// .hasNext() +  .nextLine()
		while(sc.hasNext()) {
			String fName = sc.nextLine().toString().split(",")[0];
			firstNamesList.add( fName );
			
			System.out.println("-->> " + fName);
		}
		
		return firstNamesList;
	}
}


class Person{		// PoJo class to save CSV Data - 
	
	private String firstName;
	private String fathersName;
	
	public Person(String firstName, String fathersName) {
		super();
		this.firstName = firstName;
		this.fathersName = fathersName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
}




