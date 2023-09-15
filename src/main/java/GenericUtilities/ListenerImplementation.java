package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=====Test script execution started===");
	//create the test in extent report
		test=report.createTest(methodName);
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();	
		test.log(Status.PASS,methodName+"==========Pass==============");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility w = new WebDriverUtility();
		JavaUtility j = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		 String screenShotName = methodName+j.getSystemDate();
		
		 test.log(Status.FAIL, methodName+" ----- FAIL -----");
			test.log(Status.INFO, result.getThrowable());
		//System.out.println(result.getThrowable());
	//	System.out.println(methodName+"===========Fail===============");
	try {
		String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
		//attach the screenshot into the report 
		test.addScreenCaptureFromPath(path);
	
	
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
  
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();	
		test.log(Status.FAIL, methodName+" ----- SKIP -----");
		test.log(Status.INFO, result.getThrowable());

		
		//System.out.println();
		//System.out.println(methodNa me+"==========Skipped==========");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("===Suite execution started===");
		//configure extent reports
		ExtentSparkReporter htmlreport  = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
	    htmlreport.config().setDocumentTitle("VtigerExecution Report");
	    htmlreport.config().setReportName("Automation Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		 
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base Browser","edge");
		report.setSystemInfo("Base Url", "http://localhost:8888/index.php");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter name", "suman");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	  System.out.println("====suite execution finished===");
	//generate report after execution
	  report.flush();
	
	}

}
