package testcases;

import org.testng.annotations.Test;
import pages.P05_OverviewPage;

public class TC05_Overview extends TestBase {

    @Test(priority = 1, description = "Complete Order and Validate Total Price")
    public void completeOrderAndValidatePrice() {
        P05_OverviewPage overviewPage = new P05_OverviewPage(page);

        double finalPrice = overviewPage.getFinalPrice();
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Final Price: " + finalPrice);

        if (Math.abs(finalPrice - totalPrice) < 0.01) {
            System.out.println("Price is matching.");
        } else {
            System.out.println("Price is not matching.");
        }
    }

    @Test(priority = 2, description = "Click on Finish Button")
    public void clickOnFinishBtn() {
        new P05_OverviewPage(page).clickOnFinishBtn();
    }
}
