package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P01_LoginPage extends PageBase {

    public P01_LoginPage(Page page) {
        super(page);
    }

    private final Locator USERNAME_TEXT = page.locator("xpath=//input[@data-test=\"username\"]");
    private final Locator PASSWORD_TEXT = page.locator("xpath=//input[@data-test=\"password\"]");
    private final Locator LOGIN_BUTTON = page.locator("id=login-button");

    public P01_LoginPage enterUsername(String username) {
        USERNAME_TEXT.waitFor();
        USERNAME_TEXT.fill(username);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        PASSWORD_TEXT.waitFor();
        PASSWORD_TEXT.fill(password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        LOGIN_BUTTON.waitFor();
        LOGIN_BUTTON.click();
        return this;
    }
}
