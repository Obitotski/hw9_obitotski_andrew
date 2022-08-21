package net.absoft.pages;

import net.absoft.data.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseComponent {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public InventoryPage login(Account account) {
    driver.findElement(By.cssSelector("input[data-test='username']"))
        .sendKeys(account.getLogin());
    driver.findElement(By.cssSelector("input[data-test='password']"))
        .sendKeys(account.getPassword());
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();
    return new InventoryPage(driver);
  }
}
