package com.crm.qa.pages;

import org.openqa.selenium.By;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase {

	By firstName = By.name("first_name");
	By lastName = By.name("last_name");
	By company = By.xpath("(//input[@class='search'])[1]");
	By email = By.xpath("(//input[@name='value' and @type='text'])[1]");
	By saveBtn = By.xpath("//button[text()='Save']");

	public void createNewContact(String ftName, String ltName, String comp, String mailId) throws InterruptedException {
		driver.findElement(firstName).sendKeys(ftName);
		Thread.sleep(3000);
		driver.findElement(lastName).sendKeys(ltName);
		Thread.sleep(3000);
		driver.findElement(company).sendKeys(comp);
		Thread.sleep(3000);
		driver.findElement(email).sendKeys(mailId);
		Thread.sleep(3000);
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);
	}

}
