package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P04_CheckoutPage extends PageBase {

    private final Locator firstname;
    private final Locator lastname;
    private final Locator zip;
    private final Locator continueBtn;

    public P04_CheckoutPage(Page page) {
        super(page);
        this.firstname = page.locator("(//input)[1]");
        this.lastname = page.locator("(//input)[2]");
        this.zip = page.locator("(//input)[3]");
        this.continueBtn = page.locator("(//input)[4]");
    }

    public P04_CheckoutPage enterFirstName(String firstname) {
        System.out.println("Entering First Name...");
        this.firstname.fill(firstname);
        return this;
    }

    public P04_CheckoutPage enterLastName(String lastname) {
        System.out.println("Entering Last Name...");
        this.lastname.fill(lastname);
        return this;
    }

    public P04_CheckoutPage enterZip(String zip) {
        System.out.println("Entering ZIP Code...");
        this.zip.fill(zip);
        return this;
    }

    public P04_CheckoutPage clickOnContinueBtn() {
        System.out.println("Clicking on Continue Button...");
        this.continueBtn.click();
        return this;
    }
}
