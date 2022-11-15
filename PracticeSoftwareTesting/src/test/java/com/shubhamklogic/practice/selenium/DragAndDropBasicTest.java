package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragAndDropBasicTest {

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
	
	@Test(testName = "Drag And Drop Test - Using Selenium+Java", groups = { "selenium-intermediate", "current" })
	public void DragAndDropTest() throws Exception {

		driver.manage().window().maximize();
		driver.get("https://codepen.io/ShubhamKLogic/full/vYrNjOr");
		driver.switchTo().frame("result");									// switch to available frame..

		WebElement rat = driver.findElement(By.id("rat"));
		WebElement cage = driver.findElement(By.id("cage"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(rat, cage)
			.release(cage).build().perform();
		

//		Way 1 :-
//		actions.clickAndHold(rat)
//		.moveToElement(cage)
//		.release()
//		.build().perform();
		
//		Way 2 :-
//		actions.dragAndDrop(rat, cage)
//			.build().perform();
		
//		Way 3 :-
//		actions.clickAndHold(rat)
//		.moveToElement(rat, cage.getLocation().x, cage.getLocation().y)
//		.release(cage)
//		.build().perform();
		
		Thread.sleep(2000);													// Wait before Quitting the browser in @AfterTest..
		SeleniumHelperUtil.log("Rat has been put inside the Cage..");
		
	}
	
	@AfterTest( alwaysRun = true )
	public void tearDown() {
		SeleniumHelperUtil.log("@AfterTest :: tearDown() called..");
		driver.close();
		driver.quit();
	}
}
