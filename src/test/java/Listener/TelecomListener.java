package Listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Utilities.ExtentReportsSample;



public class TelecomListener implements ITestListener {

//	ExtentTest test;
//	ExtentReports extent;
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TelecomListener.driver = driver;
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started " + result.getName());
		ExtentReportsSample.createReport(result.getMethod().getMethodName(), result.getName());
//		test = extent.createTest(result.getMethod().getMethodName(), result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Success of test cases and its details are : " + result.getName());
		ExtentReportsSample.takeScreenShotWithExtentReport(driver, Status.PASS);
//		try {
//			test.addScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).log(Status.PASS, "Pass : ",
//					MediaEntityBuilder.createScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).build());
//		} catch (Exception e) {
//			System.out.println("Error message : " + e.getMessage());
//		}
//
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failure of test cases and its details are : " + result.getName());
		ExtentReportsSample.takeScreenShotWithExtentReport(driver, Status.FAIL);
//		try {
//			test.addScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).log(Status.FAIL, "Fail : ",
//					MediaEntityBuilder.createScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).build());
//		} catch (Exception e) {
//			System.out.println("Error message : " + e.getMessage());
//		}
//		System.out.println("Test failed : " + result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("Failure of test cases and its details are withinSuccess Percentage : " + result.getName());
	}

	public void onStart(ITestContext context) {
//		ExtentSparkReporter spark = new ExtentSparkReporter("./Spark.html");
//		extent = new ExtentReports();
//		extent.attachReporter(spark);
		ExtentReportsSample.extentReportSetUp();
		System.out.println("Test Started");
	}

	public void onFinish(ITestContext context) {

//		test = extent.createTest(context.getName());
//		try {
//			test.addScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).log(Status.PASS, "Finish : ",
//					MediaEntityBuilder.createScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).build());
//		} catch (Exception e) {
//			System.out.println("Error message : " + e.getMessage());
//		}

		System.out.println("test finished : " + context.getName());
		ExtentReportsSample.finishReport();
	//	extent.flush();
	}
}
