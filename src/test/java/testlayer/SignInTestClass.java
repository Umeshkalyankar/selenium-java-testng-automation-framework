package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import utilitieslayer.ScreenshotUtility;

public class SignInTestClass extends BaseClass{
	
	@Test(enabled = false)
	public void TC_01VerifyOpenAnAccount() throws InterruptedException {
		SignInPageClass_obj.clickOnOpenAnAccountLink();
	}
	
	@Test
	public void TC_02VerifySignInWithValidCredentials() {
		SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
		SignInPageClass_obj.enterPassword("Test@1234");
		SignInPageClass_obj.clickOnSignInSecurely();
		
		Assert.assertTrue(
		        DashboardPageClass_obj.isDashboardDisplayed(),
		        "Dashboard is not displayed after successful login"
		    );
	    ScreenshotUtility.captureScreenshot(driver, "DashboardAfterLogin");

	}
	
	

}
