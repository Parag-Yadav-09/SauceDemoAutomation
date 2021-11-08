package tests;

import pageClass.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TestCase_001 extends TestBase {

    HomePage hPage = new HomePage(driver);
    LoginPage lPage = new LoginPage(driver);

    /*TC 1: Verify if a user will be able to login with valid username and valid password.
     */
    @Test(priority = 0)
    public void loginUsernameAndPassword() {

        HomePage hPage = new HomePage(driver);
        LoginPage lPage = new LoginPage(driver);

        lPage.enterUserName("standard_user");
        lPage.enterPassword("secret_sauce");
        lPage.clickLoginButton();
        Assert.assertTrue(hPage.verifyTitle());
    }

    /*TC 2: Verify if a user will be able to login with invalid username and valid password.
     */
    @Test(priority = 1)
    public void loginInValidUsernameAndValidPassword() {

        HomePage hPage = new HomePage(driver);
        LoginPage lPage = new LoginPage(driver);

        lPage.enterUserName("standard_user_1");
        lPage.enterPassword("secret_sauce");
        lPage.clickLoginButton();
        Assert.assertFalse(hPage.verifyTitle());

    }

    /*TC 3: Verify if a user will be able to login with valid username and invalid password.
     */
    @Test(priority = 2)
    public void loginValidUsernameAndInValidPassword() {

        HomePage hPage = new HomePage(driver);
        LoginPage lPage = new LoginPage(driver);

        lPage.enterUserName("standard_user");
        lPage.enterPassword("secret_sauce_1");
        lPage.clickLoginButton();
        Assert.assertFalse(hPage.verifyTitle());

    }

    /*TC 4: Verify the error message when user enters invalid username and invalid password.
     */
    @Test(priority = 3)
    public void verifyErrorMessageInvalidInputs() {

        LoginPage lPage = new LoginPage(driver);

        lPage.enterUserName("standard_user_1");
        lPage.enterPassword("secret_sauce_1");
        lPage.clickLoginButton();
        Assert.assertEquals(lPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error Message");

    }

    /*TC 5: Verify the error message when user do not enters username and password.
     */
    @Test(priority = 3)
    public void verifyErrorMessageNoInputs() {

        LoginPage lPage = new LoginPage(driver);

        lPage.enterUserName("standard_user_1");
        lPage.enterPassword("secret_sauce_1");
        lPage.clickLoginButton();
        Assert.assertEquals(lPage.getErrorMessage(), "Epic sadface: Username is required", "Error Message");

    }
}