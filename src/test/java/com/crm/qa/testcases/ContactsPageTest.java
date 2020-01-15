package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyAccountPage;

public class ContactsPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ContactsPage contactsPage;
	
	Logger log = LogManager.getLogger(ContactsPageTest.class.getName());

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		log.debug("*************** Starting Before Method of ContactsPageTest ***************");
		initialization();
		homePage = new HomePage();
		loginPage = homePage.navigateToLogin();
		myAccountPage = loginPage.clickOnLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = myAccountPage.clickOnContactsLink();
		Thread.sleep(2000);
		log.debug("*************** Completed Before Method of ContactsPageTest ***************");
	}

	@Test(priority = 1)
	public void verifyContactsLabelTextTest() {
		log.debug("*************** Starting verifyContactsLabelTextTest  ***************");
		String labelName = contactsPage.verifyContactsLabelText();
		Assert.assertEquals(labelName, "Contacts");
		log.debug("*************** Completed verifyContactsLabelTextTest  ***************");
	}

	@Test(priority = 2)
	public void selectContactByNameTest() throws Exception {
		log.debug("*************** Starting selectContactByNameTest  ***************");
		contactsPage.selectContactByName("Test1 Test1");
		log.debug("*************** Completed selectContactByNameTest  ***************");
	}

	@AfterMethod
	public void tearDown() {
		log.info("*************** Closing the browser instance  ***************");
		driver.quit();
	}
}
