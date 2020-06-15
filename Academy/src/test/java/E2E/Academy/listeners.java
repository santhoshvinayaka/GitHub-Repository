package E2E.Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportNG;
import Resources.base;

public class listeners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush(); 
	}

	
	public void onStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		test = extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		//code to capture screenshot
		extentTest.get().fail(arg0.getThrowable());
		WebDriver driver=null;
		String testCaseName = arg0.getMethod().getMethodName();
		
		try {
			driver = (WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {
			
		}
			
		
		try {
			extentTest.get().addScreenCaptureFromPath(screenShotPath(testCaseName , driver), arg0.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	
		
	

}
