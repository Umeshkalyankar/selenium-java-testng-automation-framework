package pagelayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceiveMoneyPageClass {

	private WebDriver driver;

	public ReceiveMoneyPageClass(WebDriver d) {
		driver = d;

		PageFactory.initElements(driver, this);
	}

	// Web Elements

	@FindBy(xpath = "//select[@data-testid='receive-from']")
	private WebElement senderDropDown;

	@FindBy(xpath = "//input[@data-testid='receive-amount']")
	private WebElement receivingPaymentAmountTextBox;

	@FindBy(xpath = "//input[@data-testid='receive-note']")
	private WebElement noteTextBox;

	@FindBy(xpath = "//button[@data-testid='receive-submit']")
	private WebElement receivePaymentButton;

	// Action

	public boolean isReceiveMoneyPageDisplayed() {
		return senderDropDown.isDisplayed();
	}

	public void selectSenderFromDropdown(String sender) {

		Select select = new Select(senderDropDown);
		select.selectByVisibleText(sender);
	}

	public void enterTheReceivingPaymentAmount(String amount) {
		receivingPaymentAmountTextBox.sendKeys(amount);
	}

	public void enterNoteMsg(String msg) {
		noteTextBox.sendKeys(msg);
	}

	public void clickOnReceivePaymentButton() {
		receivePaymentButton.click();
	}

	public String getSuccessMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='toast-success']")));

		return successMessage.getText().trim();

	}

}
