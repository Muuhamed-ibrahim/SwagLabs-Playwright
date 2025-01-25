package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P03_CartPage extends PageBase {

    private final Locator checkoutBtn;

    public P03_CartPage(Page page) {
        super(page);
        this.checkoutBtn = page.locator("//a[@class=\"btn_action checkout_button\"]");
    }

    public P03_CartPage clickOnCheckoutBtn() {
        System.out.println("Clicking on Checkout Button...");
        checkoutBtn.click();
        return this;
    }
}
