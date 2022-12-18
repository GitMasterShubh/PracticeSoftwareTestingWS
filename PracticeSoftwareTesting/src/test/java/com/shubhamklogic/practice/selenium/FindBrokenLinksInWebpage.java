package com.shubhamklogic.practice.selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author ssrivastava
 * Desc : This Testclass contains testcases that let us know, 
 * 		  In a webpage - How many such links are present, that are returning improper response (Eg: 400 Bad Request, 503 Server Error, 404 File not found, etc..)
 */

public class FindBrokenLinksInWebpage {

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
	
	@Test(testName = "Test: Webpage Broken Links Presence")
	public void testWebpageBrokenLinksPresence() throws Exception {
		
		// 1. Setup and Open Browser to Go the webpage, 
		// 2. Collect all links and active links of <a> and <img> elements that have 'href' attribute with values like "http" and not like "javascript:"
		// 3. Use HTTPURLConnection and URL classes with openConnection() method to verify, whether the links are active or not.
		
		
		// 1. Setup and Open webpage :
		driver.get("https://google.com");
		
		
		// 2: Collect elements that have 'href' value= 'http...' 
		List<WebElement> allLinksImgsElements = driver.findElements(By.tagName("a"));		
		allLinksImgsElements.addAll( driver.findElements(By.tagName("img")));

		List<String> activeLinks = new LinkedList<String>();
		
		for(WebElement e : allLinksImgsElements) {
			
			String attrHref = e.getAttribute("href");
			SeleniumHelperUtil.log(attrHref);
			
			if ( ! attrHref.contains("javascript:") ) {					// removing links which are using js to launch url..
				activeLinks.add(attrHref);
			}
		}
		
		
		// 3. Verify, whether the link is active or not..
		
		for(String strUrl : activeLinks) {
			
			HttpURLConnection httpConnection = (HttpURLConnection) new URL( strUrl ).openConnection();
			httpConnection.connect();
			String respMsg = httpConnection.getResponseMessage();
			httpConnection.disconnect();
			
			SeleniumHelperUtil.log(" "+ respMsg + " <-- " + strUrl);
		}
	}
}


// org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Possible causes are invalid address of the remote server or browser start-up failure.