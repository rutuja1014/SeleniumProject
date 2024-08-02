package com.crm.Listerners1;

import org.testng.ITestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.DWSScreenshot;

public class ScreenshotWithFailed extends DWSScreenshot implements ITestListener {
		ExtentSparkReporter spark;
		ExtentReports report;
		ExtentTest test;
		@Override
		public void onTestStart(ITestResult result) {
			String t_Name = result.getMethod().getMethodName();
			Reporter.log(t_Name+"is executed");
			test=report.createTest(t_Name);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String t_Name = result.getMethod().getMethodName();
			test.log(Status.PASS,t_Name+"is PASS");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String t_Name = result.getMethod().getMethodName();
			test.log(Status.FAIL,t_Name+"is FAIL");
			TakesScreenshot ts=(TakesScreenshot) driver;
			String screenshot=ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(screenshot);
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			String t_Name = result.getMethod().getMethodName();
			test.log(Status.SKIP,t_Name+"is Skipped");
		}

		@Override
		public void onStart(ITestContext context) {
		    spark = new ExtentSparkReporter("./Reports/Multiple.html");
			spark.config().setDocumentTitle("SampleReport");
			spark.config().setReportName("Rutuja");
			spark.config().setTheme(Theme.STANDARD);
			
			
		    report = new ExtentReports();
			report.setSystemInfo("Operating System", "Windows_125");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("Type of Testing", "Functional");
			report.attachReporter(spark);
		    test = report.createTest("sampleReport");
		}

		@Override
		public void onFinish(ITestContext context) {
			report.flush();
		}
	}
