package net.absoft.data;

import org.openqa.selenium.By;

public enum Filter {

    NAME_A_TO_Z("Name (A to Z)", "option[value=az]", "Sauce Labs Backpack"),
    NAME_Z_TO_A("Name (Z to A)", "option[value=za]", "Test.allTheThings() T-Shirt (Red)"),
    PRICE_LOW_TO_HIGH("Price (low to high)", "option[value=lohi]", "Sauce Labs Onesie"),
    PRICE_HIGH_TO_LOW("Price (high to low)", "option[value=hilo]", "Sauce Labs Fleece Jacket");

    private final String name;
    private final By locator;
    private final String expectedFirstItemName;

    Filter(String name, String locator, String expectedFirstItemName) {
        this.name = name;
        this.locator = By.cssSelector(locator);
        this.expectedFirstItemName = expectedFirstItemName;
    }

    public String getName() {
        return name;
    }

    public By getLocator() {
        return locator;
    }

    public String getExpectedFirstItemName() {
        return expectedFirstItemName;
    }
}