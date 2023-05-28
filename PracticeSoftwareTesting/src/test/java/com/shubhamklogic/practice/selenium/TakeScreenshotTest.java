package com.shubhamklogic.practice.selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TakeScreenshotTest {
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

	@Test(priority = 1, testName = "Test Take Screenshot Test", groups = { "selenium-intermediate", "current" })
	public void testWebsitesWithoutNavigateMethod() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Launching URL
		driver.get("https://www.shubhamklogic.com/");
		
		// preparing file path
		String location = System.getProperty("user.dir");
		String fileSep = File.separator;
		
		// preparing file name with path
		String fullPathWithFileName = location + fileSep + "/src/main/resources/AllMiscFiles/ShubhamKLogic_HomePage_Screenshot.png";
		
		// Using TakesScreenshot Interface and getScreenshotAt method, by passing OutputType Interface Object-
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Copying the source file to fullPathWithFileName target location-
		FileUtils.copyFile(src, new File( fullPathWithFileName ));
		
		Thread.sleep(2000);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}

