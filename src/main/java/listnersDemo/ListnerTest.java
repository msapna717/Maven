package listnersDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listnersDemo.TestNGListners.class) // class level listner
public class ListnerTest {
	WebDriver driver;

	@Test(priority = 0)
	public void googleTitleVerify() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Title is " + driver.getTitle());
		driver.quit();
	}

	@Test(priority = 1)
	public void titleMatched() {
		Assert.assertTrue(false);
		System.out.println("title matched");
	}

}
