package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogleMeetTest {
	private WebDriver driver;
	
	/**
	 * 
	 * {Q} What does this method setup() do ?
	 * {A} It is responsible to create a ChromeDriver object with given configuration- 
	 * 		-> headless : true
	 */
	@BeforeClass(alwaysRun = true)
	public void setup() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver( chromeOptions );
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	/**
	 * @throws Exception
	 * Q. What does this testGoogleMeetHomePage() test case do?
	 * A. Steps:  
	 * 		a) It launches the Google Meet Home Page in the given Mode (by testng.xml : headless / nonHeadless)
	 * 		b) And, verifies the title of the page 
	 */

	@Test(priority = 1, testName = "Test - Login into app by properties file", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testGoogleMeetHomePage() throws Exception {
		
		driver.get("https://apps.google.com/meet/");
		
		String pageTitle = driver.getTitle();
		SeleniumHelperUtil.log("Webpage Title:==" + pageTitle );
		
		if(pageTitle.contains("Google Meet"))
			SeleniumHelperUtil.log("Test passed, It is a Google Meet webpage :))");
		else
			SeleniumHelperUtil.log("Test Failed, It is NOT a Google Meet webpage  :((");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();		// close current window..
		driver.quit();		// close all associated window, and quit driver..
	}
}
