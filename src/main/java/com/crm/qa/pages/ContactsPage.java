package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[text()='New']")
	WebElement newContactBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public String verifyContactsLabelText() {
		return contactsLabel.getText();
	}

	public void selectContactByName(String name) throws InterruptedException {
		driver.navigate().refresh();
		WebElement element = driver.findElement(By.xpath("//td[text()='" + name + "']//parent::tr/td/div/input"));
		TestUtil.clickHiddenElement(element);
	}
	
	public CreateNewContactPage clickOnNewContact() {
		newContactBtn.click();
		return new CreateNewContactPage();
	}

}
