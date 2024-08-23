package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage {
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button");
    private By itemTitle = By.id("productTitle");
    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public addedToCartPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new addedToCartPage(driver);
    }
    public String getItemName() {
        return driver.findElement(itemTitle).getText();
    }
}
