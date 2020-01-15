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

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	
	Logger log = LogManager.getLogger(HomePageTest.class.getName());

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*************** Starting Before Method of HomePageTest ***************");
		initialization();
		homePage = new HomePage();
		log.debug("*************** Completed Before Method of HomePageTest ***************");
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		log.debug("*************** Starting homePageTitleTest  ***************");
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		log.debug("*************** Completed homePageTitleTest  ***************");
	}

	@Test(priority = 2)
	public void homePageLogoTest() {
		log.debug("*************** Starting homePageLogoTest  ***************");
		boolean flag = homePage.validateBrandNameImage();
		Assert.assertTrue(flag);
		log.debug("*************** Completed homePageLogoTest  ***************");
	}

	@Test(priority = 3)
	public void loginTest() {
		log.debug("*************** Starting loginTest  ***************");
		loginPage = homePage.navigateToLogin();
		log.debug("*************** Completed loginTest  ***************");
	}

	@AfterMethod
	public void tearDown() {
		log.info("*************** Closing the browser instance  ***************");
		driver.quit();
	}

}
