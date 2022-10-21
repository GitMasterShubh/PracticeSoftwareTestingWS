package com.shubhamklogic.practice.selenium;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class DriverMain {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// to setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		

	}

}
