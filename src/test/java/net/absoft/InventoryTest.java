package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.data.Filter;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        new LoginPage(driver)
                .login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
        inventoryPage = new InventoryPage(driver);
    }

    @Description("Test items filtering")
    @Test(dataProvider = "filters")
    public void testItemsFiltering(Filter filter) {
        inventoryPage
                .filterItems(filter)
                .checkExpectedItemIsFirstAfterFiltering(filter);
    }

    @DataProvider(name = "filters")
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{Filter.NAME_A_TO_Z},
                new Object[]{Filter.NAME_Z_TO_A},
                new Object[]{Filter.PRICE_LOW_TO_HIGH},
                new Object[]{Filter.PRICE_HIGH_TO_LOW},
        };
    }
}