package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage =new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	@Test(priority=1)
	public void contactsPageVerify(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = null;
		try {
			data = TestUtil.getTestData(sheetName);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createContact(String Firstname,String Lastname) throws InterruptedException{
		
		contactsPage.clickNewContactButton();
		//contactsPage.driver.wait(10);
		contactsPage.createNewContatct(Firstname, Lastname);
		
	}
	/*@Test(priority=2)
	public void selectContactsCheckBox(){
		contactsPage.selectContactsCheckBox();
	}*/

}
