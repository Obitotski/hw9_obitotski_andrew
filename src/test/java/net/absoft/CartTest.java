package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
  private final String ITEM = "Sauce Labs Backpack";

  private InventoryPage inventoryPage;

  @BeforeMethod
  public void setUp() {
   new LoginPage(driver)
       .login(Account.STANDARD_USER)
       .shouldSeePrimaryHeader();
    inventoryPage = new InventoryPage(driver);
  }

  @Description("Test adding item to cart")
  @Test
  public void testAddingItemToCart() {
    inventoryPage
        .addItemToCart(ITEM)
        .openCart()
        .checkItemPresence(ITEM);
  }

  @Description("Test removing item from cart")
  @Test
  public void testRemovingItemFromCart() {
    inventoryPage
            .addItemToCart(ITEM)
            .openCart()
            .checkItemPresence(ITEM)
            .clickContinueShopping()
            .removeItemFromCart(ITEM)
            .openCart()
            .checkItemAbsence(ITEM);
  }
}
