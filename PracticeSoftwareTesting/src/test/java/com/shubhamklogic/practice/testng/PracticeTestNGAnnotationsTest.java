package com.shubhamklogic.practice.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author ShubhamSrivastava
 * 
 * Below Test cases will help you to understand, which TestNG Annotation will execute first and which ones later.
 *
 */

public class PracticeTestNGAnnotationsTest {
	
	@BeforeSuite
	public void preSetup(){
		System.out.println("--->>> 1 : preSetup :: 		@BeforeSuite");
	}
	
	@BeforeClass
	public void setup(){
		System.out.println("--->>> 2 : setup :: 		@BeforeClass");
	}
	
	
	@BeforeTest
	public void login(){
		System.out.println("--->>> 3 : login :: 		@BeforeTest");
	}
	
	
	@BeforeGroups
	public void createDummyData(){
		System.out.println("--->>> 4 : createDummyData :: @BeforeGroups");
	}
	
	
	@BeforeMethod
	public void verifyIsLoggedIn(){
		System.out.println("--->>> 5 : verifyIsLoggedIn :: 	@BeforeMethod");
	}
	
	
	@Test (groups = {"current"})
	public void testSettings(){
		System.out.println("--->>> 6a : testSettings :: 	@Test");
	}
	
	
	@Test (groups = {"current"} )
	public void testProfilePic(){
		System.out.println("--->>> 6b : testProfilePic :: 	@Test");
	}
	
	
	@AfterMethod
	public void verifyLoggedOut(){
		System.out.println("--->>> 7 : verifyLoggedOut :: 	@AfterMethod");
	}
	
	
	@AfterGroups
	public void deleteDummyData(){
		System.out.println("--->>> 8 : deleteDummyData :: @AfterGroups");
	}
	
	
	@AfterTest
	public void logout(){
		System.out.println("--->>> 9 : logout :: 		@AfterTest");
	}

	
	@AfterClass
	public void sendEmail(){
		System.out.println("--->>> 10 : sendEmail :: 	@AfterClass");
	}
	
	
	@AfterSuite
	public void quitDriver(){
		System.out.println("--->>> 11 : quitDriver :: 	@AfterSuite");
	}
	
}