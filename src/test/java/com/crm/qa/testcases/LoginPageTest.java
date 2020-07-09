package com.crm.qa.testcases;

import org.testng.annotations.*;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage =new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTiltleTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
