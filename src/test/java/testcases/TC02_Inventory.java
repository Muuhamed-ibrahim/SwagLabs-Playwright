package testcases;

import org.testng.annotations.Test;
import pages.P02_InventoryPage;

public class TC02_Inventory extends TestBase {
    @Test(priority = 1, description = "add random products and calculate the price")
    public void selectItemsRandomly() {
        totalPrice = new P02_InventoryPage(page).addItemsToCartRandomly(3).getTotalPrice();
    }

    @Test(priority = 2, description = "click on cart Btn")
    public void clickOnCartBtn() {
        new P02_InventoryPage(page).clickOnCartBtn();
    }
}
