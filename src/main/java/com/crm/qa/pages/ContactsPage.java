package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.Base;

public class ContactsPage extends Base{
	
	@FindBy(xpath="//div[text()='Contacts']")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBoxContacts;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveContactButton;
	

	public ContactsPage(){
		PageFactory.initElements(driver,this);
		}
	//method to verify Contacts Label
	public boolean verifyContactsLabel(){
		
		return contactsLabel.isDisplayed();
	}
	public void selectContactsCheckBox(){
		 checkBoxContacts.click();
	}
	
	public void clickNewContactButton(){
		newContact.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
		}

	
	
	public void createNewContatct(String fname,String lname){
		
		firstName.isDisplayed();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		saveContactButton.click();
		
	}
}
