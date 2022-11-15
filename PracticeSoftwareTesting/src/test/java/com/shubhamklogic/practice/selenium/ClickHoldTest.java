package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClickHoldTest {
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

	@Test(testName = "Drag And Drop Test - Using Selenium + Javascript", groups = { "selenium-intermediate", "current" })
	public void DragAndDropTest() throws Exception {
		driver.get("https://codepen.io/ShubhamKLogic/full/WNyoxdo");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Switch to the frame present in UI..
		driver.switchTo().frame("result");
		
		WebElement theButton = driver.findElement(By.id("btn"));
		
		// Step 1: Perform click and hold on button..
		Actions actions = new Actions(driver);
		actions.clickAndHold( theButton )
			.build().perform();
		
		// Not required, but waiting before release to demonstrate you..
		Thread.sleep(3000);
		
		// Step 2: Release the hold item..
		actions.release( theButton )
			.build().perform();
		
		// Not required, but Waiting before Quitting the browser to demonstrate you..
		Thread.sleep(3000);
		SeleniumHelperUtil.log("Click and Hold performed on Button..");
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
