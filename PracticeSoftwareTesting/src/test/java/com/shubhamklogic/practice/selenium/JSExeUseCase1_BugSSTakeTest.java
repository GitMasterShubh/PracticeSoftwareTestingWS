package com.shubhamklogic.practice.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JSExeUseCase1_BugSSTakeTest {

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
	 * 			- OR By WebDriverManager plugin/dependency.
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
	 * Q. What does this testCreateBorderAroundBug() test case do?
	 * A. Steps:  
	 * 		a) It launches a URL, where it looks for a specific string/text
	 * 		b) If it doesn't find that desired text, it treats it as a Bug
	 * 		c) It creates a red border around that element marking as a Bug
	 * 		d) It takes screenshot and saves it at a given location.
	 */

	@Test(priority = 1, testName = "Test - Create Border Around Bug", groups = { "selenium-intermediate", "sleep2sec"})
	public void testCreateBorderAroundBug() throws Exception {
		
		String expectedText = "You can become a \"Top class programmer\" -\n"
							+ "with Java. OR,\n"
							+ "with Python. OR,\n"
							+ "with JavaScript. OR,\n"
							+ "with PHP. OR,";
		
		// Launching the URL-
		driver.get("https://codepen.io/ShubhamKLogic/full/xxzppeE?by=ShubhamKLogic.com");
		// Switching to the frame, present in UI-
		driver.switchTo().frame("result");
		
		WebElement element = driver.findElement(By.className("main"));
		String actualText = element.getText();
		
		sleep2Seconds();
		
		// preparing file path
		String location = System.getProperty("user.dir");
		String fileSep = File.separator;
		
		// preparing file name with path
		String atPathWithFileName = location + fileSep + "/src/main/resources/AllMiscFiles/TestElementTextScreenshot.png";
				
				
		if(expectedText.equals(actualText)) {
			// Test case Passed : create a GREEN border around element, and save screenshot..
			String colourHex = "#008000";						// Hex. Code of Green Colour
			SeleniumHelperUtil.createBorderAroundWebElement( colourHex, element);
			
		} else {
			// Test case Failed : create a RED border around element, and save screenshot..
			String colourHex = "#ff0000";					  	// Hex. Code of Red Colour
			SeleniumHelperUtil.createBorderAroundWebElement( colourHex, element);
			
			// throw exception, OR put Assert.fail to mention a failed test case..
		}
		// Take screenshot ..
		SeleniumHelperUtil.takeAndSaveScreenshot( atPathWithFileName );
	}
	
	@Test(priority = 2, testName = "Test - Scroll to bottom", groups = { "selenium-intermediate", "sleep2sec"})
	public void testScrollToBottom() throws Exception {
	
		// https://en.wikipedia.org/wiki/Simon_Sinek
		
		driver.get("https://en.wikipedia.org/wiki/Simon_Sinek");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 3, testName = "Test - Scroll to view an element", groups = { "selenium-intermediate", "sleep2sec", "current"})
	public void testScrollToView() throws Exception {
		
		// url=https://en.wikipedia.org/wiki/Nelson_Mandela
		// id=Law_studies_and_the_ANC_Youth_League:_1943–1949
		
		driver.get("https://en.wikipedia.org/wiki/Nelson_Mandela");
		
		WebElement targetElement = driver.findElement(By.id("Biographies_and_popular_media"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);", targetElement);
	}
	
	@AfterTest (groups = {"sleep2sec"})
	public void sleep2Seconds() throws Exception {
		SeleniumHelperUtil.log("Sleeping for 2 seconds..");
		Thread.sleep(3000);
	}
	
	@AfterSuite( alwaysRun = true)
	public void tearDown() {
		SeleniumHelperUtil.log("tearDown()..");
		driver.close();
		driver.quit();
	}
}







