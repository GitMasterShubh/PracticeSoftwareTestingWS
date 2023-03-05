package com.browserstack.util;

import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AppUtil {
	
	private WebDriver driver;
	private final long timeout = 300;		// 300 sec. = 5 min.
	private final long pollingTime = 500;	// 0.5 Sec  = 500 milisec.
	
	public void setWebDriver( WebDriver d) {
		this.driver = d;
	}
	
	public WebElement findElement(By by) {

		// Using Smart wait (FluentWait) to find the WebElement ..
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		
		WebElement element = wait.until(
			ExpectedConditions.elementToBeClickable(by)
		);
		
		return element;
	}
	
//	public WebElement[] findElements(By by) {
//		
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(timeout));
//		wait.pollingEvery(Duration.ofMillis(pollingTime));
//		
//		WebElement[] element = wait.until(
//			ExpectedConditions.elementToBeClickable(by)
//		);
//		
//		return element;
//	}

	public int selectDevices(HashMap<String, String> map) {
		
		Set<String> osNames = map.keySet();
		Object []arrOSNames = osNames.toArray();
		
		Collection<String> osValues = map.values();
		
		// xpath of Windows =>  //div[@class='os-name']//span[text()='Windows']
		String osNameXpath = "//div[@class='os-name' and text()='"+ arrOSNames[0].toString() +"']";

		List<WebElement> osElements = driver.findElements( By.xpath(osNameXpath) );
		WebElement targetCategOS;
		for( WebElement e : osElements) {
			
			if( e.getText().equals( arrOSNames[0] ) ) {
				targetCategOS = e;
				break;
			}
		}
		
		// ToDo: 
		// Select the OS beside to targetCategOS WebElement -
		// xpath=> //div[@class='os-name']/following-sibling::ul
		
		return 0;
	}
}
