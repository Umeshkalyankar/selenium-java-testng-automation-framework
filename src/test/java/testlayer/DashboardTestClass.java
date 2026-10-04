package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class DashboardTestClass extends BaseClass{
	
	@Test(enabled=false)
	public void TC_VerifyLogout() throws InterruptedException {
		SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
		SignInPageClass_obj.enterPassword("Test@1234");
		SignInPageClass_obj.clickOnSignInSecurely();
		Thread.sleep(5000);
		DashboardPageClass_obj.clickOnLogout();
	}

}
