package com.orangehrm.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	WebDriver ldriver;

	public MyInfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Personal Details']") WebElement personalDetailsLink;
	
	public boolean validateDisplayofMyinfoPage()
	{
		boolean pageDisplayyed=false;
		try {
			personalDetailsLink.isDisplayed();
			pageDisplayyed=true;
		}
		catch(Exception e)
		{
			System.out.println("Myinfo page is not displayed");	
		}
		return pageDisplayyed;
	}
	
}
