package com.shubhamklogic.practice.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverWaitAdvancedTest {
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
	 * Q. What does this testLogoClicking() test case do?
	 * A. It launches a URL, 
	 * 		a) where multiple Web Elements (such as: Select-Option, Buttons, Images, etc.) 
	 * 			will be loading AFTER 5 SECONDS
	 * 	  	b) Then, it makes use of WebDriverWait Explicit Dynamic Wait, to perform actions on all such elements which are
	 * 			getting loaded after sometime of page load.   
	 * 
	 */

	@Test(priority = 1, testName = "Test - Try Clicking button With Explicit Wait Method", groups = { "selenium-intermediate", "sleep2sec"})
	public void testLogoClicking() throws Exception {
		// a) Launching URL - where all elements will be loaded after 5 seconds..
		driver.get("https://codepen.io/ShubhamKLogic/full/jOKmZaK?by=ShubhamKLogic.com");
		
		// Switching to the frame, present on UI-
		driver.switchTo().frame("result");
		
		// b) Created a custom wait method 'getElementOnceClickable()', for searching image with id  = 'logo-link'
		WebElement element = SeleniumHelperUtil.getElementOnceClickable(By.id("logo-link"), 20, driver);
		
		element.click();
	}
	
	/**
	 * @throws Exception
	 * Q. What does this Test case = testSelectCountryDropDown() do?
	 * A. It launches a URL, 
	 * 		a) where multiple Web Elements (such as: Select-Option, Buttons, Images, etc.) 
	 * 			will be loading AFTER 5 SECONDS.
	 * 	  	b) Then, it looks for all the country list web elements,  waits till 20 seconds for them to be loaded,
	 * 		c) Once it finds all such web element, then, it compare's their text with the desired country Name and 
	 * 		d) clicks on it.  
	 */
	
	@Test(priority = 2, testName = "Test - Select Country From Drop-Down", groups = { "selenium-intermediate", "sleep2sec", "current" })
	public void testSelectCountryFromDropDown() throws Exception {
		// a) Launching URL - where all elements will be loaded after 5 seconds..
		driver.get("https://codepen.io/ShubhamKLogic/full/jOKmZaK?by=ShubhamKLogic.com");
		
		// Switching to the frame, present on UI-
		driver.switchTo().frame("result");
		
		String countryName = "India";
		String xpath = "//option[@class='country-items']";
		
		// b) Created a custom wait method, to click visible country options- 
		List<WebElement> options = SeleniumHelperUtil.getDropDrowOptionOnceSelectable(By.xpath( xpath ), 20, driver);
		
		for(WebElement option : options) {
			if( option.getText().equalsIgnoreCase( countryName )) {
				option.click();
			}
		}
	}
	
	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(2000);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
