package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private static final Map<String, String> monthMap = new HashMap<>();

    static {
        monthMap.put("January", "1");
        monthMap.put("February", "2");
        monthMap.put("March", "3");
        monthMap.put("April", "4");
        monthMap.put("May", "5");
        monthMap.put("June", "6");
        monthMap.put("July", "7");
        monthMap.put("August", "8");
        monthMap.put("September", "9");
        monthMap.put("October", "10");
        monthMap.put("November", "11");
        monthMap.put("December", "12");
    }
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickBookNow(String index){
        By bookNowButton = By.xpath("(//div[@class=\"book-btn\"])["+index+"]");
        WebElement Button = driver.findElement(bookNowButton);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(Button).click().perform();
    }
    public TripDetailsPage selectDate(String day, String month){
        selectMonth(month);
        By dayIcon = By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td/a[text()=\""+day+"\"]") ;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(dayIcon).click();
        return new TripDetailsPage(driver);
    }
    private void selectMonth(String Month){
        By CurrentMonth = By.xpath("//span[@class=\"ui-datepicker-month\"]");
        String currentMonthName = driver.findElement(CurrentMonth).getText();
        String currentMonthNumber = monthMap.get(currentMonthName);
        if (!currentMonthNumber.equals(Month)) {
            //click next
            driver.findElement(By.xpath("//a[@title=\"Next\"]")).click();
        }
    }


}
