package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {
    private WebDriver driver;
    private  WebDriverWait wait;
    private By firstResultTitle = By.xpath("//div[@data-cel-widget=\"search_result_3\"]//h2/a");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public ItemDetailsPage clickFirstItem(){
        // waits until the page loads and the item is clickable
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstResultTitle)));
        driver.findElement(firstResultTitle).click();
        return new ItemDetailsPage(driver);
    }
    public String getFirstItemTitle(){
        return driver.findElement(firstResultTitle).getText();
    }
}
