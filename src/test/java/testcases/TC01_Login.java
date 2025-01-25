package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;

public class TC01_Login extends TestBase {

    private final String username = "standard_user";
    private final String password = "secret_sauce";

    @Test(priority = 1, description = "Login with Valid Username and Password")
    public void loginWithValidUsernameAndPassword() {
        new P01_LoginPage(page)
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }
}
