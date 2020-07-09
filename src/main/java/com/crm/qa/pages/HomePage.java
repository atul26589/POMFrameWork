package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//span[contains(text(),'Atul  Anand')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealsLink;
	

	//Initializing Page Objects
	
	public HomePage(){
	PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public Deals clickOnDealsLink(){
		contactsLink.click();
		return new Deals();
	}
	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	
}
