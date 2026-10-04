package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReceiveMoneyPageClass {
	
	private WebDriver driver;
	
	public ReceiveMoneyPageClass(WebDriver d) {
		driver=d;
		
		PageFactory.initElements(driver, this);
	}
	
	// Web Elements
	
	@FindBy(xpath="//select[@data-testid='receive-from']")
	private WebElement senderDropDown;
	
	@FindBy(xpath="//input[@data-testid='receive-amount']")
	private WebElement receivingPaymentAmountTextBox;
	
	@FindBy(xpath="//input[@data-testid='receive-note']")
	private WebElement noteTextBox;
	
	@FindBy(xpath="//button[@data-testid='receive-submit']")
	private WebElement receivePaymentButton;
	
	// Action
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

}
