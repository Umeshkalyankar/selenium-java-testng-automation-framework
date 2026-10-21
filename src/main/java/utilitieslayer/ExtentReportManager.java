package utilitieslayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extentReports;

	public static ExtentReports getReportInstance() {

		if (extentReports == null) {

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Selenium Test Execution Report");
			sparkReporter.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");

			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);

			extentReports.setSystemInfo("Automation Tool", "Selenium WebDriver");
			extentReports.setSystemInfo("Test Framework", "TestNG");
			extentReports.setSystemInfo("Programming Language", "Java");
		}

		return extentReports;
	}

}
