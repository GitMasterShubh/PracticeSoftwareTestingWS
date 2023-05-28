package com.shubhamklogic.practice.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FluentWaitTest {
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
	
	
	// Test case will -> FAIL, 
	// As the button will not be found by this test immediately, as it will be loaded on Web page after 5 Seconds) 
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
	
	
	// Test case will --> PASS, 
	// As even if button will be loaded after 5 seconds, the Explicit Wait will take care of it and successfully click it.. 
	@Test(priority = 2, testName = "Test Button With Explicit Wait Method", groups = { "selenium-intermediate", "current" })
	public void testButtonWithWaitMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		WebElement button = null;
		// Launching URL - where the submit button will be loaded after 5 seconds..
		driver.get("https://codepen.io/ShubhamKLogic/full/BaVRwEr?by=ShubhamKLogic.com");
		driver.switchTo().frame("result");
		
		// Fluent Wait Declaration, Configuration and Usage-
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		
		fluentWait.withTimeout(Duration.ofSeconds(20));
		
		fluentWait.pollingEvery(Duration.ofSeconds(1));
		
		fluentWait.ignoring(NoSuchElementException.class);
		
		
		Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>() {

			@Override
			public Boolean apply(WebDriver webdriver) {
				
				WebElement ele = driver.findElement(By.id("submitBtn"));
				try {
					
					ele.click();
					SeleniumHelperUtil.log("Clicked the button using FluentWait..");
					return true;
					
				}catch(Exception e) {
					SeleniumHelperUtil.log("Did not find button, polling every 1 sec.");
					return false;
				}
			}
		};
		
		fluentWait.until( function );
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
