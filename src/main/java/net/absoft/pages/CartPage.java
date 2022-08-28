package net.absoft.pages;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseStorePage {

    @FindBy(css = "button[id=checkout]")
    private WebElement checkoutButton;
    @FindBy(css = "button[id=continue-shopping]")
    private WebElement continueShoppingButton;

    private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkItemPresence(String itemName) {
        String itemXPathFormatted = String.format(itemXPath, itemName);
        assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                "Item " + itemName + " was not added to cart");
        return this;
    }

    public CartPage checkItemAbsence(String itemName) {
        String itemXPathFormatted = String.format(itemXPath, itemName);
        assertTrue(driver.findElements(By.xpath(itemXPathFormatted)).isEmpty(),
                "Item " + itemName + " was not removed from cart");
        return this;
    }

    @Step("Opening checkout page")
    public CheckoutStepOnePage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutStepOnePage(driver);
    }

    @Step("Pressing \"Continue shopping\" button to open inventory page")
    public InventoryPage clickContinueShopping() {
        continueShoppingButton.click();
        return new InventoryPage(driver);
    }
}
