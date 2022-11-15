package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PopupAlertsTest {

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

//	Selenium Popup Handling - Simple Alert
	/**
	 * About this test - This test goes to a website and handles a simple alert
	 * popup -
	 */
	@Test(testName = "Testcase : Verify Simple Alert", groups = { "selenium-basics" })
	public void verifySimpleAlert() {

		driver.get("https://codepen.io/ShubhamKLogic/pen/xxzGmJa?source=ShubhamKLogic.com");

		driver.switchTo().frame("result"); // A frame is available between the button and the html root element, so
											// switching to frame to access elements present inside it..
		WebElement wButton1 = driver.findElement(By.id("alert1")); // clicking on button to generate a popup / alert..
		wButton1.click();

		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("Simple Alert Message=" + alertMsg);

	}

//	Selenium Popup Handling - Confirmation Alert
	/**
	 * About this test - This test goes to a website and handles a confirmation
	 * alert / popup -
	 */
	@Test(testName = "Testcase : Verify Confirm Alert", groups = { "selenium-basics" })
	public void verifyConfirmAlert() {

		driver.get("https://codepen.io/ShubhamKLogic/pen/xxzGmJa?source=ShubhamKLogic.com");

		driver.switchTo().frame("result"); // A frame is available between the button and the html root element, so
											// switching to frame to access elements present inside it..
		WebElement wButton1 = driver.findElement(By.id("alert2")); // clicking on button to generate a popup / alert..
		wButton1.click();

		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("Confirmation Alert Message=" + alertMsg);

		if (alertMsg.contains("Confirmation Popup")) {
			alert.accept();
			SeleniumHelperUtil.log("Alert accepted !!");
		} else {
			alert.dismiss();
			SeleniumHelperUtil.log("Alert dismissed!!");
		}

//		alert.sendKeys("Dummuy SendKeys");									No such alert (ERROR) : This is not a Prompt Alert

	}

//	Selenium Popup Handling - Confirmation Alert
	/**
	 * About this test - This test goes to a website and handles a prompt alert /
	 * popup -
	 */
	@Test(testName = "Testcase : Verify Prompt Alert", groups = { "selenium-basics", "current" })
	public void verifyInputAlert() {

		driver.get("https://codepen.io/ShubhamKLogic/pen/xxzGmJa?source=ShubhamKLogic.com");

		driver.switchTo().frame("result"); 							// A frame is available between the button and the html root element, so
																	// 		switching to frame to access elements present inside it..
		WebElement wButton1 = driver.findElement(By.id("alert3")); 	// Clicking on button to generate a popup / alert..
		wButton1.click();

		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("Prompt Alert Message=" + alertMsg);

		alert.sendKeys("Sending new Prompt text.."); 				// Won't display new text in UI. Bug in ChromeDriver.. :
																	// https://bugs.chromium.org/p/chromedriver/issues/detail?id=1120#c11

		alertMsg = alert.getText();
		System.out.println("Prompt Alert Message=" + alertMsg);

		if (alertMsg.contains("Prompt Popup")) {
			alert.accept();
			SeleniumHelperUtil.log("Alert accepted !!");
		} else {
			alert.dismiss();
			SeleniumHelperUtil.log("Alert dismissed!!");
		}

		System.out.println("byeee...");
	}
	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
