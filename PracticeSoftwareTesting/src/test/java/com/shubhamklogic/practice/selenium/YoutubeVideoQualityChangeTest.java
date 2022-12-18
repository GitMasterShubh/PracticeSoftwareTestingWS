package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class YoutubeVideoQualityChangeTest {
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
	 * Q. What does this testUpdateVideoQualityTo360px() test case do?
	 * A. Steps:  
	 * 		a) Launch Youtube Video
	 * 		b) Click settings icon
	 * 		c) Click quality dropdown 
	 * 		d) Click on 360p option
	 * 		e) Close and Quit Driver & Browser
	 * 
	 */

	@Test(priority = 1, testName = "Test - Update Video Quality To 360px", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testUpdateVideoQualityTo360px() throws Exception {
		
		// Step a) Launch Youtube Video
		driver.get("https://www.youtube.com/watch?v=Tm1TeqdYrrI");
		
		// click settings icon
		driver.findElement(By.xpath("//button[contains(@class,'ytp-button ytp-settings-button')]"))
			  .click();
		
		// click quality dropdown icon to open list of pixels : 144p, 360p, 720p, 1040p etc..
		driver.findElement(By.xpath("//div[@id='ytp-id-18']//div[text()='Quality']/following-sibling::div"))
			  .click();
		
		// click on 360p option -
		driver.findElement(By.xpath("//div[@id='ytp-id-18']//div[@role='menuitemradio']//span[contains(text(),'360')]//ancestor::div[@class='ytp-menuitem-label']"))
			  .click();
	}
	
	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(3000);
	}
	
	@AfterSuite( alwaysRun = true)
	public void tearDown() {
		// Step e) Close and Quit Driver & Browser
		SeleniumHelperUtil.log("tearDown()..");
		driver.close();
		driver.quit();
	}
}
