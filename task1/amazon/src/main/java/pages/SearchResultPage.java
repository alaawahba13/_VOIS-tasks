package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultPage {
    private WebDriver driver;
    private  WebDriverWait wait;
    private By firstResultTitle = By.xpath("(//div[contains(@data-cel-widget, 'search_result')]//h2/a)[1]");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public ItemPage clickFirstItem(){
        // waits until the page loads and the item is clickable
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstResultTitle)));
        driver.findElement(firstResultTitle).click();
        return new ItemPage(driver);
    }
}
