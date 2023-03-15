package com.generalstore.Testutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.generalstore.utilities.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener{
	ExtentTest test;
	AppiumDriver driver;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	
	@Override
	 public void onTestStart(ITestResult result) {
	 test = extent.createTest(result.getMethod().getMethodName());
		   
		  }

	@Override 
	 public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
			 
		}

	@Override 
	 public void onTestFailure(ITestResult result) {
	    test.fail(result.getThrowable());	
	    
	    try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    try {
			test.addScreenCaptureFromPath(getScreenshotPath(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		    }

	@Override 
	 public void onTestSkipped(ITestResult result) {
		    
		  }

	@Override  
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    
		  }

	@Override
	 public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

	@Override 
	 public void onStart(ITestContext context) {
		    
		  }

	@Override 
	 public void onFinish(ITestContext context) {
		extent.flush();
		  }

}
