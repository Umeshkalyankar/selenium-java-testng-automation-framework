package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class ReceiveMoneyTestClass extends BaseClass{

	@Test
	public void TC_VerifyReceiveMoneyFunctionality() throws InterruptedException {
		
		// Login
		SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
		SignInPageClass_obj.enterPassword("Test@1234");
		SignInPageClass_obj.clickOnSignInSecurely();
		
		 // Navigate to Receive Money
		DashboardPageClass_obj.clickOnReceiveMoneyOption();
		
		// Receive Money
		ReceiveMoneyPageClass_obj.selectSenderFromDropdown("Kabir Khan (kabir.khan@ttabank)");
		ReceiveMoneyPageClass_obj.enterTheReceivingPaymentAmount("600");
		ReceiveMoneyPageClass_obj.enterNoteMsg("Hi Please send the payment!");
		ReceiveMoneyPageClass_obj.clickOnReceivePaymentButton();
	}
}
