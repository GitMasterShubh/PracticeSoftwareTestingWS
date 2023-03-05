package com.shubhamklogic.practice.selenium;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * SeleniumHelperUtil is a Utility class.
 * Make use of its static methods by ClassName.MethodName()
 */
public class SeleniumHelperUtil {
	
	SeleniumHelperUtil(){
		// Utility Class-
	}

	public static WebDriver driver;
	public static String[] browsers;

	/**
	 * @param browsers               The Parameter browsers- Takes values from
	 *                               testng.xml files, values can be like
	 *                               browsers="chrome" OR
	 *                               browsers="chrome,safari,firefox"
	 * @param browserDriverSetupMode The Parameter browserDriverSetupMode- Takes
	 *                               values from testng.xml files, values can be
	 *                               like, "executableBrowserDrivers" OR
	 *                               "webDriverManager"
	 * 
	 *                               This method is does the setup related things,
	 *                               such as- At Which browsers, the application
	 *                               will be tested? Using which technique, the
	 *                               browser driver setup will be done.
	 *                               (webdrivermanager, environmental path or
	 *                               system.setProperty)
	 * 
	 */
	public static void setup(String browsers, String browserDriverSetupMode) {
		log(SeleniumHelperUtil.class.getName() + " :\nbrowsers =" + browsers + "\n"
				+ "browserDriverSetupMode=" + browserDriverSetupMode);
		SeleniumHelperUtil.setBrowsers(browsers);

		if (browserDriverSetupMode.equalsIgnoreCase("executableBrowserDrivers")) {

			for (String browser : SeleniumHelperUtil.browsers) {

				// chrome browser
				if (browser.contains("chrome")) {
					log("setting chromedriver...");
					System.setProperty("webdriver.chrome.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/chromedriver");
					
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("start-maximized"); 			// open Browser in maximized mode
					chromeOptions.addArguments("disable-infobars"); 		// disabling infobars
					chromeOptions.addArguments("--ignore-certificate-errors");
					chromeOptions.setAcceptInsecureCerts(true);				// AcceptInsecureCerts 
					
					driver = new ChromeDriver(chromeOptions);
					setDriver(driver);
					log("chromedriver setup completed");

				}

				// firefox browser
				else if (browser.contains("firefox")) {
					System.setProperty("webdriver.gecko.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/geckodriver");
					
					driver = new FirefoxDriver();
					setDriver(driver);
					log("*** geckodriver has set the Firefox driver..");

				}

					// safari browser
				else if (browser.contains("safari")) {
					// System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
					log("Safari Browser Driver setup is done now.\n"
							+ "If you are facing issues while launching Safari with Automation script, follow this wiki - https://www.browserstack.com/guide/run-selenium-tests-on-safari-using-safaridriver \n"
							+ "Go to Safari -> Preferences-> Advanced\n"
							+ "Tick mark the Checkbox with the label – 'Show Develop menu' in menu bar\n" + "\n"
							+ "Once done, go to the Develop menu and click on the 'Allow Remote Automation' option to enable it.\n"
							+ "Now create object of SafariBrowser to launch the Safari Browser");

					log("*** safaridriver setup completed");
				}

				// edge browser
				else if (browser.contains("edge")) {
					System.setProperty("webdriver.edge.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/edgedriver");
					log("*** edgedriver setup completed");
				}

				else {
					log("*** Warning - The Browser is not recognized for, browser=" + browser);
				}
			}

		} else if (browserDriverSetupMode.equalsIgnoreCase("webDriverManager")) {
			
			for (String browser : SeleniumHelperUtil.browsers) {

				// chrome browser
				if (browser.contains("chrome")) {
					WebDriverManager.chromedriver().setup();				// WebDriverManager setup for chrome browser
					
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("start-maximized"); 			// open Browser in maximized mode
					chromeOptions.addArguments("disable-infobars"); 		// disabling infobars
					chromeOptions.addArguments("--ignore-certificate-errors");
					chromeOptions.setAcceptInsecureCerts(true);				// AcceptInsecureCerts 
					
					
					driver = new ChromeDriver(chromeOptions);
					setDriver(driver);										// Created ChromeDriver
					break;
					
				}	else if (browser.contains("firefox")) {
						WebDriverManager.firefoxdriver().setup();			// WebDriverManager setup for Firefox
						setDriver(new FirefoxDriver());						// Created FirefoxDriver
					
				}
			}
			
		} else {

		}
	}

	static void setDriver(WebDriver driver) {
		SeleniumHelperUtil.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	private static void setBrowsers(String browsers) {
		SeleniumHelperUtil.browsers = browsers.split(",");
	}
	
	public static void log(String msg) {
		System.out.println("*** "+msg);
	}
	
	public static void log(String msg, Object[] inputList) {
		
		System.out.print(msg);
		
		for( Object s: inputList) 
			System.out.print(s+", ");
		
	}
	
	public static void log(String msg, String separator, Object[] inputList) {
		
		System.out.print(msg);
		
		for( Object s: inputList) 
			System.out.print(s + separator);
		
	}

	/**
	 * Custom JS function.. 
	 * To perform Drag and Drop using Selenium JavascriptExecuter and below JS Code.
	 * @return Returns Custom JS Drag and Drop function as String.
	 */
	public static String getJSDragAndDropCode() {
		
		return "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
				+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
				+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
				+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n"
				+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);";
	}
	
	/**
	 * 
	 * @param locator
	 * @param timeoutSeconds
	 * @param driver
	 * @return 'searchedElement'
	 * 
	 *  ||	About this method :
	 * 		As per the given locator (xpath, id, classname, etc.),
	 * 		This method searches for an element / group of elements, until the given timeoutSeconds expires.
	 * 
	 */
	public static WebElement getElementOnceClickable(By locator, long timeoutSeconds, WebDriver driver) {
		WebElement searchedElement = null;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		
		searchedElement = wait.ignoring(NoSuchElementException.class)
							.until(ExpectedConditions.elementToBeClickable(locator));
		
		return searchedElement;
	}

	
	/**
	 * 
	 * @param locator
	 * @param timeoutSeconds
	 * @param driver
	 * 
	 * 
	 */
	public static List<WebElement> getDropDrowOptionOnceSelectable(By locator, long timeoutSeconds, WebDriver driver) {
		List<WebElement> listElements = null;
		
		// pass params : Driver and Duration (Timeout)
		WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds(timeoutSeconds));
		
		listElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		return listElements;
	}

	public static void createBorderAroundWebElement(String colourHex, WebElement element) {
		
		JavascriptExecutor jsRunner = (JavascriptExecutor) driver;
		jsRunner.executeScript("arguments[0].style.border='5px solid "+colourHex+"'", element);
		
	}
	
	public static void takeAndSaveScreenshot(String ssFinalFilePath) throws Exception {
		
		File srcSSFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(
			srcSSFile,
			new File(ssFinalFilePath)		// targetSSFile
		);
		
		log("Screenshot has been taken, and file has been saved. Refresh directory and check the screenshot file at location="+ssFinalFilePath);
		
	}

	public static void log(String string, String itemSeperator) {
		
		
		String [] arrItems = string.split(itemSeperator);
		System.out.println("*** INFO: Splitted given String into =>"+ arrItems.length +"<= items with given seperator=>"+ itemSeperator+"<=");
		
		for( String item : arrItems)
			System.out.println(item + itemSeperator);
		
	}
}
