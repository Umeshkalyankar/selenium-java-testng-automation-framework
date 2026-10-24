package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPageClass {

	private WebDriver driver;

	public TransactionsPageClass(WebDriver d) {
		driver = d;

		PageFactory.initElements(driver, this);
	}

	// Web Elements
	@FindBy(xpath = "//input[@data-testid='tx-search']")
	private WebElement searchPartyTextBox;
	
	@FindBy(xpath="//button[@data-testid='account-reset']")
	private WebElement resetAccountButton;

	// Actions

	public boolean isTransactionsPageDisplayed() {
		return searchPartyTextBox.isDisplayed();
	}

	public void enterPartyName(String partyName) {
		searchPartyTextBox.sendKeys(partyName);
	}
	
	public void resetAccount() {
		resetAccountButton.click();
	}

}
