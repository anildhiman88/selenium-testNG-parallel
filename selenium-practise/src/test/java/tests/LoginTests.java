package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin_shouldNavigateToProductsPage() {
        LoginPage loginPage = new LoginPage();
        ProductsPage ProductsPage = loginPage
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginSuccess();

        Assert.assertTrue(ProductsPage.isOnProductsPage(),
                "User should be navigated to Products page after valid login");
    }

    @Test
    public void invalidLogin_shouldShowErrorMessage() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .enterUsername("locked_out_user")
                .enterPassword("wrong_password")
                .clickLoginExpectingError();

        Assert.assertTrue(loginPage.isErrorVisible(),
                "Error message should be visible for invalid login");
    }
}
