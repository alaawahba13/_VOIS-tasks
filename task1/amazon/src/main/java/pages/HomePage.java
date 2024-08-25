package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final By SearchBox = By.id("twotabsearchtextbox");
    private final By SearchButton = By.id("nav-search-submit-button");
    private final By cartButton = By.id("nav-cart");
    private final By todaysDealsButton = By.linkText("Today's Deals");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchResultPage searchForItem(String text) {
        driver.findElement(SearchBox).sendKeys(text);
        driver.findElement(SearchButton).click();
        return new SearchResultPage(driver);
    }
    public CartPage goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
    public TodaysDealsPage goToTodaysDdeals(){
        driver.findElement(todaysDealsButton).click();
        return new TodaysDealsPage(driver);
    }
}
