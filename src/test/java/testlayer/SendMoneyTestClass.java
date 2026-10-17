package testlayer;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import pagelayer.SendMoneyPageClass;

public class SendMoneyTestClass extends BaseClass{

	@Test
	public void TC_VerifySendMoneyFunctionality() {
		// Login
		loginToApplication();
		
		// Navigate to Send Money
		DashboardPageClass_obj.clickOnSendMoneyOption();
		
		//Send Money
		SendMoneyPageClass_obj.clickOnBeneficiaryName();
		SendMoneyPageClass_obj.enterThePaymentAmount("900");
		SendMoneyPageClass_obj.selectCategory("Travel");
		SendMoneyPageClass_obj.enterNoteMsg("Testing Send Money Feature");
		SendMoneyPageClass_obj.clickOnReviewTransferButton();
		SendMoneyPageClass_obj.confirmTransferPopup();
		
		String message = SendMoneyPageClass_obj.getSuccessMessage();
		Assert.assertTrue(message.contains("Sent successfully."));

	}
	
	@Test
	public void TC_VerifyValidPaymentAmount() {
		// Login
				SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
				SignInPageClass_obj.enterPassword("Test@1234");
				SignInPageClass_obj.clickOnSignInSecurely();
				
				// Navigate to Send Money
				DashboardPageClass_obj.clickOnSendMoneyOption();
				
				//Send Money
				SendMoneyPageClass_obj.clickOnBeneficiaryName();
				SendMoneyPageClass_obj.enterThePaymentAmount("0");
				SendMoneyPageClass_obj.selectCategory("Travel");
				SendMoneyPageClass_obj.clickOnReviewTransferButton();
				
				String actualMsg = SendMoneyPageClass_obj.getAmountErrorMessage();
//				String expectedMsg = "Enter an amount greater than zero";
//				Assert.assertEquals(actualMsg, expectedMsg);
				
				Assert.assertTrue(actualMsg.contains("Enter an amount greater than zero"));
	}
}
