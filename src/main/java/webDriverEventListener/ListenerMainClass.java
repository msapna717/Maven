package webDriverEventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		EventCapture eCapture = new EventCapture();
		// Registering with EventFiringWebDriver
		// Register method allows to register our implementation of
		// WebDriverEventListner to listen to the WebDriver events
		eventHandler.register(eCapture);
		// navigating to the webpage "www.softwaretestingmaterial.com"
		eventHandler.navigate().to("https://www.softwaretestingmaterial.com/100-software-testing-interview-questions/");
		eventHandler.findElement(By.xpath("//span[@itemprop='name'  and contains(text(),'Blog')]")).click();
		// navigating to the webpage
		// "www.softwaretestingmaterial.com"
		eventHandler.navigate().to("https://www.softwaretestingmaterial.com/agile-testing-interview-questions/");
		// navigating back to the first page
		eventHandler.navigate().back();
		eventHandler.quit();
		// Unregister allows to detach
		eventHandler.unregister(eCapture);
		System.out.println("End of Listners Class");
	}
}
