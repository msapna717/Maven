import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutomaticScreenshoExtentReport {
	static WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "/Users/sapnamishra/Documents/WebDriver/geckodriver");
		driver = new FirefoxDriver();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/SampleHtmlReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("login test");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

		}
		driver.quit();
	}

	@Test
	public void loginTest() throws IOException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/SampleHtmlReport1.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest logger = extent.createTest("login test");
		logger.log(Status.INFO, "login to facebook");
		logger.log(Status.PASS, "Title verified");
		extent.flush();
		ExtentTest logger2 = extent.createTest("logoff test");
		logger2.log(Status.FAIL, "LogOff");
		logger2.fail("Failed because of some issue", MediaEntityBuilder
				.createScreenCaptureFromPath("/Users/sapnamishra/Desktop/Screenshot/extentFailScreenshot.png").build());
		logger2.pass("Failed because of some issue", MediaEntityBuilder
				.createScreenCaptureFromPath("/Users/sapnamishra/Desktop/Screenshot/extentFailScreenshot.png").build());
		extent.flush();

	}

}