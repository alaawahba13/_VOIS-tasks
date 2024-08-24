package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button");
    private By itemTitle = By.id("productTitle");
    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }
    public addedToCartPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new addedToCartPage(driver);
    }
}
