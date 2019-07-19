package extentReportEmail;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MailReportClass {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		System.out.println("-----Application Launched------");
	}

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports("./Reports/TestReport.html");
		// extent.addSystemInfo("Environment","Environment Name")
		// extent.addSystemInfo("Host Name",
		// "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
		// .addSystemInfo("User Name", "QA");
		// loading the external xml file (i.e., extent-config.xml) which was placed
		extent.loadConfig(
				new File("/Users/sapnamishra/eclipse-workspace/MavenTest/src/main/java/library/extent-config.xml"));
	}

	@Test(priority = 1)
	public void passTest() {
		// extent.startTest("TestCaseName", "Description")
		// TestCaseName – Name of the test
		// Description – Description of the test
		// Starting test
		logger = extent.startTest("passTest");
		AssertJUnit.assertTrue(true);
		// To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}

	@Test(priority = 2)
	public void failTest() {
		logger = extent.startTest("failTest");
		AssertJUnit.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}

	@Test(priority = 3)
	public void skipTest() {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		// ending test
		// endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		// writing everything to document
		// flush() - to write or update test information to your report.
		extent.flush();
		// Call close() at the very end of your session to clear all resources.
		// If any of your test ended abruptly causing any side-affects (not all logs
		// sent to ExtentReports, information missing), this method will ensure that the
		// test is still appended to the report with a warning message.
		// You should call close() only once, at the very end (in @AfterSuite for
		// example) as it closes the underlying stream.
		// Once this method is called, calling any Extent method will throw an error.
		// close() - To close all the operation
		extent.close();

	}

}
