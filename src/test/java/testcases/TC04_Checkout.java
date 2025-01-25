package testcases;

import org.testng.annotations.Test;
import pages.P04_CheckoutPage;

import static utilities.Utility.generateRandomFirstname;
import static utilities.Utility.generateRandomLastname;
import static utilities.Utility.generateRandomZip;

public class TC04_Checkout extends TestBase {

    private final String firstname = generateRandomFirstname();
    private final String lastname = generateRandomLastname();
    private final String zip = generateRandomZip();

    @Test(priority = 1, description = "Enter Valid Data in Checkout Page")
    public void enterDataInCheckoutPage() {
        new P04_CheckoutPage(page)
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enterZip(zip)
                .clickOnContinueBtn();
    }
}
