package com.inetBanking.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportPractice {

	public static void main(String[] args) {


		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("TestReport.html");
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        
       	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.google.com");
        
        test.info("Message from information");
        test.pass("condition1 passed");
        test.pass("condition2 passed");
        extent.flush();
		
		
	}

}
