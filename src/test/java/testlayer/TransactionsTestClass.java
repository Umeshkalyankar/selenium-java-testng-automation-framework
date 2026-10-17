package testlayer;

import org.testng.annotations.Test;

import baselayer.BaseClass;

public class TransactionsTestClass extends BaseClass{
	
	@Test
	public void TC_VerifyPartyTransactions() {
		SignInPageClass_obj.enterEmailAddress("priya.tester@ttabank.in");
		SignInPageClass_obj.enterPassword("Test@1234");
		SignInPageClass_obj.clickOnSignInSecurely();
		
		DashboardPageClass_obj.clickOnTransactionsOption();
		
		TransactionsPageClass_obj.enterPartyName("Aarav");
	}
}
