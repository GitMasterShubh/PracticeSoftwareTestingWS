package com.shubhamklogic.practice.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ObjectRepositoryPropFileUseTest {
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
	 * 			- OR By WebDriverManager plugin.
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
	 * Q. What does this testLoginByPropertiesFile() test case do?
	 * A. Steps:  
	 * 		a) Loads a properties file (Object Repository) = testing_static_details.properties
	 * 		b) Use its key - values, to launch the URL
	 * 		c) Login to the application
	 * 		d) Validate, whether successfully logged in or not ? 
	 */

	@Test(priority = 1, testName = "Test - Login into app by properties file", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testLoginByPropertiesFile() throws Exception {
		
		String fullPropFilePath = System.getProperty("user.dir")+ File.separator + "src"+ File.separator +"main"+ File.separator +"resources"+ File.separator +"ObjectRepository"+ File.separator +"testing_static_details.properties";
		// /Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/ObjectRepository/testing_static_details.properties
		
		// Step a) Load properties file (Object Repository)
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream( fullPropFilePath );
		prop.load(fis);
		

		// Step b) Fetch value by passing its key = url-wikibooks-shubhamklogic, to launch the URL
		driver.get( prop.getProperty("url-wikibooks-shubhamklogic") );
		
		
		// Step c) Login to the application 
		driver.findElement(By.id("pt-login")).click();
		
		String uname = prop.getProperty("username-wikibooks-shubhamklogic");		// Use of Object repository..
		String pwd = prop.getProperty("password-wikibooks-shubhamklogic");			// Use of Object repository..
		
		driver.findElement(By.cssSelector("#wpName1")).sendKeys(uname);
		driver.findElement(By.cssSelector("#wpPassword1")).sendKeys(pwd);
		driver.findElement(By.cssSelector("#wpLoginAttempt")).click();
		
		
		// Step d) Validate, whether successfully logged in or not ? 
		String expectedUserName = uname;
		String actualUserName = driver.findElement(By.xpath("//a[@class='new']//span")).getText();
		
		if(expectedUserName.equals(actualUserName))
			SeleniumHelperUtil.log("Hurrey !! Logged in using Object Repository - by ShubhamKLogic.com");
		else
			SeleniumHelperUtil.log("Oops !! Look like, not able to log it. Please check manuallay-");
	}
	
	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(2000);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		SeleniumHelperUtil.log("tearDown()..");
		driver.close();
		driver.quit();
	}
}
