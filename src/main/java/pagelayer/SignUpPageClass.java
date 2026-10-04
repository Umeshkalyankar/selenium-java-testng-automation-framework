package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageClass {
	
private WebDriver driver;
	
	public SignUpPageClass(WebDriver d) {
		driver=d;
		
		PageFactory.initElements(driver, this);
	}
	//------------  Web element ----------------
	
	@FindBy(xpath="//input[@data-testid='register-name']")
	private WebElement fullname_textbox;
	
	@FindBy(xpath="//input[@data-testid='register-email']")
	private WebElement emailaddress_textbox;
	
	@FindBy(xpath="//input[@data-testid='register-phone']")
	private WebElement mobilenumber_textbox;
	
	@FindBy(xpath="//input[@id='regPassword']")
	private WebElement password_textbox;
	
	@FindBy(xpath="//input[@data-testid='register-confirm']")
	private WebElement confirmpassword_textbox;
	
	@FindBy(xpath="//button[@data-testid='register-submit']")
	private WebElement openmyaccount_button;
	
	
	
	//------------ Action methods ----------------
	
	public void enterFullName(String fullname) {
		fullname_textbox.sendKeys(fullname);
	}
	
	public void enterEmailAddress(String emailaddress) {
		emailaddress_textbox.sendKeys(emailaddress);
	}
	
	public void enterMobileNumber(String mobilenumber ) {
		mobilenumber_textbox.sendKeys(mobilenumber);
	}
	
	public void enterPassword(String password) {
		password_textbox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmpassword) {
		confirmpassword_textbox.sendKeys(confirmpassword);
	}
	
	public void clickOnOpenMyAccount() {
		openmyaccount_button.click();
	}
}
