package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementsInsideFramesTest {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log("preSetup of browser drivers and browsers to be called in future. Browsers='" + browsers
				+ "', browserDriverSetupMode='" + browserDriverSetupMode + "'");
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
	}
	
//	Selenium Frame Handling-
	/**
	 * About this test - 
	 * This test searches elements inside HTML Frames and performs actions on them.. 
	 * NOTE: Whether their is <iframe> , <frameset> or <frame>, we must need to switch to access elements inside them..
	 * @throws InterruptedException 
	 */
	@Test(testName="Testcase : Check Colourful Links Inside HTML Frame", groups = {"selenium-basics", "current"})
	public void clickLinksToSwitchColourTest() throws InterruptedException {
		
		String siteUrl = "https://codepen.io/ShubhamKLogic/full/qBKOOjq";		// Sample Site designed by ShubhamKLogic.com
		driver.get(siteUrl);
		
//		driver.findElement(By.id("white")).click();								// ERROR: This element is inside: 'iframe', before accessing it, we need to switch to that 'iframe'
		
		driver.switchTo().frame(0);												// Fix 1: Switching to iframe.. through their index number which start from 0 (ZERO) => For First Frame, Index 1 => For Second Frame, and so on..
//		driver.switchTo().frame("result");										// Fix 2: To switch to frames, we can provide their ID or NAME as well..
		
		driver.findElement(By.id("white")).click();								// Now, it will be accessible..
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("green")).click();								// Not, it will also be accessible..
		
	}
}
