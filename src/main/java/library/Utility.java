package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;// TakesScreenshot is interface so we cannot create object of
			// it. hence we are doing typecasting to get the object
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/" + screenshotName + ".png");
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Exceptioon while taking screenshot: " + e.getMessage());
		}
	}
}
