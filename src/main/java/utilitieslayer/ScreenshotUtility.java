package utilitieslayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		if (driver == null) {
			System.out.println("Screenshot not captured: WebDriver is null.");
			return null;
		}

		try {
			// Generate a timestamp including milliseconds
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

			// Create the screenshot directory if it doesn't exist
			File screenshotDirectory = new File("Screenshot");

			if (!screenshotDirectory.exists()) {
				screenshotDirectory.mkdirs();
			}

			// Capture the screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);

			// Create the destination file
			File destinationFile = new File(screenshotDirectory, screenshotName + "_" + timestamp + ".png");

			// Save the screenshot
			FileHandler.copy(sourceFile, destinationFile);

			System.out.println("Screenshot saved: " + destinationFile.getAbsolutePath());

			// Return the absolute path for Extent Reports
			return destinationFile.getAbsolutePath();

		} catch (IOException e) {
			System.out.println("Unable to save screenshot: " + e.getMessage());
			return null;
		}
	}

}
