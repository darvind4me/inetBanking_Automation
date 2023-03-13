package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inetBanking.pageClasses.LoginPage;
import com.inetBanking.pageClasses.NewCustomerPage;
import com.inetBanking.utlities.ExcelHandlingTst;

public class TC_NewCustomerTest extends BaseClass {
	
	public String dataSheetLocaton = "./TestData/TestData.xlsx";
	ExcelHandlingTst excel = new ExcelHandlingTst();

//	@BeforeTest
//	public void loginFirst() 
//	{
//		driver.get(baseURL);
//		LoginPage lp =new LoginPage(driver);
//		
//		lp.setUsername(userName);
//		lp.setPassword(password);
//		lp.clickLoginButton();
//		if(isAllertPreset()== true) 
//		{
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
//		}
//		else
//		{
//			Assert.assertTrue(true);
//		}
//	}

	@Test
	public void addNewCustomer() {
		driver.get(baseURL);
		LoginPage lp =new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickLoginButton();
			if(isAllertPreset()==true) {
				if(driver.switchTo().alert().getText().equalsIgnoreCase("User or Password is not valid") == true) {
					logger.info("Login Failed for - " + userName);
					Assert.assertTrue(false);
				}
			}
			else{
				logger.info("Login pass for - " + userName);
			}
			
		
		NewCustomerPage ncp = new NewCustomerPage(driver);
		
		ncp.clickNewCustomerLink();
		
		if(isAllertPreset()== true) {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}else {
		ncp.setCustomerName("Arvind");
		ncp.setGender("FEMALE");
		ncp.setDOB("01", "12", "2001");
		ncp.setAddress("USA main road");
		ncp.setCityName("San Antonio");
		ncp.setStateName("Texas");
		ncp.setPin("123456");
		ncp.setMobileNo("1234567890");
		ncp.setEmail(genRandomAlphaNum() + "@gmail.com");
		ncp.setPassword("1234");
		ncp.clickSubmit();
		}
		
		if(isAllertPreset()== true) {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}else {
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("New Customer registred" );
		}
		else {
			Assert.assertTrue(false);
		}}
		
	}





}
