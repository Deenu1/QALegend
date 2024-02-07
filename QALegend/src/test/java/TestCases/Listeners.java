package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationCore.BaseClass;
import Utilities.ExtentReportNG;

public class Listeners extends BaseClass implements ITestListener
{

	 ExtentTest test;
	 ExtentReports extent = ExtentReportNG.getReportObject();
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	 @Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestStart(result);
			test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
			System.out.println("On test Start method");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSuccess(result);
			extentTest.get().log(Status.PASS, "TestCase Passed");
			System.out.println("On test Success method");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailure(result);
			extentTest.get().fail(result.getThrowable());
			String testMethodName = result.getMethod().getMethodName();
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			extentTest.get().log(Status.FAIL, "Testcase Failed");
			System.out.println("On test failure method");
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSkipped(result);
			extentTest.get().log(Status.SKIP, "Testcase skipped");
			System.out.println("On test Skipped method");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
			System.out.println("On test failwd within success percentage method");
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
			System.out.println("On test failed within Timeout method");
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
			System.out.println("On Start method");
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onFinish(context);
			extent.flush();//mandatory -to close extent class 
			System.out.println("On Finish");
		}

	

}
