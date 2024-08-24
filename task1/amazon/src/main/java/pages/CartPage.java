package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private WebDriver driver;
    private By cart = By.xpath("//div[@class=\"sc-list-item-content\"]/div/div/ul/li");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getFirstCartItem() {
        return driver.findElement(cart).getText();
    }
//    public List<String> getCartItems() {
//        driver.findElements(cart).get(0).getText();
//    }


}
