package utilitieslayer;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baselayer.BaseClass;

public class ListenerSetup implements ITestListener {

	private static ExtentReports extentReports = ExtentReportManager.getReportInstance();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Execution started :- " + result.getName());

		ExtentTest test = extentReports.createTest(result.getName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Execution passed :- " + result.getName());

		if (extentTest.get() != null) {
			extentTest.get().pass("Test passed successfully");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Execution failed :- " + result.getName());

		if (extentTest.get() != null && result.getThrowable() != null) {
			System.out.println("Failure reason :- " + result.getThrowable().getMessage());

			extentTest.get().fail(result.getThrowable());
		}

		WebDriver driver = BaseClass.getDriver();

		if (driver != null) {

			String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());

			if (screenshotPath != null && extentTest.get() != null) {
				try {
					extentTest.get().addScreenCaptureFromPath(screenshotPath);
				} catch (Exception e) {
					System.out.println("Unable to attach screenshot to Extent Report: " + e.getMessage());
				}
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Execution skipped :- " + result.getName());

		if (extentTest.get() != null) {
			extentTest.get().skip("Test was skipped");
		}
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {

		extentReports.flush();
	}

}
