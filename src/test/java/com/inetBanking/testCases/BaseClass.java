package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.inetBanking.utlities.ReadConfig;


public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getBaseURL();
	public String userName= readConfig.getusername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	

	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("inewBankingProject");
		PropertyConfigurator.configure("log4j.properties");	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

	public boolean isAllertPreset() {
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public String genRandomAlphaNum() {
		String alphaNum = RandomStringUtils.randomAlphanumeric(5);
		return alphaNum;
	}
}
