package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    private final WebDriver driver;
    private final By addToCartButton = By.id("add-to-cart-button");
    private final By itemTitle = By.id("productTitle");
    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }
    public addedToCartPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new addedToCartPage(driver);
    }
    public String getItemTitle() {
        return driver.findElement(itemTitle).getText();
    }
}
