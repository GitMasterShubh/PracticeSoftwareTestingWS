package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragAndDropWithJSTest {
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
		driver.get("https://codepen.io/ShubhamKLogic/full/vYrNjOr?by=ShubhamKLogic.com");
		driver.manage().window().maximize();
		driver.switchTo().frame("result");									// switch to available frame..

		WebElement rat = driver.findElement(By.id("rat"));
		WebElement cage = driver.findElement(By.id("cage"));
		
		JavascriptExecutor jsexe = (JavascriptExecutor) SeleniumHelperUtil.getDriver();
		
		// Performing Drag and Drop using JS-
		jsexe.executeScript(SeleniumHelperUtil.getJSDragAndDropCode(),
			rat, cage);
		
		Thread.sleep(2000);													// Wait before Quitting the browser in @AfterTest..
		SeleniumHelperUtil.log("Rat has been kept inside the Cage..");
		
	}
	
	@Test(testName = "Multi Drag and Drop - Using Selenium + Javascript", groups = { "selenium-intermediate" } )
	public void MultiDragAndDropTest() throws Exception {
		driver.manage().window().maximize();
		driver.get("https://codepen.io/ShubhamKLogic/full/JjZRXQB?by=ShubhamKLogic.com");
		driver.switchTo().frame("result");
		
		WebElement rat = driver.findElement(By.id("rat"));
		WebElement cat = driver.findElement(By.id("cat"));
//		WebElement lion = driver.findElement(By.id("lion"));
		
		JavascriptExecutor jsExe = (JavascriptExecutor)driver;
		jsExe.executeScript(SeleniumHelperUtil.getJSDragAndDropCode(), 
			rat, cat);														// Cat's image would dragged and dropped into Rat..
		
		
		Thread.sleep(2000);													// Wait before Quitting the browser in @AfterTest..
		SeleniumHelperUtil.log("Rat has been eaten by the Cat..");
	}
	
	@AfterClass( alwaysRun = true )
	public void tearDown() {
		SeleniumHelperUtil.log("@AfterClass :: tearDown() called..Closing Browser and Driver..");
		driver.close();
		driver.quit();
	}
}
