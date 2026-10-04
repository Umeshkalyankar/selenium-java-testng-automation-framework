package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;

public class SignUpTestClass extends BaseClass {
	
	@Test
	public void TC_01VerifySuccessfulSignup() throws InterruptedException {
		SignInPageClass_obj.clickOnOpenAnAccountLink();
		
		SignUpPageClass_obj.enterFullName("James Bond");
		SignUpPageClass_obj.enterEmailAddress("jb@gmail.com");
		SignUpPageClass_obj.enterMobileNumber("9437454545");
		SignUpPageClass_obj.enterPassword("Test@1234");
		SignUpPageClass_obj.enterConfirmPassword("Test@1234");
		SignUpPageClass_obj.clickOnOpenMyAccount();
		//String actual_title = driver.getTitle();
		
//		String expected_title = "TTA Bank - Dashboard";
//		Thread.sleep(9000);
//		Assert.assertEquals(actual_title, expected_title);
		
	}

}
