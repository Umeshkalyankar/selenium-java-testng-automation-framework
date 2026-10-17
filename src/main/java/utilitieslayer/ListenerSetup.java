package utilitieslayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Execution started :- " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Execution passed :- " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Execution failed :- " + result.getName());
		ScreenshotUtility.captureScreenshot(result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Execution skipped :- " + result.getName());
	}

}
