package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigationTest {
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

	@Test(priority = 1, testName = "Test visiting different Website Without- navigate method", groups = { "selenium-intermediate" })
	public void testWebsitesWithoutNavigateMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.shubhamklogic.com/");

		driver.get("https://google.com");
		
		Thread.sleep(2000);
		
		driver.get("https://twitter.com");
		
		Thread.sleep(2000);
	}

	@Test(priority = 1, testName = "Test Visiting Different Website With- navigate method", groups = { "selenium-intermediate", "current" })
	public void testWebsitesWithNavigateMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.shubhamklogic.com/");

		Thread.sleep(2000);									// Hard waits, to see the URL traversing ..
		
		driver.navigate().to("https://www.google.com");
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://twitter.com");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
