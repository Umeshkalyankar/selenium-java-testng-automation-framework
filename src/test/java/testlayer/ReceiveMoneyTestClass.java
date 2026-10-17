package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class ReceiveMoneyTestClass extends BaseClass{

	@Test
	public void TC_VerifyReceiveMoneyFunctionality() throws InterruptedException {
		
		// Login
		loginToApplication();
		
		 // Navigate to Receive Money
		DashboardPageClass_obj.clickOnReceiveMoneyOption();
		
		// Receive Money
		ReceiveMoneyPageClass_obj.selectSenderFromDropdown("Kabir Khan (kabir.khan@ttabank)");
		ReceiveMoneyPageClass_obj.enterTheReceivingPaymentAmount("600");
		ReceiveMoneyPageClass_obj.enterNoteMsg("Hi Please send the payment!");
		ReceiveMoneyPageClass_obj.clickOnReceivePaymentButton();
	}
}
