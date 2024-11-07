package com.orangehrm.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "username")
	WebElement inputUserName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement inputPassword;
	@FindBy(xpath = "//*[text()=' Login ']")
	WebElement buttonSubmit;

	public void loginToApplication(String userName, String password) {
		inputUserName.sendKeys(userName);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
	}

}
