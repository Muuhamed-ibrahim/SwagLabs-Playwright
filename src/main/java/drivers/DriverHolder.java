package drivers;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class DriverHolder {

    private static final ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    public static void setPage(Page page) {
        DriverHolder.page.set(page);
    }

    public static BrowserContext getBrowserContext() {
        return browserContext.get();
    }

    public static void setBrowserContext(BrowserContext context) {
        DriverHolder.browserContext.set(context);
    }
}
