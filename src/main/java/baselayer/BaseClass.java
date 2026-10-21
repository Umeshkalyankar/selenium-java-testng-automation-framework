package baselayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pagelayer.DashboardPageClass;
import pagelayer.PayWithQRPageClass;
import pagelayer.ReceiveMoneyPageClass;
import pagelayer.SendMoneyPageClass;
import pagelayer.SignInPageClass;
import pagelayer.SignUpPageClass;
import pagelayer.TransactionsPageClass;
import utilitieslayer.ConfigReader;

public class BaseClass {
// Separate WebDriver for each execution thread
	private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driverThread.get();
	}

// Page object declarations
	public SignInPageClass SignInPageClass_obj;
	public SignUpPageClass SignUpPageClass_obj;
	public DashboardPageClass DashboardPageClass_obj;
	public SendMoneyPageClass SendMoneyPageClass_obj;
	public ReceiveMoneyPageClass ReceiveMoneyPageClass_obj;
	public PayWithQRPageClass PayWithQRPageClass_obj;
	public TransactionsPageClass TransactionsPageClass_obj;

// Browser setup
	@BeforeMethod(alwaysRun = true)
	public void setup() {

		System.out.println("========== BaseClass setup started ==========");

		String browserName = ConfigReader.getProperty("browser");
		WebDriver driver;

		if (browserName.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();

			if (System.getenv("GITHUB_ACTIONS") != null) {
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
			}

			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driverThread.set(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(ConfigReader.getProperty("url"));

		// Initialize page objects using this thread's driver
		SignInPageClass_obj = new SignInPageClass(driver);
		SignUpPageClass_obj = new SignUpPageClass(driver);
		DashboardPageClass_obj = new DashboardPageClass(driver);
		SendMoneyPageClass_obj = new SendMoneyPageClass(driver);
		ReceiveMoneyPageClass_obj = new ReceiveMoneyPageClass(driver);
		PayWithQRPageClass_obj = new PayWithQRPageClass(driver);
		TransactionsPageClass_obj = new TransactionsPageClass(driver);
	}

// Reusable login method
	public void loginToApplication() {

		String email = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("password");

		SignInPageClass_obj.enterEmailAddress(email);
		SignInPageClass_obj.enterPassword(password);
		SignInPageClass_obj.clickOnSignInSecurely();
	}

// Browser teardown
	@AfterMethod(alwaysRun = true)
	public void teardown() {

		WebDriver driver = getDriver();

		try {
			if (driver != null) {
				driver.quit();
			}
		} finally {
			driverThread.remove();
		}
	}

}
