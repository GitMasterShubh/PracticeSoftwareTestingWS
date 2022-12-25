package com.shubhamklogic.practice.testng;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name = "googleAuthDataProvider")
	public Object[] googleAuthDataProvider() {
		
		return new Object[] { "shubh@gmail.com" };
		
	}

}
