package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragAndDropAdvancedTest {
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

	@Test(testName = "Drag And Drop Test", groups = { "selenium-intermediate"})
	public void DragAndDropTest() {

		driver.manage().window().maximize();
		driver.get("https://codepen.io/ShubhamKLogic/full/dyKYOqY");
		driver.switchTo().frame("result"); // switch to available frame..

		WebElement rat = driver.findElement(By.id("rat"));
		WebElement cat = driver.findElement(By.id("cat"));
		WebElement lion = driver.findElement(By.id("lion"));

		Actions actions = new Actions(driver);

//		Way -- 1 :
//		actions.clickAndHold(rat)
//			.moveToElement(cat)
//			.release()
//			.build().perform();

//		Way -- 2 :
//		actions.dragAndDrop(rat, cat)
//		.build().perform();

//		Way -- 3 :
//		int x = cat.getLocation().x;
//		int y = cat.getLocation().y;
//		
//		actions.moveToElement(rat)
//			.pause(Duration.ofSeconds(1))
//			.clickAndHold(rat)
//			.pause(Duration.ofSeconds(1))
//			.moveByOffset(x, y)
//			.moveToElement(cat)
//			.moveByOffset(x, y)
//			.pause(Duration.ofSeconds(1))
//			.release().build().perform();

//		Way -- 4 : Thought to set X,Y axises of dropData, but not possible without JS
//		int xr = rat.getLocation().x;int yr = rat.getLocation().y;int xc = cat.getLocation().x;int yc = cat.getLocation().y;
//		SeleniumHelperUtil.log("Rat:: Top="+rat.getCssValue("top")+",Left="+rat.getCssValue("left"));
//		SeleniumHelperUtil.log("Cat:: Top="+cat.getCssValue("top")+",Left="+cat.getCssValue("left"));

//		SeleniumHelperUtil.log("Axis: Rat("+xr+","+yr+")\n"+"Cat("+xc+","+yc+")");

		SeleniumHelperUtil.log("Cat has eaten the Rat..");

		// Next thing to try is to - With Way 2 AND On
		// Show the Drag & Drop demo on site - jqueryui.com/droppable
	}
}
