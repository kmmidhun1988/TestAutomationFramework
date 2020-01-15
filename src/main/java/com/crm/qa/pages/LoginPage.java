package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object REpository

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "(//div[contains(text(),'Login')])[1]")
	WebElement loginButton;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public MyAccountPage clickOnLogin( String name, String pwd) {
		email.sendKeys(name);
		password.sendKeys(pwd);
		loginButton.click();
		return new MyAccountPage();
	}

}
