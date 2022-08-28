package net.absoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;

public class CheckoutCompletePage extends BaseStorePage {

    private final By successfulCheckoutHeader = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage checkCheckoutIsSuccessful() {
        assertFalse(driver.findElements(successfulCheckoutHeader).isEmpty(),
                "Should be message about successful checkout");
        return this;
    }
}