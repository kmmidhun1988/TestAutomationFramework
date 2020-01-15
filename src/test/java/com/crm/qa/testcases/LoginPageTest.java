package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*************** Starting Before Method of LoginPageTest ***************");
		initialization();
		homePage = new HomePage();
		homePage.navigateToLogin();
		loginPage = new LoginPage();
		log.debug("*************** Completed Before Method of LoginPageTest ***************");
	}

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {
		log.debug("*************** Starting validateLoginPageTitleTest  ***************");
		String pageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Cogmento CRM");
		log.debug("*************** Completed validateLoginPageTitleTest  ***************");
	}

	@Test(priority = 2)
	public void loginToMyaccountTest() {
		log.debug("*************** Starting loginToMyaccountTest  ***************");
		myAccountPage = loginPage.clickOnLogin(prop.getProperty("username"), prop.getProperty("password"));
		String displayName = myAccountPage.verifyUserNameDisplay();
		Assert.assertEquals(displayName, prop.getProperty("name"));
		log.debug("*************** Completed loginToMyaccountTest  ***************");
	}

	@AfterMethod
	public void tearDown() {
		log.info("*************** Closing the browser instance  ***************");
		driver.quit();
	}
}
