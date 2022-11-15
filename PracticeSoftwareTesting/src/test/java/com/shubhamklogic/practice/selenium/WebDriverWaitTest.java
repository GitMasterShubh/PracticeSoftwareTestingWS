package com.shubhamklogic.practice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverWaitTest {
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
	
	// Test case will -> FAIL, As the button will not be found by this test immediately, as it will be loaded on Web page after 5 Seconds) 
	@Test(priority = 1, testName = "Test Button Without Explicit Wait Method", groups = { "selenium-intermediate", "current" })
	public void testButtonWithoutWaitMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Launching URL - where the submit button will be loaded after 5 seconds..
		driver.get("https://codepen.io/ShubhamKLogic/full/BaVRwEr?by=ShubhamKLogic.com");
		driver.switchTo().frame("result");

		
		// FAIL: Element not interactable.. because, Element is not loaded on UI Properly..
		driver.findElement(By.id("submitBtn")).click();
		
		Thread.sleep(3000);
	}
	
	
	// Test case will --> PASS, As even if button will be loaded after 5 seconds, the Explicit Wait will take care of it and successfully click it.. 
	@Test(priority = 2, testName = "Test Button With Explicit Wait Method", groups = { "selenium-intermediate", "current" })
	public void testButtonWithWaitMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Launching URL - where the submit button will be loaded after 5 seconds..
		driver.get("https://codepen.io/ShubhamKLogic/full/BaVRwEr?by=ShubhamKLogic.com");
		driver.switchTo().frame("result");
		
		// Explicit Wait -
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		
		// Wait for this element - then click..
		// PASS..As the explicit wait, will wait for the button till maximum 20 seconds and then click it..
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable( By.id("submitBtn")) );
		
		button.click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
