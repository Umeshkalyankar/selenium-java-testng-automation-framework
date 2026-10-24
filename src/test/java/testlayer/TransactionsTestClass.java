package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class TransactionsTestClass extends BaseClass {

	@Test(groups = { "smoke" })
	public void TC_VerifyResetAccount() {
		// login
		loginToApplication();
		
		DashboardPageClass_obj.clickOnTransactionsOption();
		
		TransactionsPageClass_obj.resetAccount();
		
	}

	@Test(groups = { "regression" })
	public void TC_VerifyPartyTransactions() {
		// login
		loginToApplication();

		DashboardPageClass_obj.clickOnTransactionsOption();

		TransactionsPageClass_obj.enterPartyName("Aarav");
	}
}
