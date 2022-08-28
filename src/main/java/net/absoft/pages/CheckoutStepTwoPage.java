package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BaseStorePage {

    @FindBy(name = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Finishing checkout")
    public CheckoutCompletePage clickContinueButton() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}