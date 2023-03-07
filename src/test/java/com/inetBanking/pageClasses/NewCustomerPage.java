package com.inetBanking.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  NewCustomerPage{
	
	WebDriver ldriver;
	public NewCustomerPage(WebDriver rdriver) 
	{			
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}

	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkNewCustomer;
	
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(xpath = "//input[@type= 'radio'][@value='m']")
	@CacheLookup
	WebElement rdbGenderMale;
	@FindBy(xpath = "//input[@type= 'radio'][@value='f']")
	@CacheLookup
	WebElement rdbGenderFemale;
	
	////input[@type= 'radio'][@value='m']

	@FindBy(id = "dob")
	@CacheLookup
	WebElement dtDOB;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtCustomerAddress;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCityName;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtStateName;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEMail;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement txtSubmit;

	@FindBy(name = "res")
	@CacheLookup
	WebElement txtReset;
	
	public void clickNewCustomerLink() {
		linkNewCustomer.click();		
	}
	
	public void setCustomerName(String cName) {
		txtCustomerName.sendKeys(cName);		
	}
	
	public void setGender(String gender) {
		
		//rdbGenderFemale.click();
		if(gender.equalsIgnoreCase("male")){
			rdbGenderMale.click();			
		}
		else {
			rdbGenderFemale.click();
		}
	}

	public void setDOB(String dd, String mm, String yyyy) {
		dtDOB.sendKeys(dd);
		dtDOB.sendKeys(mm);
		dtDOB.sendKeys(yyyy);
	}

	public void setAddress(String address) {
		txtCustomerAddress.sendKeys(address);		
	}

	public void setCityName(String city) {
		txtCityName.sendKeys(city);		
	}

	public void setStateName(String state) {
		txtStateName.sendKeys(state);		
	}

	public void setPin(String pin) {
		txtPinNo.sendKeys(pin);		
	}

	public void setMobileNo(String mobile) {
		txtMobileNumber.sendKeys(mobile);		
	}

	public void setEmail(String email) {
		txtEMail.sendKeys(email);		
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);		
	}

	public void clickSubmit() {
		txtSubmit.click();
	}

	public void clickReset() {
		txtReset.click();		
	}


}
