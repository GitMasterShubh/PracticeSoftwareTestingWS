package com.shubhamklogic.practice.selenium;

import org.openqa.selenium.WebDriver;

public class SeleniumHelperUtil {

//	private static Logger log = new Logger.getLogger(SeleniumHelperUtil.class);
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
		System.out.println(SeleniumHelperUtil.class.getName() + " : browsers =" + browsers + "\n"
				+ "browserDriverSetupMode" + browserDriverSetupMode);
		SeleniumHelperUtil.setBrowsers(browsers);

		// ToDo: property:value mechanism required..
		if (browserDriverSetupMode.equalsIgnoreCase("executableBrowserDrivers")) {

			// ToDo: property:value mechanism required..
			for (String browser : SeleniumHelperUtil.browsers) {

//				chrome browser
				if (browser.contains("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/chromedriver");
					System.out.println("*** chromedriver setup completed");

				}

//				firefox browser
				else if (browser.contains("firefox")) {
					System.setProperty("webdriver.gecko.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/geckodriver");
					System.out.println("*** geckodriver setup completed");

				}

//				safari browser
				else if (browser.contains("safari")) {
//					System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
					System.out.println("Safari Browser Driver setup is done now.\n"
							+ "If you are facing issues while launching Safari with Automation script, follow this wiki - https://www.browserstack.com/guide/run-selenium-tests-on-safari-using-safaridriver \n"
							+ "Go to Safari -> Preferences-> Advanced\n"
							+ "Tick mark the Checkbox with the label – 'Show Develop menu' in menu bar\n" + "\n"
							+ "Once done, go to the Develop menu and click on the 'Allow Remote Automation' option to enable it.\n"
							+ "Now create object of SafariBrowser to launch the Safari Browser");

					System.out.println("*** safaridriver setup completed");
				}

//				edge browser
				else if (browser.contains("edge")) {
					System.setProperty("webdriver.edge.driver",
							"/Users/ssrivastava/shubh-workspace/SoftwaresDownloaded/BrowserDrivers/edgedriver");
					System.out.println("*** edgedriver setup completed");
				}

				else {
					System.out.println("*** Warning - The Browser is not recognized for, browser=" + browser);
				}
			}

		} else if (browserDriverSetupMode.equalsIgnoreCase("webDriverManager")) {

		} else {

		}

	}

	private static void setBrowsers(String browsers) {
		SeleniumHelperUtil.browsers = browsers.split(",");
	}
	
	public static void log(String msg) {
		System.out.println("*** "+msg);
	}

}
