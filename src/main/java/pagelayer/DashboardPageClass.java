package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//button[@data-testid='nav-logout']")
	private WebElement logoutButton;
	
	// Actions
	
	public void clickOnSendMoneyOption() {
		sendMoneyMenuOption.click();
	}
	
	public void clickOnReceiveMoneyOption() {
		receiveMoneyMenuOption.click();
	}
	
	public void clickOnLogout() {
		logoutButton.click();
	}

}
