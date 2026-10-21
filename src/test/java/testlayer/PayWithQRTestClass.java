package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class PayWithQRTestClass extends BaseClass {
	
	@Test(groups = {"regression"})
	public void TC_VerifyPayWithQRFunctionality() {
		
		loginToApplication();
		
		DashboardPageClass_obj.clickOnPayWithQrOption();
		
		PayWithQRPageClass_obj.enterThePaymentAmount("650");
		PayWithQRPageClass_obj.selectCategory("Rent");
		PayWithQRPageClass_obj.clickOnMarkAsPaidButton();
	}
}
