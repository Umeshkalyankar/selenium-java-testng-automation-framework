package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	    System.out.println("========== NAVIGATION VISIBILITY ==========");

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    String[] selectors = {
	        "[data-testid='nav-logout']",
	        "[data-testid='nav-send']",
	        "[data-testid='nav-receive']",
	        "[data-testid='nav-pay-qr']",
	        "[data-testid='nav-transactions']"
	    };

	    for (String selector : selectors) {

	        for (WebElement element : driver.findElements(By.cssSelector(selector))) {

	            System.out.println("Element: " + selector);
	            System.out.println("Displayed: " + element.isDisplayed());
	            System.out.println("Enabled: " + element.isEnabled());

	            System.out.println("CSS display: "
	                    + js.executeScript(
	                            "return window.getComputedStyle(arguments[0]).display;",
	                            element));

	            System.out.println("CSS visibility: "
	                    + js.executeScript(
	                            "return window.getComputedStyle(arguments[0]).visibility;",
	                            element));

	            System.out.println("CSS opacity: "
	                    + js.executeScript(
	                            "return window.getComputedStyle(arguments[0]).opacity;",
	                            element));

	            System.out.println("--------------------------------------------");
	        }
	    }

	    System.out.println("Viewport width: "
	            + js.executeScript("return window.innerWidth;"));

	    System.out.println("Viewport height: "
	            + js.executeScript("return window.innerHeight;"));

	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page title: " + driver.getTitle());

	    System.out.println("============================================");

	    return driver.getCurrentUrl().contains("/dashboard");
	}
	
}
