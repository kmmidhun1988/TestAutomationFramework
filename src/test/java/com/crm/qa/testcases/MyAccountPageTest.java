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

public class MyAccountPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ContactsPage contactsPage;
	
	Logger log = LogManager.getLogger(MyAccountPageTest.class.getName());

	public MyAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*************** Starting Before Method of MyAccountPageTest ***************");
		initialization();
		homePage = new HomePage();
		loginPage = homePage.navigateToLogin();
		myAccountPage = loginPage.clickOnLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("*************** Completed Before Method of MyAccountPageTest ***************");
	}

	@Test(priority = 1)
	public void validateMyAccountPageTitleTest() {
		log.debug("*************** Starting validateMyAccountPageTitleTest  ***************");
		String pageTitle = myAccountPage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Cogmento CRM", "My Account page title not matching");
		log.debug("*************** Completed validateMyAccountPageTitleTest  ***************");
	}

	@Test(priority = 2)
	public void validateUserNameDisplayTest() {
		log.debug("*************** Starting validateUserNameDisplayTest  ***************");
		String displayName = myAccountPage.verifyUserNameDisplay();
		Assert.assertEquals(displayName, prop.getProperty("name"), "Display name in my account page is NOT matching");
		log.debug("*************** Completed validateUserNameDisplayTest  ***************");
	}

	@Test(priority = 3)
	public void validateContactsLinkTest() throws InterruptedException {
		log.debug("*************** Starting validateContactsLinkTest  ***************");
		contactsPage = myAccountPage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
		log.debug("*************** Completed validateContactsLinkTest  ***************");
	}

	@AfterMethod
	public void tearDown() {
		log.info("*************** Closing the browser instance  ***************");
		driver.quit();
	}

}
