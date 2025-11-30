package pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title");
    private final By firstAddToCartButton = By.cssSelector(".inventory_item:first-child button.btn_inventory");
    private final By cartIcon = By.id("shopping_cart_container");

    public boolean isOnProductsPage() {
        return isVisible(pageTitle) && getText(pageTitle).equals("Products");
    }

    public ProductsPage addFirstProductToCart() {
        click(firstAddToCartButton);
        return this;
    }

    public CartPage openCart() {
        click(cartIcon);
        return new CartPage();
    }
}
