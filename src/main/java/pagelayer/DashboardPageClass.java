package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPageClass {
	
private WebDriver driver;
	
	public DashboardPageClass(WebDriver d) {
		driver=d;
		
		PageFactory.initElements(driver, this);
	}
	
	// Web elements
	
	@FindBy(xpath="//a[@data-testid='nav-send']")
	private WebElement sendMoneyMenuOption;
	
	@FindBy(xpath="//a[@data-testid='nav-receive']")
	private WebElement receiveMoneyMenuOption;
	
	@FindBy(xpath="//a[@data-testid='nav-pay-qr']")
	private WebElement payWithQrMenuOption;
	
	@FindBy(xpath="//a[@data-testid='nav-transactions']")
	private WebElement TransactionsMenuOption;

	
	@FindBy(xpath="//button[@data-testid='nav-logout']")
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
		TransactionsMenuOption.click();	}
	
	public void clickOnLogout() {
		logoutButton.click();
	}
	
	public boolean isDashboardDisplayed() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        return wait.until(
	            ExpectedConditions.visibilityOf(logoutButton)
	        ).isDisplayed();

	    } catch (Exception e) {
	        return false;
	    }
	}

}
