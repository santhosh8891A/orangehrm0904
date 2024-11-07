package com.orangehrm.app.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.app.pageObjects.LoginPage;
import com.orangehrm.app.pageObjects.MyInfoPage;

import junit.framework.Assert;

public class LoginTest extends Baseclass {
	
	@Test(priority=-1)
	public void logintest() throws IOException, InterruptedException {
		
		test=extent.createTest("Login page Title Validation");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(userName, password);
		logger.info("Provided UserName,Password and loggedinto the application");
		test.pass("Provided UserName,Password and loggedinto the application");
		
		String testCase="TitleValidation";
		String expectedTitle=driver.getTitle();
		
		if(actualTitle.contentEquals(expectedTitle))
		{
			logger.info("Application Title Matched");
			test.pass("Application Title Matched");
		}
		else
		{
			logger.error("Application Title not Matched");
			Thread.sleep(5000);
			String screenshotpath=webdriverutils.captureScreen(driver, testCase);
			
			test.fail("Application Title not Matched"+test.addScreenCaptureFromPath(screenshotpath));
			
		}
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	
	@Test
	public void validateDisplayofDefaultPage() throws InterruptedException, IOException
	{
		test=extent.createTest("Validate Display of Default Page");
		MyInfoPage myinfo=new MyInfoPage(driver);
		boolean displayStatus=myinfo.validateDisplayofMyinfoPage();
		logger.info("Provided UserName,Password and loggedinto the application");
		test.pass("Provided UserName,Password and loggedinto the application");
		String testCase="Dispaly of Default";
		if(displayStatus)
		{
			logger.info("Application displayed default page");
			test.pass("Application displayed default page");
		}
		else
		{
			logger.error("Application not displayed default page");
			Thread.sleep(5000);
			String screenshotpath=webdriverutils.captureScreen(driver, testCase);
			
			test.fail("Application not displayed default page"+test.addScreenCaptureFromPath(screenshotpath));
			
		}
		
	}
	

}
