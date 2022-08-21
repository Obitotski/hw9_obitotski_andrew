package net.absoft;

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

  @Test
  public void testAddingItemToCart() {
    inventoryPage
        .addItemToCart(ITEM)
        .openCart()
        .checkItemPresence(ITEM);
  }
}