package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	@Test
	public void besicReport()
	{
		//Create spark reporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/sampleReport.html");
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("Rutuja");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report = new ExtentReports();
		report.setSystemInfo("Operating System", "Windows_10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Type of Testing", "Functional");
		report.attachReporter(spark);
		ExtentTest test = report.createTest("sampleReport");
		test.log(Status.INFO,"Report is created");
		report.flush();
	}

}
