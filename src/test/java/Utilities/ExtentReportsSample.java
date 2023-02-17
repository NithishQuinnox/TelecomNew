package Utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsSample {

	static ExtentTest test;
	static ExtentReports extent;

	public static void extentReportSetUp() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	
	public static void takeScreenShotWithExtentReport(WebDriver driver, Status status) {
	//	test = extent.createTest(reportName, reportDescription);
		try {
			test.addScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).log(status, "Pass : ",
					MediaEntityBuilder.createScreenCaptureFromPath(Screenshots.captureScreenshot(driver)).build());
		} catch (Exception e) {
			System.out.println("Error message : " + e.getMessage());
		}

	}
	
	public static void createReport(String reportName, String reportDiscription) {
		test = extent.createTest(reportName, reportDiscription);
	}

	public static void finishReport() {
		extent.flush();
	}
}
