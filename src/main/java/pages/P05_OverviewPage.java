package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P05_OverviewPage extends PageBase {

    private final Locator finishBtn;
    private final Locator totalPriceLocator;

    public P05_OverviewPage(Page page) {
        super(page);
        this.finishBtn = page.locator("//a[@class=\"btn_action cart_button\"]");
        this.totalPriceLocator = page.locator("//div[@class='summary_subtotal_label']");
    }

    public P05_OverviewPage clickOnFinishBtn() {
        System.out.println("Clicking on Finish Button...");
        finishBtn.click();
        return this;
    }

    public double getFinalPrice() {
        String finalPriceText = totalPriceLocator.textContent().replace("Item total: $", "");
        return Double.parseDouble(finalPriceText);
    }
}
