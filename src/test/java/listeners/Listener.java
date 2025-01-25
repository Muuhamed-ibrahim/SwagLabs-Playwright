package listeners;

import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static drivers.DriverHolder.getPage;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        takeScreenshot(result.getName());
    }

    private void takeScreenshot(String testName) {
        Page page = getPage();
        if (page != null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
            try {
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Unable to take screenshot. Page object is null.");
        }
    }
}
