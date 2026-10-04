package pagelayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SendMoneyPageClass {
	private WebDriver driver;
	public SendMoneyPageClass(WebDriver d) {
		driver=d;
		
		PageFactory.initElements(driver, this);
		
	}
	
	// WebElements
	@FindBy(xpath="//div[@data-testid='beneficiary-ben-101']")
	private WebElement beneficiaryOption;

	@FindBy(xpath="//input[@data-testid='send-amount']")
	private WebElement paymentAmountTextBox;
	
	@FindBy(xpath="//span[@data-testid='send-amount-error']")
	private WebElement paymentAmountErrorMsg;
	
	@FindBy(xpath="//select[@data-testid='send-category']")  // dropdown
	private WebElement categoryDropDown;
	
	@FindBy(xpath="//input[@data-testid='send-note']")
	private WebElement noteTextBox;
	
	@FindBy(xpath="//button[@data-testid='send-submit']")
	private WebElement reviewTransferButton;
	
	@FindBy(xpath="//button[@data-testid='confirm-send']")
	private WebElement confirmTransferPopup;
	
	@FindBy(xpath="//div[@data-testid='toast-success']")
	private WebElement successSnackbar;
	
	// Actions
	public void clickOnBeneficiaryName() {
		beneficiaryOption.click();
	}
	
	public void enterThePaymentAmount(String paymentamount) {
		paymentAmountTextBox.sendKeys(paymentamount);
	}
	
	public String getAmountErrorMessage() {
		return paymentAmountErrorMsg.getText();
	}
	
	
	public void selectCategory(String category) {    // dropdown
		Select select = new Select(categoryDropDown);
		select.selectByVisibleText(category);
	}
	
	public void enterNoteMsg(String notemsg) {
		noteTextBox.sendKeys(notemsg);
	}
	
	public void clickOnReviewTransferButton() {
		reviewTransferButton.click();
	}
	

	public void confirmTransferPopup() {
		confirmTransferPopup.click();
	}
	
	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(successSnackbar));
	    return successSnackbar.getText();
	}

}
