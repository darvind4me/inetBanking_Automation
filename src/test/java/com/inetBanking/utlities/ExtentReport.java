package com.inetBanking.utlities;

import org.testng.ITestContext;
import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	//ExtentReport ER ;//= new ExtentReport();
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	public void onStart(ITestResult tr) {
		System.out.println(System.getProperty("user.dir")+"TestReport.html");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"TestReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"expent-config.xml");
		extentReports = new ExtentReports();
	}
	
	public void onTestSuccess(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		System.out.println("TEST - PASS");
	}
	
	public void onTestFail(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		System.out.println("TEST - FAIL");
	}
	
	
	/*
	 * @BeforeClass public Object reportSetup1() { ExtentHtmlReporter htmlReporter =
	 * new ExtentHtmlReporter("TestReport1.html"); ExtentReports extent = new
	 * ExtentReports(); extent.attachReporter(htmlReporter); return extent; } public
	 * Object reportSetup2() { ExtentTest test = ((ExtentReports)
	 * ER.reportSetup1()).createTest("MyFirstTest", "Sample description");
	 * //test.info("Testing Started"); return test; }
	 * 
	 * public void onTestStart(ITestResult tr) { System.out.println("Test Started");
	 * ((ExtentTest) ER.reportSetup2()).info("Testing Started"); }
	 */
	
	/*
	 * public void onTestSuccess(ITestResult tr) { ((ExtentTest)
	 * ER.reportSetup2()).pass("Test-Pass"); System.out.println("Test Pass"); }
	 */

	
	/*
	 * public void onTestFailure(ITestResult tr) { ExtentTest test1 =
	 * ((ExtentReports) ER.reportSetup1()).createTest("MyFirstTest",
	 * "Sample description"); test1.fail("Failed");
	 * //((ExtentTest)ER.reportSetup2()).fail("Test-Failed");
	 * System.out.println("Test Failed"); }
	 */
	
	/*
	 * public void getResults(ITestResult result) {
	 * if(result.getStatus()==ITestResult.FAILURE) { ((ExtentTest)
	 * ER.reportSetup2()).log(Status.FAIL, result.getThrowable()); } }
	 */
	
	//@AfterClass
	public void onFinnish(ITestContext TC) {
		extentReports.flush();
	}
	
	

}
