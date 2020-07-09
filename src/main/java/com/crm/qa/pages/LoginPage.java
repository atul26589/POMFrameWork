package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {
	//PageFactory-OR
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//div[text()='Login']")
		WebElement loginButton;
		
		@FindBy(xpath="//a[text()='Sign Up']")
			WebElement signUpButton;
		
		//Initializing Page Objects
		public LoginPage(){
			PageFactory.initElements(driver,this);
		}
		
		//Actions
		
		public String validateLoginPageTitle(){
			return driver.getTitle();
			
		}
		public HomePage login(String un,String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginButton.click();
			
			return new HomePage();
		}
		

}
