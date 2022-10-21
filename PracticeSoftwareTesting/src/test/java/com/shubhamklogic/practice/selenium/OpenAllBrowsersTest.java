package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 
public class OpenAllBrowsersTest {

	/**
	 * 
	 * @param browsers
	 * @param browserDriverSetupMode
	 * 
	 * About this Test Class: 
	 * 		Session1: This TestClass contains tests, that Opens All Browsers and Launches a URL -
	 * 
	 */
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// to setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);

	}
	
	@Test(testName = "chromeBrowsersOpenTest")
	public void chromeBrowsersOpenTest() {

		try {
			String URL = "https://shubhamklogic.com/";

			WebDriver driver = new ChromeDriver();
			driver.get(URL);
			Thread.sleep(3000);
			driver.close();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(testName = "firefoxBrowsersOpenTest")
	public void firefoxBrowsersOpenTest() {
		try {
			String URL = "https://shubhamklogic.com/";
			WebDriver driver = new FirefoxDriver();
			driver.get(URL);
			Thread.sleep(3000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(testName = "safariBrowsersOpenTest")
	public void safariBrowsersOpenTest() {
		try {
			String URL = "https://shubhamklogic.com/";
			WebDriver driver = new SafariDriver();
			driver.get(URL);
			Thread.sleep(3000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(testName = "edgeBrowsersOpenTest")
	public void edgeBrowsersOpenTest() {
		try {
			String URL = "https://shubhamklogic.com/";
			WebDriver driver = new EdgeDriver();
			driver.get(URL);
			Thread.sleep(3000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
