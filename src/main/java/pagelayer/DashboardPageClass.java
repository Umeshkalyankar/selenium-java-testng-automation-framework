package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageClass {

	private WebDriver driver;

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
	private WebElement TransactionsMenuOption;

	@FindBy(xpath = "//button[@data-testid='nav-logout']")
	private WebElement logoutButton;

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
		TransactionsMenuOption.click();
	}

	public void clickOnLogout() {
		logoutButton.click();
	}

	public boolean isDashboardDisplayed() {

	    System.out.println("========== DASHBOARD DIAGNOSTICS ==========");
	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page title: " + driver.getTitle());

	    System.out.println("Logout button count: "
	            + driver.findElements(By.cssSelector("[data-testid='nav-logout']")).size());

	    System.out.println("Send Money link count: "
	            + driver.findElements(By.cssSelector("[data-testid='nav-send']")).size());

	    System.out.println("Receive Money link count: "
	            + driver.findElements(By.cssSelector("[data-testid='nav-receive']")).size());

	    System.out.println("Dashboard body text:");
	    System.out.println(driver.findElement(By.tagName("body")).getText());

	    System.out.println("============================================");

	    return driver.getCurrentUrl().contains("/dashboard");
	}


}
