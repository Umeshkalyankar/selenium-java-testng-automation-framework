package pagelayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPageClass {

	private WebDriver driver;

	// Constructor
	public DashboardPageClass(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	// Web elements

	@FindBy(xpath = "//a[@data-testid='nav-send']")
	private WebElement sendMoneyMenuOption;

	@FindBy(xpath = "//a[@data-testid='nav-receive']")
	private WebElement receiveMoneyMenuOption;

	@FindBy(xpath = "//a[@data-testid='nav-pay-qr']")
	private WebElement payWithQrMenuOption;

	@FindBy(xpath = "//a[@data-testid='nav-transactions']")
	private WebElement transactionsMenuOption;

	@FindBy(xpath = "//button[@data-testid='nav-logout']")
	private WebElement logoutButton;

	// Verify dashboard page
	public boolean isDashboardDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			return wait.until(ExpectedConditions.titleIs("TTA Bank - Dashboard"));
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Expected Title: TTA Bank - Dashboard");
			System.out.println("Actual Title: " + driver.getTitle());
			System.out.println("Current URL: " + driver.getCurrentUrl());

			return false;
		}
	}
	// Actions

	public void clickOnSendMoneyOption() {
		sendMoneyMenuOption.click();
	}

	public void clickOnReceiveMoneyOption() {
		receiveMoneyMenuOption.click();
	}

	public void clickOnPayWithQrOption() {
		payWithQrMenuOption.click();
	}

	public void clickOnTransactionsOption() {
		transactionsMenuOption.click();
	}

	public void clickOnLogout() {
		logoutButton.click();
	}
}
