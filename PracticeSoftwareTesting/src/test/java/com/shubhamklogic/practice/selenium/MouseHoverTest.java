package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MouseHoverTest {
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
		driver.get("https://codepen.io/ShubhamKLogic/full/LYrbzrO?by=ShubhamKLogic.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Switch to the frame as it is present in the GUI..
		driver.switchTo().frame("result");
		
		// Step 1: Mouse hovering to Level-1 Menu : Web Technologies
		new Actions(driver)
			.moveToElement(driver.findElement(By.id("Web-Technologies")))
			.perform();
		
		// Step 2: Mouse hovering to Level-2 Menu : Styles
		new Actions(driver)
			.moveToElement(driver.findElement(By.id("Styles")))
			.perform();
		
		// Step 3: Clicking on listed Level-3 Menu : Bootstrap
		driver.findElement(By.id("Bootstrap")).click();
			
		// (Not required) Waiting for 3 seconds before Quitting the browser in @AfterClass..
		Thread.sleep(3000);
		SeleniumHelperUtil.log("Click and Hold performed on Button..");
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
