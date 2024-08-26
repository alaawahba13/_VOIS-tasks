package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private final WebDriver driver;
    private final By cart = By.xpath("(//span[@class=\"a-truncate-cut\"])[1]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getFirstCartItem() {
        return driver.findElement(cart).getText();
    }
    public boolean isCartEmpty(){
        try {
            driver.findElement(By.xpath("//div[@class=\"a-row sc-your-amazon-cart-is-empty\"]")).isDisplayed();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

}
