package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private WebDriver driver;
    private By cart = By.xpath("(//span[@class=\"a-truncate-cut\"])[1]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getFirstCartItem() {
        return driver.findElement(cart).getText();
    }
}
