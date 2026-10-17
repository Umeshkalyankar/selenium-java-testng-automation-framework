package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import utilitieslayer.ConfigReader;

public class SignInTestClass extends BaseClass{
	
	@Test(enabled = false)
	public void TC_01VerifyOpenAnAccount() throws InterruptedException {
		SignInPageClass_obj.clickOnOpenAnAccountLink();
	}
	
	@Test
	public void TC_02VerifySignInWithValidCredentials() {
		// Read credentials from config.properties
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        // Perform login
        SignInPageClass_obj.enterEmailAddress(email);
        SignInPageClass_obj.enterPassword(password);
        SignInPageClass_obj.clickOnSignInSecurely();
		
		Assert.assertTrue(
		        DashboardPageClass_obj.isDashboardDisplayed(),
		        "Dashboard is not displayed after successful login"
		    );
	}
	
	

}
