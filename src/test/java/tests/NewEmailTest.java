package tests;

import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewEmailTest {
	@Test
	public void myTest() {
		int a = 10;
		int b = 80;
		Assert.assertEquals(a, b);
		System.out.println("---Test done---");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("---test started---");
	}

	@AfterMethod
	public void afterClass(ITestResult result) throws EmailException {
		if (result.getStatus() == (ITestResult.FAILURE)) {
			SendEmailTest.sendMail();
			System.out.println("---test failed email sent----");

		}
	}

}
