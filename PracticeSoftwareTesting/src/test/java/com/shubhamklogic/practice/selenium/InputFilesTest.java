package com.shubhamklogic.practice.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InputFilesTest {
	
	private WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browsers", "browserDriverSetupMode" })
	public void preSetup(String browsers, String browserDriverSetupMode) {

		// To setup the browser drivers and browsers to be called in future-
		SeleniumHelperUtil.log(
				"preSetup of browser drivers and browsers to be called in future. Browsers='"
				+ browsers + "', browserDriverSetupMode='"
																		+ browserDriverSetupMode + "'");
		SeleniumHelperUtil.setup(browsers, browserDriverSetupMode);
		driver = SeleniumHelperUtil.getDriver();
	}
	
	@Test(testName="Upload File Test", groups= {"selenium-basics", "current"})	
	public void uploadFileTest() {
		
		driver.get("https://codepen.io/ShubhamKLogic/full/LYrVvrX?editors=1010");
		
		driver.switchTo().frame("result");
		
		String userDir = System.getProperty("user.dir");
		String fileSep = File.separator;
		
		driver.findElement(By.id("file"))
			.sendKeys(userDir + fileSep + "/src/main/resources/AllMiscFiles/Sample_PDFfile.pdf");
		
		// Note:
		// 		As your OS (windows/Linux/MacOS), the values of userDir, fileSeparator and actual file path would be automatically calculated and upload the sample file present in this repository -:
		
		// 		userDir==/Users/shubhamklogic/eclipse-workspace/Practice/PracticeSoftwareTestingWS/PracticeSoftwareTesting
		// 		fileSep==/
		// 		Full File Path Sample_PDFfile.pdf==/Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/AllMiscFiles/Sample_PDFfile.pdf
		
		SeleniumHelperUtil.log("Sample_PDFfile.pdf has been uploaded successfully..");
	}
}
