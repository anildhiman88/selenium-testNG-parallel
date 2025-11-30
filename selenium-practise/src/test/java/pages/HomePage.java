package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By productsTitle = By.cssSelector(".title");

    public boolean isUserOnProductsPage() {
        return isVisible(productsTitle) && getText(productsTitle).equals("Products");
    }
}
