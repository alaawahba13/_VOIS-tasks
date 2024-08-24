package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addedToCartPage {
    private WebDriver driver;
    private By addedToCartText = By.cssSelector("#NATC_SMART_WAGON_CONF_MSG_SUCCESS h1");
    public addedToCartPage(WebDriver driver) {
        this.driver = driver;
    }

}
