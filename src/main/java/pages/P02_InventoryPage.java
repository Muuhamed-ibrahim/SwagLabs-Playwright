package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Collections;
import java.util.List;

public class P02_InventoryPage {

    private final Page page;
    private final Locator cartBtn;
    private double totalPrice;

    // Constructor
    public P02_InventoryPage(Page page) {
        this.page = page;
        this.cartBtn = page.locator("id=shopping_cart_container");
    }

    // Method to add random items to the cart
    public P02_InventoryPage addItemsToCartRandomly(int randomCount) {
        List<Locator> addToCartButtons = page.locator("button.btn_inventory").all(); // Get all "Add to Cart" buttons
        Collections.shuffle(addToCartButtons); // Shuffle buttons for randomness

        totalPrice = 0; // Initialize total price
        for (int i = 0; i < randomCount && i < addToCartButtons.size(); i++) {
            Locator button = addToCartButtons.get(i);
            button.click(); // Click on the "Add to Cart" button

            Locator itemElement = button.locator("xpath=./ancestor::div[@class='inventory_item']"); // Locate parent item
            String priceText = itemElement.locator("xpath=.//div[@class='inventory_item_price']").textContent(); // Get price

            double price = Double.parseDouble(priceText.replace("$", "")); // Convert price to double
            totalPrice += price; // Add to total price
        }

        System.out.println("Total price of added items: $" + totalPrice);
        return this;
    }

    // Method to click on the cart button
    public P02_InventoryPage clickOnCartBtn() {
        cartBtn.click(); // Click on the cart button
        return this;
    }

    // Method to get the total price of added items
    public double getTotalPrice() {
        return totalPrice;
    }
}
