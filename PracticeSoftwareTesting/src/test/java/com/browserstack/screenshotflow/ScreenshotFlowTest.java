package com.browserstack.screenshotflow;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.browserstack.util.AppUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotFlowTest {
	
	private AppUtil appUtil = new AppUtil();
	private WebDriver driver;
	private Properties prop = new Properties();
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) throws Exception {
		
		
		
		// Checking and launching browser...
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		appUtil.setWebDriver(driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		FileReader file = new FileReader("/Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/Browserstack/loginConfig.properties");
		prop.load(file);
		
		
		// getting login details..
		String url = prop.getProperty("url").toString();
		String []cred = prop.get("cred1").toString().split(":");
		
		
		// launching url..
		driver.get( url );
		appUtil.findElement(By.id("user_email_login"))
			.sendKeys( cred[0] );
		
		appUtil.findElement(By.id("user_password"))
			.sendKeys( cred[1] );
		
		appUtil.findElement(By.id("user_submit"))
			.click();
		
		Thread.sleep( 5000 );
		
	}
	
	@Test(testName="TC1: Generate and Verify Screenshots ")
	
	public void GenerateAndVerifyScreenshotsTest() throws Exception{
		
		// Goto screenshot page..
		driver.get(prop.getProperty("urlScreenshot").toString());
		
		// input Google.com in 
		appUtil.findElement(By.id("screenshots"))
			.clear();
		appUtil.findElement(By.id("screenshots"))
			.sendKeys( prop.get("inputURL1").toString() );
		
		
		try {
			// click cancel on default..
			appUtil.findElement(By.xpath("//span[@class='browser-count__reset']//img"))
				.click();
		} catch (Exception e) {
			System.out.println("------ No Default OS Selected in Page -------");
		}
			
		
		// Store the machine_os_name
		// "CategoryOS","Device Name" 
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Android", "Nexus 5 (v4.4)");
		map.put("Android", "Nexus 6 (v4.4)");
		map.put("Android", "Nexus 7 (v4.4)");
		
		// Below method call will select above given OS / Devices and return the count of actually clicked 
		int countActualClickedOS = appUtil.selectDevices( map );
		
		int requestedOSName = map.size();
		
		// SoftAssert sAssert = new SoftAssert();
		// sAssert.assertEquals(requestedOSName, countActualClickedOS, "Failed to click all the requested OS");
		
		
		// Click Generate..
		// Wait for the reports to be generated..

		// sAssert.assertAll();
		
	}
	
	
	
	@AfterTest
	public void cleanUp() {
		
		// Todo: logout steps..

		// driver quiting.. 
		driver.close();
		driver.quit();
	}
	
}
