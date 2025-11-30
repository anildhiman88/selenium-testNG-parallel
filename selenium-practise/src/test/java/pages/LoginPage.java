package pages;

import org.openqa.selenium.By;
import config.ConfigReader;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector(".error-message-container");

    private final String baseUrl = ConfigReader.get("base.url");

    public LoginPage open() {
        openUrl(baseUrl);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public ProductsPage clickLoginSuccess() {
        click(loginButton);
        return new ProductsPage();
    }

    public LoginPage clickLoginExpectingError() {
        click(loginButton);
        return this;
    }

    public boolean isErrorVisible() {
        return isVisible(errorMessage);
    }
}
