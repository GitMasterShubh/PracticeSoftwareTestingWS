package com.shubhamklogic.practice.selenium;

// Step 1: Import necessary Classes and Interfaces -
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

// Step 2 - Created a Test Class -
public class CheckElementPresence {
	

	// Step 3 - Declaring the WebDriver reference variable -
	static WebDriver driver;
	

	// Step 4 - The main() method - 
	public static void main(String[] args) throws Exception {
		
		
		// Step 5 - Setting up the Chrome Browser Driver instance -
		// ToDo : Uncomment and set below path -
//		System.setProperty("webdriver.chrome.driver",
//				"/PathToDriver/chromedriver");
		
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--remote-allow-origins=*");
		
		// Created the ChromeDriver object -
		driver = new ChromeDriver(opts);
		
		
		// Step 6 - Open the web page
        driver.get("https://www.google.com");


        // Waiting for 5 seconds to let the web page load properly..
        Thread.sleep(5000);
        
        
        // Step 7 - Created 4 methods to Verify whether the element is present or not -
        verifyElementPresentWay1();
        verifyElementPresentWay2();
        verifyElementPresentWay3();
        verifyElementPresentWay4();

        
        // Step 8 - Close the browser driver object -
        driver.quit();
	}

	private static void verifyElementPresentWay1() {
		
		// Locate the Google Search button - 
        WebElement element = driver.findElement(By.name("btnK"));
        

        System.out.println("\n\n---- Method 1 : findElement() : ");
        // Check if the element is present -
        if (element != null) {
            System.out.println("Element is PRESENT on the page");
        } else {
            System.out.println("Element is NOT PRESENT on the page");
        }
		
	}
	
	private static void verifyElementPresentWay2() {
		
		// Locate the Google Search button - 
        List<WebElement> element = driver.findElements(By.name("btnK"));
        

        System.out.println("\n\n---- Method 2 : findElements() : ");
        // Check if the element is present -
        if (element != null & element.size() > 0 ) {
            System.out.println("Element is PRESENT on the page");
        } else {
            System.out.println("Element is NOT PRESENT on the page");
        }
	}
	
	private static void verifyElementPresentWay3() {
		
		// Creating the WebDriverWait Object with 5 seconds timeout duration - 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.ignoring(NoSuchElementException.class);
		
		// An expectation for checking that the given element is present on the DOM of a page -
		wait.until( ExpectedConditions.presenceOfElementLocated(By.name("btnK")) );
		
		
		// Getting the desired WebElement - 
		WebElement element = driver.findElement(By.name("btnK"));
		
		System.out.println("\n\n---- Method 3 : WebDriverWait : ");
		if (element != null) {
            System.out.println("Element is PRESENT on the page");
        } else {
            System.out.println("Element is NOT PRESENT on the page");
        }
	}


	private static void verifyElementPresentWay4() throws Exception {
		
		// Preparing the Javascript code to get the WebElement - 
		String javascript = "document.querySelector('input[name=\"btnK\"]');";  
		
		
		// Created the JavascriptExecutor instance -
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		
		
		// Executing the prepared JavaScript code using JavascriptExecutor -
		WebElement element = (WebElement) jsExecutor.executeScript(javascript);
		
		System.out.println("\n\n---- Method 4 : JavascriptExecutor : ");
		if (element != null ) {
            System.out.println("Element is PRESENT on the page");
        } else {
            System.out.println("Element is NOT PRESENT on the page");
        }
	}
}
