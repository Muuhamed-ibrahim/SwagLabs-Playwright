package pages;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class PageBase {

    protected Page page;

    public PageBase(Page page) {
        this.page = page;
    }

    public static void captureScreenshot(Page page, String screenshotName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/" + screenshotName + System.currentTimeMillis() + ".png")));
    }
}
