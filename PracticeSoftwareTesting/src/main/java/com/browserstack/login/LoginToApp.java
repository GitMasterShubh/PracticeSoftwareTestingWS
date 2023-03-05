package com.browserstack.login;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.browserstack.util.AppUtil;

public class LoginToApp {
	/*
	private WebDriver driver = new AppUtil().getWebDriver();
	
	public void login() {
		
		
		try {
			
			FileReader file = new FileReader("/Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/Browserstack/loginConfig.properties");
			Properties prop = new Properties();
			prop.load(file);
			
			
			// getting login details..
			String url = prop.getProperty("url").toString();
			String []cred = prop.get("cred1").toString().split(":");
			
			
			// launching url..
			driver.get( url );
			driver.findElement(By.id("user_email_login"))
				.sendKeys( cred[0] );
			
			driver.findElement(By.id("user_password"))
				.sendKeys( cred[1] );
			
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println("------- Exception in login -------"+ e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new LoginToApp().login();
	}
	*/
}
