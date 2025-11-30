package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartItems = By.cssSelector(".cart_item");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    public int getCartItemsCount() {
        return wait.until(driver -> driver.findElements(cartItems).size());
    }

    public boolean isItemAddedToCart() {
        return getCartItemsCount() > 0;
    }

    public String getCartBadgeCount() {
        if (isVisible(cartBadge)) {
            return getText(cartBadge);
        }
        return "0";
    }
}
