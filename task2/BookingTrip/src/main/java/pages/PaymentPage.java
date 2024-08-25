package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By iframePath = By.xpath("//iframe[@class=\"razorpay-checkout-frame\"]");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 100);
    }
    public void choosePaymentMethod() {
        WebElement iframe = driver.findElement(iframePath);
        By showQR = By.xpath("//div[@data-content=\"refresh\"]");
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(showQR)));
        driver.findElement(showQR).click();
        driver.switchTo().parentFrame();
    }
   public boolean isQRDisplayed(){
       WebElement iframe = driver.findElement(iframePath);
       driver.switchTo().frame(iframe);
       boolean isDisplayed = driver.findElement(By.xpath("//img[@data-testid=\"qrv2-img\"]")).isDisplayed();
       driver.switchTo().parentFrame();
       return isDisplayed;
   }
}
