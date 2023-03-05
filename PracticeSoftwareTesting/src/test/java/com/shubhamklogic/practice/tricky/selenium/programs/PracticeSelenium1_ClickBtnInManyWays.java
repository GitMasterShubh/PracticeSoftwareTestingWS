package com.shubhamklogic.practice.tricky.selenium.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

public class PracticeSelenium1_ClickBtnInManyWays {
	
	private WebDriver driver;
	WebElement btn;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log("preSetup of browser drivers and browsers to be called in future. Browsers='" + browsers
				+ "', browserDriverSetupMode='" + browserDriverSetupMode + "'");
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
	}
	
	@BeforeMethod
	public void setup()
	{
		SeleniumHelperUtil.log("==> setup() started...");

		driver.get("https://google.com");
		
		btn = driver.findElement(By.linkText("Gmail"));
		
		SeleniumHelperUtil.log("==> setup() ended...");
	}

	@Test(priority=1, testName = "Page Load Test - Without Wait", groups = { "selenium-intermediate", "current" })
	public void testPageLoad() throws Exception {
		
		// Clicking way1 -- btn.click();
		
		btn.click();
		
		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=2)
	public void testPageLoad2() throws Exception {
		
		// Clicking way2 -- btn.sendKeys(Keys.RETURN);
		
		btn.sendKeys(Keys.RETURN);
		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=3)
	public void testPageLoad3() throws Exception {
		
		// Clicking way 3.1 -- jsExe.executeScript("arguments[0].click", btn);
		
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("arguments[0].click", btn);
		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=4)
	public void testPageLoad4() throws Exception {
		
		// Clicking way 3.2 -- jsExe.executeScript("document.querySelector('a.gb_n').click");
		
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("document.querySelector('a.gb_n').click");

		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=5)
	public void testPageLoad5() throws Exception {
		
		// Clicking way 4.1 -- actions.click(btn).perform();
		
		Actions actions = new Actions(driver);
		actions.click(btn).perform();

		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=6)
	public void testPageLoad6() throws Exception {
		
		// Clicking way 4.2 -- actions.moveToElement(btn).click().perform(); 
		
		Actions actions = new Actions(driver);
		actions.moveToElement(btn).click().perform();

		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=7)
	public void testPageLoad7() throws Exception {
		
		// Clicking way 4.3 -- actions.clickAndHold(btn).release().perform();
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(btn).release().perform();

		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	
	@Test(priority=8)
	public void testPageLoad8() throws Exception {
		
		// Clicking way 4.4 -- actions.sendKeys(btn, Keys.RETURN);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(btn, Keys.RETURN);

		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void preCleanup() throws InterruptedException
	{
		SeleniumHelperUtil.log("==> Sleeping 3sec..");
		Thread.sleep(3000);
		
		boolean result = driver.getTitle().contains("Gmail");
		Assert.assertTrue(result);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
