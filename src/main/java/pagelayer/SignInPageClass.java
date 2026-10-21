package pagelayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageClass {
	private WebDriver driver;

	public SignInPageClass(WebDriver d) {
		driver = d;

		PageFactory.initElements(driver, this);
	}
	// ------------ Web Elements ------------

	@FindBy(xpath = "//input[@data-testid='login-email']")
	private WebElement emailAddressTextBox;

	@FindBy(xpath = "//input[@data-testid='login-password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@data-testid='login-submit']")
	private WebElement signInButton;

	@FindBy(xpath = "//div[@data-testid='login-error']")
	private WebElement invalidCredentialsMessage;

	@FindBy(xpath = "//a[@data-testid='link-register']")
	private WebElement openAccountLink;

	// ------------ Action Methods ------------

	public void enterEmailAddress(String emailAddress) {
		emailAddressTextBox.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickOnSignInSecurely() {
		signInButton.click();
	}

	public String getInvalidCredentialsMessage() {

	    try {
	        WebDriverWait wait = new WebDriverWait(
	                driver, Duration.ofSeconds(5));

	        WebElement errorMessage = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[@data-testid='login-error']")
	                )
	        );

	        return errorMessage.getText().trim();

	    } catch (TimeoutException e) {
	        return "";
	    }
	}

	public boolean isInvalidCredentialsMessageDisplayed() {
	    return !getInvalidCredentialsMessage().isEmpty();
	}

	public void clickOnOpenAnAccountLink() {
		openAccountLink.click();
	}
	public boolean isLoginPageDisplayed() {
	    return emailAddressTextBox.isDisplayed()
	            && passwordTextBox.isDisplayed()
	            && signInButton.isDisplayed();
	}
}
