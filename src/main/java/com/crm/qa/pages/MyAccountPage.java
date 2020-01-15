package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MyAccountPage extends TestBase {

	@FindBy(xpath = "//*[@class='trial-indicator']//parent::div/span[@class='user-display']")
	WebElement userNameDisplay;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserNameDisplay() {
		return userNameDisplay.getText().trim();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
}
