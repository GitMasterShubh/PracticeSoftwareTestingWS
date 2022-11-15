package com.shubhamklogic.practice.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowHandleTest {
	private WebDriver driver;
	
	/**
	 * @param browsers
	 * @param browserDriverSetupMode
	 * 
	 * Q. What does this method preSetup() do ?
	 * A. It takes 2 parameters, "browsers" and "browserDriverSetupMode"
	 * 		a) To setup the browser drivers and browsers to be called by further test cases-
	 * 		b) It also takes care of, How will be the drivers be managed in this framework 
	 * 			- By Manually included Browser Driver binary files,
	 * 			- OR By WebDriverManager plugin.
	 *      
	 */
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {
		
		// a) To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log("preSetup of browser drivers and browsers to be called in future. Browsers='" + browsers
				+ "', browserDriverSetupMode='" + browserDriverSetupMode + "'");
	
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	/**
	 * @throws Exception
	 * Q. What does this testWindowHandling() test case do?
	 * A. Steps:  
	 * 		a) It launches a URL, Where a link will there on first Tab UI, and once control will click the link,
	 * 		b) A URL will be launched in a New browser window.
	 * 		c) Then, Getting all opened window's ID,
	 * 		d) Switching to the newly open window (child window),
	 * 		e) Then, it again clicks on the 1st link of the newly opened window,
	 * 		f) Closing the child window, And, switching control back to the Parent window.
	 */

	@Test(priority = 1, testName = "Test - Multiple Browser Windows Handling", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testWindowHandling() throws Exception {
		// a) Launching URL - a link will be present that will open a new window, once clicked..
		driver.get("https://codepen.io/ShubhamKLogic/full/qBKjEjK?by=ShubhamKLogic.com");
		
		// switching to the frame, present in UI -
		driver.switchTo().frame("result");
		
		// b) Get the second link, and clicking it to open New Window..
		driver.findElements(By.className("main-tab-links")).get(0)
			.click();
		
		// c.1) Getting set (list) all opened window's ID 
		Set<String> handler = driver.getWindowHandles();
		
		// Printing all window ids-
		// SeleniumHelperUtil.log("All window ids=\n"+handler.toString());
		// Printing current window id-
		// SeleniumHelperUtil.log("Current window id="+driver.getWindowHandle());
		
		// c.2) Getting iterator object to get stored Window'IDs
		Iterator<String> itr = handler.iterator();
		
		// c.3) Getting first window id-
		itr.next();
		
		// d) switching to the newly opened child window-
		driver.switchTo().window(itr.next());
		
		// To access elements inside a frame element, switching to that frame, present in UI -
		driver.switchTo().frame("result");
		
		List<WebElement> list2 = driver.findElements(By.className("main-tab-links"));
		list2 = driver.findElements(By.className("main-tab-links"));
		
		sleep2Seconds();
		
		// e) Clicking on the 1st link of the newly opened window
		list2.get(0).click();
		
		sleep2Seconds();
		
		driver.close();
	}
	
	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(2000);
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		SeleniumHelperUtil.log("tearDown()..");
		driver.close();
		driver.quit();
	}
}
