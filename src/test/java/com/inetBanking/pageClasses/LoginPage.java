package com.inetBanking.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) 
	{			
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement LoginButton;
	
	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement ResetButton;	
	
	public void setUsername(String uName) {
		txtUserName.sendKeys(uName);		
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);		
	}
	public void clickLoginButton() {
		LoginButton.click();
	}
	public void clickResetButton() {
		ResetButton.click();		
	}

	
}
