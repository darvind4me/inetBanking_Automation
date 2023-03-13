package com.inetBanking.testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.inetBanking.pageClasses.HomePage;
import com.inetBanking.pageClasses.LoginPage;
import com.inetBanking.utlities.ExcelHandlingTst;
//@Listeners(com.inetBanking.utlities.ExtentReport.class)

public class TC_LoginTest extends BaseClass{

	public String dataSheetLocaton = "./TestData/TestData.xlsx";
	ExcelHandlingTst excel = new ExcelHandlingTst();
	public int i;
	public int j;
	
//	@Test(dataProvider = "Logindata")
//	public void LoginTest(String UName, String Pass) {
//		driver.get(baseURL);
//		logger.info("URL \"--"+ baseURL +"-- \"is called");
//		
//		LoginPage lp =new LoginPage(driver);
//		
//		lp.setUsername(UName);
//		logger.info("Username is enterted");
//		lp.setPassword(Pass);
//		logger.info("Password i entered");
//		
//		//lp.clickLoginButton();
//		
//		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
//		{System.out.println("$$$$$$$$$$$$$$$$$$$$$$" + driver.getTitle());
//			AssertJUnit.assertTrue(true);
//		}
//		else
//		{System.out.println("$$$$$$$$$$$$$$$$$$$$$$ - Else" + driver.getTitle());
//			AssertJUnit.assertTrue(true);
//		}
//		}
//	
	
	
	
//	@Test
//	public void LoginTest() {
//		driver.get(baseURL);
//		logger.info("URL \"--"+ baseURL +"-- \"is called");
//		
//		LoginPage lp =new LoginPage(driver);
//		
//		lp.setUsername(userName);
//		logger.info("Username is enterted");
//		lp.setPassword(password);
//		logger.info("Password i entered");
//		
//		lp.clickLoginButton();
//		
//		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
//		{System.out.println("$$$$$$$$$$$$$$$$$$$$$$" + driver.getTitle());
//			AssertJUnit.assertTrue(true);
//		}
//		else
//		{System.out.println("$$$$$$$$$$$$$$$$$$$$$$ - Else" + driver.getTitle());
//			AssertJUnit.assertTrue(true);
//		}
//		}

	//Multiple iterations using data provider 
	@Test(dataProvider = "Logindata")
	public void loginTest(String uName, String pWord) throws IOException {
		
		System.out.println("i = " + i + " j = "+ j);
		
		driver.get(baseURL);
		LoginPage lp =new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.setUsername(uName);
		lp.setPassword(pWord);
		System.out.println("Before login : " + driver.getTitle());
		lp.clickLoginButton();
			if(isAllertPreset()== true) 
			{
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
				hp.clickLogout();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
//		System.out.println(driver.getTitle());
//		if("Guru99 Bank Manager HomePage".equals(driver.getTitle())) {
//			System.out.println("Pass");
//			Assert.assertTrue(false);
//			//excel.fillCellGreenColor(dataSheetLocaton, "LoginDetails", i, j);
//			excel.updateCellValue(dataSheetLocaton, "Sheet1", i-1, 2, "pass");
//		}else {
//			excel.updateCellValue(dataSheetLocaton, "Sheet1", i-1, 2, "Fail");
//			logger.info("Login Failed");
//			System.out.println("Fail");
//			Assert.assertTrue(false);
//			
//		}
	}
	
//	public boolean isAllertPreset() {
//		try
//		{
//			driver.switchTo().alert();
//			return true;
//		}
//		catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
	
	
//	@Test
//	public void testTesting() {
//		
//		if (1==2) {
//			Assert.assertTrue(true);
//			System.out.println("Asser True");
//		}else
//		{Assert.assertTrue(false);
//		System.out.println("Asser false");}
//	}
//	
	
	@DataProvider(name = "Logindata")
	public String[][] getData() throws IOException {
		
		//Hard coded data
		//String data[][] = {{"TestUser1", "TestPass1"},{"TestUser2", "TestPass2"},{"TestUser3", "TestPass3"}};
		
		//Read data from excel
		int rowCount = excel.getRowCount(dataSheetLocaton, "Sheet1");
		int collCount = excel.getCollCount(dataSheetLocaton, "Sheet1", 1);
		String loginData[][]=new String[rowCount][collCount];
		for(i=1;i<rowCount+1;i++) {
			for(j = 0; j<collCount; j++) {
				loginData[i-1][j] = excel.getCellData(dataSheetLocaton, "Sheet1", i, j);
			}
		}
		return loginData;
	}	
	
}









