package library;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SendReport {
	// Creating ExtentReport and ExtentTest reference values
	ExtentReports report;
	ExtentTest logger;

	@Test
	public void sendReportTest() {

		// Create object for Report with filepath
		report = new ExtentReports("./Reports/TestReport.html");
		// loading the external xml file
		report.loadConfig(
				new File("/Users/sapnamishra/eclipse-workspace/MavenTest/src/main/java/library/extent-config.xml"));

		// Start the test
		logger = report.startTest("Method Name:sendReportTest");

		// Log the status in report
		logger.log(LogStatus.INFO, " started ");

		Assert.assertTrue(true);

		// Pass the test in report
		logger.log(LogStatus.PASS, "Test Verified");

		// End the test
		report.endTest(logger);

		// Flush the data to report
		report.flush();
	}
}