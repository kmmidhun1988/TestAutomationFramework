package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	

	//Page Factory 
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupButton;
	
	@FindBy(xpath = "(//a[@class='brand-name'])[1]")
	WebElement brandName;
	
	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBrandNameImage() {
		return brandName.isDisplayed();
	}
	
	public LoginPage navigateToLogin () {
		loginButton.click();
		return new LoginPage();
	}

}
