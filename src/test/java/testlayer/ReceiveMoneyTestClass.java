package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;

public class ReceiveMoneyTestClass extends BaseClass {

	@Test(groups = { "regression" })
	public void TC_VerifyReceiveMoneyFunctionality() {

		// Login
		loginToApplication();

		// Validate successful login
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Login failed: Dashboard was not displayed");

		// Navigate to Receive Money
		DashboardPageClass_obj.clickOnReceiveMoneyOption();

		// Receive Money
		ReceiveMoneyPageClass_obj.selectSenderFromDropdown("Kabir Khan (kabir.khan@ttabank)");

		ReceiveMoneyPageClass_obj.enterTheReceivingPaymentAmount("600");

		ReceiveMoneyPageClass_obj.enterNoteMsg("Hi Please send the payment!");

		ReceiveMoneyPageClass_obj.clickOnReceivePaymentButton();

		// Validate successful receive-money operation
		String actualMessage = ReceiveMoneyPageClass_obj.getSuccessMessage();

		Assert.assertTrue(actualMessage.startsWith("Received ₹"),
				"Receive Money failed. Unexpected success message: " + actualMessage);

		Assert.assertTrue(actualMessage.contains("New balance ₹"),
				"New balance was not included in the message: " + actualMessage);
	}

}
