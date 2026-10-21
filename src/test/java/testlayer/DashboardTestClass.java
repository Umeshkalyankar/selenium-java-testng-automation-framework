package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;

public class DashboardTestClass extends BaseClass {

	@Test(groups = { "smoke" })
	public void TC_VerifySendMoneyNavigation() {

		// Login to the application
		loginToApplication();

		// Verify dashboard is displayed
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Dashboard was not displayed after login");

		// Navigate to Send Money
		DashboardPageClass_obj.clickOnSendMoneyOption();

		// Verify Send Money page is displayed
		Assert.assertTrue(SendMoneyPageClass_obj.isSendMoneyPageDisplayed(), "Send Money page was not displayed");
	}

	@Test(groups = { "smoke" })
	public void TC_VerifyReceiveMoneyNavigation() {

		loginToApplication();
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Dashboard was not displayed after login");

		// Navigate to Receive Money
		DashboardPageClass_obj.clickOnReceiveMoneyOption();

		// Verify Receive Money page is displayed
		Assert.assertTrue(ReceiveMoneyPageClass_obj.isReceiveMoneyPageDisplayed(),
				"Receive Money page was not displayed");
	}

	@Test(groups = { "smoke" })
	public void TC_VerifyPayWithQRNavigation() {

		loginToApplication();
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Dashboard was not displayed after login");
		// Navigate to PaywithQR
		DashboardPageClass_obj.clickOnPayWithQrOption();
		// Verify PaywithQR page is displayed
		Assert.assertTrue(PayWithQRPageClass_obj.isPayWithQRPageDisplayed(), "Pay with QR page was not displayed");
	}

	@Test(groups = { "smoke" })
	public void TC_VerifyTransactionsNavigation() {

		loginToApplication();
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Dashboard was not displayed after login");
		// Navigate to Transactions
		DashboardPageClass_obj.clickOnTransactionsOption();

		// Verify Transactions page is displayed
		Assert.assertTrue(TransactionsPageClass_obj.isTransactionsPageDisplayed(),
				"Transactions page was not displayed");
	}

	@Test(groups = { "smoke" })
	public void TC_VerifyLogout() {

		loginToApplication();
		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(), "Login failed: Dashboard was not displayed");
		// Perform logout
		DashboardPageClass_obj.clickOnLogout();

		// Validate successful logout
		Assert.assertTrue(SignInPageClass_obj.isLoginPageDisplayed(), "Logout failed: Login page was not displayed");
	}

}
