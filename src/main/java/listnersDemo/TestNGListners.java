package listnersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase started and Testcase details are:  " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase success hurray and Testcase details are:  " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase failed and Testcase details are:  " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase skipped and Testcase details are:  " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(
				"Testcase Failed But Within Success Percentage and Testcase details are:  " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
