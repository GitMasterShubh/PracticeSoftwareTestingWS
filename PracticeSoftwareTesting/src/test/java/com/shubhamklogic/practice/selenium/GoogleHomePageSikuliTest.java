package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.WebDriver;

//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * Currently, the sikuli api is not stable with our project's few dependencies versions.
 * So, This TestClass would not perform any test case execution.
 * Temporarily Commented the Dependency in pom.xml and 
 * Temporarily Commented the Java code in this Testclass as well.  
 */


public class GoogleHomePageSikuliTest {
	private WebDriver driver;
	
	/**
	 * @param browsers
	 * @param browserDriverSetupMode
	 * 
	 * Q. What does this method preSetup() do ?
	 * A. It takes 2 parameters, "browsers" and "browserDriverSetupMode"
	 * 		a) To setup the browser drivers and browsers to be called by further test cases-
	 * 		b) It also takes care of, How will be the drivers be managed in this framework 
	 * 			- By Manually included Browser Driver binary files,
	 * 			- OR By WebDriverManager plugin/dependency.
	 *      
	 */
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {
		
		// a) To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log("preSetup of browser drivers and browsers to be called in future. Browsers='" + browsers
				+ "', browserDriverSetupMode='" + browserDriverSetupMode + "'");
	
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	/**
	 * @throws Exception
	 * Q. What does this testGoogleLogo() test case do?
	 * A. Steps:  
	 * 		a) It launches the Google.com
	 * 		b) And, using Sikuli Image Recognition technique, it verifies whether- Google's default centre logo is loaded correctly or not.
	 * 		c) Close and Quit Driver & Browser
	 * 
	 */

	@Test(priority = 1, testName = "Test - Google Default Logo", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testGoogleLogo() throws Exception {
		
		// Step a) Launch Youtube Video
		driver.get("https://www.google.com");
		
		/*
			Screen scr = new Screen();
			
			// preparing file path
			String location = System.getProperty("user.dir");
			String fileSep = File.separator;
			
			Pattern ptrn = new Pattern(location + fileSep + "/src/main/resources/AllMiscFiles/Google_Default_Logo.png");
					
			scr.click(ptrn);
		
		*/
		
		// TBD : To Be Done -
		
	}
}
