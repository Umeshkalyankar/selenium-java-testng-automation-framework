package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class TransactionsTestClass extends BaseClass{
	
	@Test
	public void TC_VerifyPartyTransactions() {
		// login
		loginToApplication();
		
		DashboardPageClass_obj.clickOnTransactionsOption();
		
		TransactionsPageClass_obj.enterPartyName("Aarav");
	}
}
