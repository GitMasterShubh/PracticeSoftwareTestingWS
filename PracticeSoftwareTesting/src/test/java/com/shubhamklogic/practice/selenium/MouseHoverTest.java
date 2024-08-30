package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MouseHoverTest {
	
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

	@Test(testName = "Drag And Drop Test - Using Selenium + Javascript", groups = { "selenium-intermediate" })
	public void DragAndDropTest() throws Exception {
		driver.get("https://codepen.io/ShubhamKLogic/full/LYrbzrO?by=ShubhamKLogic.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Switch to the frame as it is present in the GUI..
		driver.switchTo().frame("result");
		
		// Step 1: Mouse hovering to Level-1 Menu : Web Technologies
		new Actions(driver)
			.moveToElement(driver.findElement(By.id("Web-Technologies")))
			.perform();
		
		// Step 2: Mouse hovering to Level-2 Menu : Styles
		new Actions(driver)
			.moveToElement(driver.findElement(By.id("Styles")))
			.perform();
		
		// Step 3: Clicking on listed Level-3 Menu : Bootstrap
		driver.findElement(By.id("Bootstrap")).click();
			
		// (Not required) Waiting for 3 seconds before Quitting the browser in @AfterClass..
		Thread.sleep(3000);
		SeleniumHelperUtil.log("Click and Hold performed on Button..");
	}
	
	@Test(testName = "Mouse Over Click Test - Using Selenium + Java", groups = { "selenium-intermediate"})
	public void MouseOverClickTest() throws Exception {
		
		// Open Google homepage
		driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");

        // Locate the Google Search button
		WebElement searchButton = driver.findElement(By.className("dropdown2"));

        // Perform mouseover (hover) action on the search button
		performMouseover(driver, searchButton);

        // Wait for 2 seconds to observe the mouseover effect
		Thread.sleep(5000);

        // Close the browser
	}
	
	@Test(testName = "Mouse Over Tooltip Text Reader Test", groups = {"current" })
	public void mouseOverTooltipTextReadTest() throws Exception {
		
		driver.get("https://codepen.io/shubh-sri/full/PoxBVvg");
		driver.switchTo().frame("result");
		
		 // Locate the image element
        WebElement imageElement = driver.findElement(By.xpath("//div[@class='imgbox']/img"));

        // Perform a mouseover (hover) action on the image
        performMouseover(driver, imageElement);

        // Get the tooltip text
        String tooltipText = getTooltipText(driver);

        // Print the tooltip text
        System.out.println("Tooltip Text: " + tooltipText);

        // Close the browser
        // driver.quit();
		
	}
	
	
	private static void performMouseover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
    }
	
	private static String getTooltipText(WebDriver driver) {
        WebElement tooltipElement = driver.findElement(By.xpath("//div[@class='imgbox']/img"));
        return tooltipElement.getAttribute("title");
    }


	
	@AfterClass( alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
