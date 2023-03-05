package com.browserstack.presetup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.browserstack.util.AppUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author ssrivastava Contains Browser Driver info.
 */

public class PreSetup {

	/*
	private AppUtil appUtil;

	public void doSetup(String browser) {

		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			appUtil.setWebDriver(new ChromeDriver());
		}
		if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			appUtil.setWebDriver(new FirefoxDriver());
		}
		appUtil.getWebDriver().manage().window().maximize();
		appUtil.getWebDriver().manage().deleteAllCookies();

	}
	*/
}
