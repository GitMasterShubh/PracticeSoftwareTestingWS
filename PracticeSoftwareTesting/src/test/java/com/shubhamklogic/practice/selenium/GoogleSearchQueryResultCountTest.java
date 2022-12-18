package com.shubhamklogic.practice.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchQueryResultCountTest {

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
	 * Q. What does this testGoogleSearchQueryListCount() test case do?
	 * A. Steps:  
	 * 		a) Launch Google
	 * 		b) Enter any search term
	 * 		c) Count the suggestions after entering term   
	 */

	@Test(priority = 1, testName = "Test - Create Border Around Bug", groups = { "selenium-intermediate", "sleep2sec"})
	public void testGoogleSearchQueryListCount() throws Exception {
		
		// Step a) Launch Google
		driver.get("https://google.com");
		
		// Step b) Enter any search term
		String searchTerm = "SKL";
		
		driver.findElement(By.name("q")).sendKeys(searchTerm);
		
		// Step c) Count the Suggestions given by Google -
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//descendant::li"));
		// In above xpath, we have used 'descendant predicates' 
		
		SeleniumHelperUtil.log( "Total Suggestions ===> " + list.size() );
		
	}
	
	@Test(priority = 1, testName = "Test - Create Border Around Bug", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testMatchFromGoogleSearchQuerySuggestions() throws Exception {
		
		// Step a) Launch Google
		driver.get("https://google.com");
		
		// Step b) Enter any search term
		String searchTerm = "SKL";
		String searchInSuggestions = "sklearn";
		
		driver.findElement(By.name("q")).sendKeys(searchTerm);
		
		Thread.sleep(3000);
		
		// Step c) Get all the google suggestion
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::li"));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//div[@role='option']"));
		
		int k=0;
		for(WebElement s : list) {
			SeleniumHelperUtil.log("Suggestion:==>" + s.getText() + "<==");
			if(s.getText().equalsIgnoreCase( searchInSuggestions )) {
				k++;
			}
		}
		SeleniumHelperUtil.log("Total Occcurance of '"+searchInSuggestions + "'===>>"+k);
	}
	// "sklearn in python"

	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(3000);
	}
	
	@AfterSuite( alwaysRun = true)
	public void tearDown() {
		SeleniumHelperUtil.log("tearDown()..");
		driver.close();
		driver.quit();
	}
}
