package baselayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pagelayer.DashboardPageClass;
import pagelayer.ReceiveMoneyPageClass;
import pagelayer.SendMoneyPageClass;
import pagelayer.SignInPageClass;
import pagelayer.SignUpPageClass;

public class BaseClass {
	
	public  WebDriver driver;
	public SignInPageClass SignInPageClass_obj;
	public SignUpPageClass SignUpPageClass_obj;
	public DashboardPageClass DashboardPageClass_obj;
	public SendMoneyPageClass SendMoneyPageClass_obj;
	public ReceiveMoneyPageClass ReceiveMoneyPageClass_obj;
	
	@BeforeMethod
	public void setup() {
		String browser_name = "Chrome";
		
		if(browser_name.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Provide valid browser name");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://app.thetestingacademy.com/playwright/tta-bank/");
		
		//Object creation
		SignInPageClass_obj = new SignInPageClass(driver);
		SignUpPageClass_obj = new SignUpPageClass(driver);
		DashboardPageClass_obj = new DashboardPageClass(driver);
		SendMoneyPageClass_obj = new SendMoneyPageClass(driver);
		ReceiveMoneyPageClass_obj = new ReceiveMoneyPageClass(driver);
	}
	
	@AfterMethod
	public void teardown() {
		if (driver != null) {
            driver.quit();
        }
	}

}
