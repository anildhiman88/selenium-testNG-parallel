package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCart_shouldReflectInCartPage() {
        LoginPage loginPage = new LoginPage();

        // Login Step
        ProductsPage productsPage = loginPage
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginSuccess();

        Assert.assertTrue(productsPage.isOnProductsPage(),
                "User should land on Products page after login.");

        // Add first product
        productsPage.addFirstProductToCart();

        // Navigate to Cart
        CartPage cartPage = productsPage.openCart();

        // Verification
        Assert.assertTrue(cartPage.isItemAddedToCart(),
                "Cart should contain at least one item after adding.");

        Assert.assertEquals(cartPage.getCartBadgeCount(), "1",
                "Cart badge count should show 1 item.");
    }
}
