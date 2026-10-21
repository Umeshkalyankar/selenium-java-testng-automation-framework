package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;

public class SendMoneyTestClass extends BaseClass {

@Test(groups = {"regression"})
public void TC_VerifySendMoneyFunctionality() {

    // Login
    loginToApplication();

    // Validate successful login
    Assert.assertTrue(
        DashboardPageClass_obj.isDashboardDisplayed(),
        "Login failed: Dashboard was not displayed"
    );

    // Navigate to Send Money
    DashboardPageClass_obj.clickOnSendMoneyOption();

    // Send Money
    SendMoneyPageClass_obj.clickOnBeneficiaryName();
    SendMoneyPageClass_obj.enterThePaymentAmount("900");
    SendMoneyPageClass_obj.selectCategory("Travel");
    SendMoneyPageClass_obj.enterNoteMsg("Testing Send Money Feature");
    SendMoneyPageClass_obj.clickOnReviewTransferButton();
    SendMoneyPageClass_obj.confirmTransferPopup();

    // Validate successful money transfer
    String actualMessage = SendMoneyPageClass_obj.getSuccessMessage();

    Assert.assertTrue(
        actualMessage.contains("Sent successfully."),
        "Money transfer failed. Actual message: " + actualMessage
    );
}

@Test(groups = {"regression"})
public void TC_VerifyInvalidPaymentAmount() {

    // Login
    loginToApplication();

    // Validate successful login
    Assert.assertTrue(
        DashboardPageClass_obj.isDashboardDisplayed(),
        "Login failed: Dashboard was not displayed"
    );

    // Navigate to Send Money
    DashboardPageClass_obj.clickOnSendMoneyOption();

    // Enter invalid payment amount
    SendMoneyPageClass_obj.clickOnBeneficiaryName();
    SendMoneyPageClass_obj.enterThePaymentAmount("0");
    SendMoneyPageClass_obj.selectCategory("Travel");
    SendMoneyPageClass_obj.clickOnReviewTransferButton();

    // Validate amount error message
    String actualMessage =
            SendMoneyPageClass_obj.getAmountErrorMessage();

    Assert.assertTrue(
        actualMessage.contains("Enter an amount greater than zero"),
        "Incorrect validation message for zero payment amount. Actual message: "
                + actualMessage
    );
}


}
