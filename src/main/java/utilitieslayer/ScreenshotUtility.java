package utilitieslayer;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import baselayer.BaseClass;

public class ScreenshotUtility extends BaseClass {

    public static void captureScreenshot( String screenshotName) {

        try {
//            // Create the screenshots folder
//            Path screenshotDirectory = Paths.get("screenshots");
//            Files.createDirectories(screenshotDirectory);

        	TakesScreenshot ts = ((TakesScreenshot) driver);
        	
            // Capture the screenshot
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination file
            String destinationPath = "./Screenshot/" + screenshotName + ".png";
            
            File desFile = new File(destinationPath);

            // Save the screenshot
            FileHandler.copy(sourceFile, desFile);
            
           

        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }
    }
}