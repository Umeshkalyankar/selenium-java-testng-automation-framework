package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class DashboardTestClass extends BaseClass{
	
	@Test(enabled=false)
	public void TC_VerifyLogout() throws InterruptedException {
		loginToApplication();
		Thread.sleep(5000);
		DashboardPageClass_obj.clickOnLogout();
	}

}
