package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReviewBookingPage{
    private final WebDriver driver;
    private final By PayBtn = By.xpath("//div[@class=\"flex-all-c navswitchbtn\"]");
    private final By AgreeToTermsChkBox = By.xpath("//div[@class=\"checkbox \"]");
    public ReviewBookingPage(WebDriver driver){
        this.driver = driver;
    }
    public String getEmail(){
        return driver.findElement(By.id("email")).getAttribute("value");
    }
    public String getMobileNo(){
        return driver.findElement(By.id("mobileNo")).getAttribute("value");
    }
    public PaymentPage clickProceedToPay(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(AgreeToTermsChkBox).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(PayBtn).click();
        return new PaymentPage(driver);
    }
}
