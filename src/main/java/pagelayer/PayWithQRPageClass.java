package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayWithQRPageClass {

	private WebDriver driver;

	public PayWithQRPageClass(WebDriver d) {
		driver = d;

		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "//input[@data-testid='qr-amount']")
	private WebElement amountTextBox;

	@FindBy(xpath = "//select[@data-testid='qr-category']")
	private WebElement categoryDropdown;

	@FindBy(xpath = "//button[@data-testid='qr-mark-paid']")
	private WebElement markAsPaidButton;

	// Actions

	public boolean isPayWithQRPageDisplayed() {
		return amountTextBox.isDisplayed();
	}

	public void enterThePaymentAmount(String amount) {
		amountTextBox.sendKeys(amount);
	}

	public void selectCategory(String category) {
		Select select = new Select(categoryDropdown);
		select.selectByVisibleText(category);
	}

	public void clickOnMarkAsPaidButton() {
		markAsPaidButton.click();
	}

}
