package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By SearchBox = By.id("twotabsearchtextbox");
    private By SearchButton = By.id("nav-search-submit-button");
    private By cartButton = By.id("nav-cart");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchResultPage searchForItem(String text) {
        driver.findElement(SearchBox).sendKeys(text);
        driver.findElement(SearchButton).click();
        return new SearchResultPage(driver);
    }
    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
