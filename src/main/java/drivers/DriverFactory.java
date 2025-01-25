package actions;

import com.microsoft.playwright.*;
import java.util.Arrays;

public class DriverFactory {

    public static Browser getNewInstance(String browserName) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        switch (browserName.toLowerCase()) {
            case "chrome-headless":
                launchOptions.setHeadless(true).setArgs(Arrays.asList("--no-sandbox", "--disable-gpu"));
                return playwright.chromium().launch(launchOptions);
            case "firefox-headless":
                return playwright.firefox().launch(launchOptions.setHeadless(true));
            case "firefox":
                return playwright.firefox().launch(launchOptions.setHeadless(false));
            default:
                return playwright.chromium().launch(launchOptions.setHeadless(false));
        }
    }
}
