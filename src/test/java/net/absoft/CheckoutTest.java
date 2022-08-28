package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.data.Customer;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private final String ITEM = "Sauce Labs Backpack";

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        new LoginPage(driver)
                .login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
        inventoryPage = new InventoryPage(driver);
    }

    @Description("Test successful checkout")
    @Test
    public void testSuccessfulCheckout() {
        inventoryPage
                .addItemToCart(ITEM)
                .openCart()
                .clickCheckoutButton()
                .fillCheckoutCustomerInformation(Customer.STANDARD_CUSTOMER)
                .clickContinueButton()
                .clickContinueButton()
                .checkCheckoutIsSuccessful();
    }
}