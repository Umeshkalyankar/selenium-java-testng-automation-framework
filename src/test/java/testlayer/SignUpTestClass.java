package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import utilitieslayer.ConfigReader;

public class SignUpTestClass extends BaseClass {

    @Test(groups = {"smoke"})
    public void TC_01verifySignUp() {

        SignInPageClass_obj.clickOnOpenAnAccountLink();

        SignUpPageClass_obj.enterFullName(
                ConfigReader.getProperty("signupName"));

        // Generate a unique email address for every test run
        String email = "jb" + System.currentTimeMillis() + "@gmail.com";
        SignUpPageClass_obj.enterEmailAddress(email);

        SignUpPageClass_obj.enterMobileNumber(
                ConfigReader.getProperty("signupMobile"));

        String signupPassword = ConfigReader.getProperty("signupPassword");

        SignUpPageClass_obj.enterPassword(signupPassword);
        SignUpPageClass_obj.enterConfirmPassword(signupPassword);

        SignUpPageClass_obj.clickOnOpenMyAccount();

        Assert.assertTrue(
                DashboardPageClass_obj.isDashboardDisplayed(),
                "Signup failed: Dashboard was not displayed after registration");
    }
}