package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class PayWithQRTestClass extends BaseClass {
	
	@Test()
	public void TC_VerifyPayWithQRFunctionality() {
		
		SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
		SignInPageClass_obj.enterPassword("Test@1234");
		SignInPageClass_obj.clickOnSignInSecurely();
		
		DashboardPageClass_obj.clickOnPayWithQrOption();
		
		PayWithQRPageClass_obj.enterThePaymentAmount("650");
		PayWithQRPageClass_obj.selectCategory("Rent");
		PayWithQRPageClass_obj.clickOnMarkAsPaidButton();
	}
}
