package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Filter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InventoryPage extends BaseStorePage {

    @FindBy(css = ".product_sort_container")
    private WebElement filtersDropDownList;

    private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Adding item {itemName} to cart")
    public InventoryPage addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
        WebElement addToCartButton = item.findElement(
                By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
        addToCartButton.click();
        return this;
    }

    @Step("Removing item {itemName} from cart")
    public InventoryPage removeItemFromCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
        WebElement removeFromCartButton = item.findElement(
                By.xpath("//button[contains(@data-test, 'remove')]"));
        removeFromCartButton.click();
        return this;
    }

    @Step("Filtering items by {filter.name}")
    public InventoryPage filterItems(Filter filter) {
        filtersDropDownList.click();
        driver.findElement(filter.getLocator()).click();
        return this;
    }

    public InventoryPage checkExpectedItemIsFirstAfterFiltering(Filter filter) {
        String actualFirstItemName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        Assert.assertEquals(actualFirstItemName, filter.getExpectedFirstItemName(),
                "After applying " + filter.getName() + " first item should be " + filter.getExpectedFirstItemName());
        return this;
    }
}
