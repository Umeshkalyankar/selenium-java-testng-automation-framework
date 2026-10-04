package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageClass {
	private WebDriver driver;
	
	public SignInPageClass(WebDriver d) {
		driver=d;
		
		PageFactory.initElements(driver, this);
	}
	 // ------------ Web Elements ------------

    @FindBy(xpath = "//input[@data-testid='login-email']")
    private WebElement emailAddressTextBox;

    @FindBy(xpath = "//input[@data-testid='login-password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@data-testid='login-submit']")
    private WebElement signInButton;

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

    public void clickOnOpenAnAccountLink() {
        openAccountLink.click();
    }
}
