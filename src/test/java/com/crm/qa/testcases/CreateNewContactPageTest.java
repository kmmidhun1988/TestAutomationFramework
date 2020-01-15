package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyAccountPage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ContactsPage contactsPage;
	CreateNewContactPage createNewContactPage;

	public CreateNewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.navigateToLogin();
		myAccountPage = loginPage.clickOnLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = myAccountPage.clickOnContactsLink();
		createNewContactPage = contactsPage.clickOnNewContact();
	}
	
	@Test(dataProvider="getCrmTestData")
	public void validateCreateNewContactTest(String firstName, String lastName, String companyName, String emailId) throws InterruptedException {
		createNewContactPage.createNewContact(firstName, lastName, companyName, emailId);
	}
	
	@DataProvider
	public Object[][] getCrmTestData() {
		Object[][] data = TestUtil.getTestData("contacts");
		return data;		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
