package com.shubhamklogic.practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shubhamklogic.practice.testng.LoginDataProvider;


/**
 * @author ssrivastava
 * This TestClass tests TestNG 'depends' attribute, dataProvider and DataProvider class-
 *
 */
public class PracticeTestNGAnnotationAttrDepends {
	
	@Test(dataProvider = "getEmailDataProvider")
	public void newLoginTest(String eml) {		// Getting Single Data Object
		
		System.out.print("\n=====>>> (by DataProvider) :: Logging in with eml='"+eml);
	}
	
	/*
	 * DataProvider 'name' attribute value can be same/different as its method name
	 */
	
	@DataProvider(name = "getEmailDataProvider")
	public Object[] getEmailDataProvider() {		// Same as name attr.
		
		return new Object [] { 						// Passing Single Data Object
			"shubh@gmail.com" 
		};
	}
	
	
	@Test(dataProvider = "getUPsDataProvider")
	public void loginTest(String unm, String pwd) {	// Getting MultiValue Data Object
		
		System.out.print("\n----->>> (by DataProvider) :: Logging in with unm='"+unm+"', pwd='"+pwd+"'\n");
	}

	/*
	 * DataProvider 'name' attribute value can be same/different as its method name
	 */
	
	@DataProvider(name = "getUPsDataProvider")
	public Object[][] loginUnmPwdsDataProvider() {	// Diff. to name attr.
		
		return new Object [][] {					// Setting MultiValue Data Object	
				{ "test@gmail.com", "test123" },
				{ "best@gmail.com", "best123" },
				{ "fest@gmail.com", "fest123" }
		};
	}
	
	
	/*
	 * Testing TestNG's DataProvider Class Feature -  
	 */
	
	@Test(dataProvider = "googleAuthDataProvider", dataProviderClass = LoginDataProvider.class)
	public void loginWithGoogleAuth(String unm) {	// Getting MultiValue Data Object
		
		System.out.print("\n~~~~~>>> (by DataProvider) :: Logging in with unm='"+unm);
	}
}
