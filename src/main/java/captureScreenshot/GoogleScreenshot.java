package captureScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Utility;

public class GoogleScreenshot {
	public static WebDriver driver;

	@Test
	public void captureScreenshot() throws IOException {
		System.setProperty("webdriver.gecko.driver", "/Users/sapnamishra/Documents/WebDriver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("applicationLaunched");
		String actualTitle = driver.getTitle();
		driver.findElement(By.xpath("//input[@title='Searchhhh']")).sendKeys("Apple");

		String expectedTitle = "Google";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("TitleMatched");

		} else {
			System.out.println("Title not matched");
		}
	}

	@AfterMethod
	public static void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
