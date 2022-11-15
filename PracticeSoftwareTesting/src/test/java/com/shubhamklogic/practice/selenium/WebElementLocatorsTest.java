package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/**
 * 
 * @author ssrivastava
 * About this Test Class -
 * 	This Test class executes different test cases, by using all different Locators available in Selenium.
 * 	1: Relative xpath
 * 	2: ID
 * 	3: name
 * 	4: linkText
 * 	5: partialLinkText
 * 	6: CSS Selector - Part A- CSS Selector for ID attribute
 * 	6: CSS Selector - Part B - use multiple classes at once
 * 	7: Using className Selenium method
 * 	8: Using TagName Selenium locator
 */
public class WebElementLocatorsTest {
	
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log(
				"preSetup of browser drivers and browsers to be called in future. Browsers='"
				+ browsers + "', browserDriverSetupMode='"
																		+ browserDriverSetupMode + "'");
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
	}
	
	
//	Selenium Locator 1: Relative xpath
	/**
	 * About this test - 
	 * It searches and counts number of blogs containing a particular word in it. 
	 */
	@Test(testName="Testcase : blog Search Using Rel. Xpath Locator", groups = {"selenium-basics"})
	public void blogSearchUsingRelXpathLocatorTest() {
		
		String searchBlogsWith = "Java";				// Search term
		driver.get("https://shubhamklogic.com/");		// Search blogs/webpages at this website having that 'word' 
		
														// Searching webElement using Locator = RELATIVE XPATH 
		WebElement searchIcon = driver.findElement(By.xpath("//ul[@id='menu-menu-2-toplinks-inarow-front']//li[@class='search-item menu-item-align-right']//a[@aria-label='Open Search Bar']"));
		searchIcon.click();
		
		WebElement searchInput = driver.findElement(By.name("s"));
		searchInput.sendKeys("");						// Clearing the input field
		searchInput.sendKeys(searchBlogsWith);			// Input value in search input field
		searchInput.sendKeys(Keys.RETURN);				// Hit Enter/Return from keyboard
	}
	
	
//	Selenium Locator 2: ID
	/**
	 * About this test - 
	 * It checks, whether the website has the footer note - "About Website" 
	 */
	@Test(testName="Testcase : check About Website Info From Footer", groups = {"selenium-basics"})
	public void checkAboutSiteInfoFromFooterTest() {
		
		driver.get("https://shubhamklogic.com/");		// Search blogs/webpages at this website having that 'word' 
		
														// Searching webElement using Selenium Locator: id=text-2
		WebElement footerTitle = driver.findElement(By.id("text-2"));
		SeleniumHelperUtil.log(footerTitle.getText());	// Actual Result
		
	}
	
//	Selenium Locator 3: name
	@Test(testName = "Testcase : update IP Address OR Username", groups = { "selenium-basics" })
	public void updateIPAddressOrUsername() {

		driver.get("https://en.wikibooks.org/wiki/Special:Contributions/ShubhamKLogic");
		driver.findElement(By.xpath(
				"//div[@class='mw-htmlform-ooui-wrapper oo-ui-layout oo-ui-panelLayout oo-ui-panelLayout-padded oo-ui-panelLayout-framed']"))
				.click();
		WebElement username = driver.findElement(By.name("target"));

		username.clear();
		username.sendKeys("ShubhamKLogic.com");

	}

//	Selenium Locator 4: linkText
	@Test(testName = "Test case : verify Gmail by Link Name", groups = { "selenium-basics"})
	public void verifyGmailByLinkText() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.linkText("Gmail")).click();		// Clicking "Gmail" link by giving Link Name
	}


//	Selenium Locator 5: partialLinkText
	@Test(testName = "Test case : verify Gmail by Partial Link Name", groups = { "selenium-basics" })
	public void verifyGmailByPartialLinkText() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.partialLinkText("Gma")).click();		// Clicking "Gmail" link by giving Partial Link Name	
	}

	
//	Selenium Locator 6: Part A- CSS Selector for ID attribute
	@Test(testName = "Test case : verify Google Search by CSS Selector", groups = { "selenium-basics" })
	public void verifyGoogleSearch() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.cssSelector("#q"))								// Entering search term using css selector : id (starts with #)
			.sendKeys("ShubhamKLogic.com - Full Selenium Tutorial");
		
		driver.findElement(By.name("btnK")).click();
	}

	
	// Locator 6: part B
	// use multiple classes at once - "gb_2 gb_3 gb_9d gb_9c" Google "Sign In"
	@Test(testName = "Test case : verify Google Search by CSS Selector", groups = { "selenium-basics" })
	public void verifyGoogleSignIn() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.cssSelector(".gb_2.gb_3.gb_9d.gb_9c")).click();	// Using css selector : multiple class values given to same element
		
		driver.findElement(By.name("identifier")).sendKeys("dummy@shubhamklogic.com");
		
		driver.findElement(By.cssSelector("#identifierNext")).click();			// css selector : id (starts with #)
	}

	// Locator 7: Using className Selenium method -
	@Test(testName = "Test case : verify Google Search by Class Name", groups = { "selenium-basics", "current" })
	public void verifyGoogleForgetPassword() {
		
		driver.get("https://accounts.google.com/signin/v2/usernamerecovery");
		
		driver.findElement(By.className("whsOnd")).sendKeys("dummy@shubhamklogic.com");	// Using class name
		
		driver.findElement(By.className("VfPpkd-LgbsSe-OWXEXe-k8QpJ")).click();			// Using class name
	}

	// Locator 8: Using TagName Selenium locator -
	@Test(testName = "Test case : verify Google Next button without filling Data", groups = { "selenium-basics",
			"current" })
	public void verifyGoogleNextButton() throws InterruptedException {

		verifyGoogleForgetPassword();

		Thread.sleep(2000);

		driver.findElement(By.tagName("button")).click(); // Selenium Locator = Button
	}

}
