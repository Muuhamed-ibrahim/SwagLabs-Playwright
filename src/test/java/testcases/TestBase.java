package testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.*;

@Listeners(listeners.Listener.class)
public class TestBase {

    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    protected static double totalPrice;
    private static String PROJECT_URL;

    // Properties file to manage configurations
    private static Properties prop;
    private static FileInputStream readProperty;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        loadProjectDetails();
        System.out.println("Test Suite Started");
    }

    private void loadProjectDetails() throws IOException {
        prop = new Properties();
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop.load(readProperty);

        // Load project details
        PROJECT_URL = prop.getProperty("url");
        System.out.println("Project URL: " + PROJECT_URL);
    }

    @Parameters("browsername")
    @BeforeTest
    public void setUpDriver(String browsername) {
        System.out.println("Initializing browser: " + browsername);
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);

        // Launch the browser based on the parameter
        switch (browsername.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "webkit":
                browser = playwright.webkit().launch(launchOptions);
                break;
            default:
                browser = playwright.chromium().launch(launchOptions);
                break;
        }

        // Initialize context and page
        context = browser.newContext();
        page = context.newPage();

        // Set context and page to DriverHolder
        setBrowserContext(context);
        setPage(page);

        // Navigate to the project URL
        page.navigate(PROJECT_URL);
        System.out.println("Navigated to: " + PROJECT_URL);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Tearing down test...");
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test Suite Finished");
    }
}
