package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import utilitieslayer.ConfigReader;
import utilitieslayer.RetryAnalyzer;

public class SignInTestClass extends BaseClass {

	@Test(groups = {"smoke"})
	public void TC_01_VerifyLoginWithValidCredentials() {

		System.out.println("BaseClass object: " + this.getClass().getSuperclass());
		System.out.println("SignInPageClass_obj: " + SignInPageClass_obj);
		
		SignInPageClass_obj.enterEmailAddress(ConfigReader.getProperty("email"));

		SignInPageClass_obj.enterPassword(ConfigReader.getProperty("password"));

		SignInPageClass_obj.clickOnSignInSecurely();

		Assert.assertTrue(DashboardPageClass_obj.isDashboardDisplayed(),
				"Dashboard is not displayed after successful login");
	}

	@Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
	public void TC_02_VerifyLoginWithInvalidPassword() {

		SignInPageClass_obj.enterEmailAddress(ConfigReader.getProperty("email"));

		SignInPageClass_obj.enterPassword(ConfigReader.getProperty("invalidPassword"));

		SignInPageClass_obj.clickOnSignInSecurely();

		Assert.assertEquals(SignInPageClass_obj.getInvalidCredentialsMessage(), "Invalid email or password",
				"Incorrect validation message displayed");
	}

	@Test(groups = {"regression"})
	public void TC_03_VerifyLoginWithInvalidEmail() {

		SignInPageClass_obj.enterEmailAddress(ConfigReader.getProperty("invalidEmail"));

		SignInPageClass_obj.enterPassword(ConfigReader.getProperty("password"));

		SignInPageClass_obj.clickOnSignInSecurely();

		Assert.assertEquals(SignInPageClass_obj.getInvalidCredentialsMessage(), "Invalid email or password",
				"Incorrect validation message displayed");
	}

}
