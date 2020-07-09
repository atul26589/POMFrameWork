package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage =new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","HomePage title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void clickContactsLinkTest(){
		contactsPage=homePage.clickOnContactsLink();
	}
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

	
	
}
