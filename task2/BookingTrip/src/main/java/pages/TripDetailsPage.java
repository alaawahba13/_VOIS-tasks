package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TripDetailsPage {
    private final WebDriver driver;
    private final By selectSeatBtn = By.cssSelector(".selectbutton");
    private final By passengerDetailsBtn = By.cssSelector(".btnPassDetails");
    private final By proceedToPassengerDetails = By.xpath("//div[@class=\"navswitchbtn flex-all-c\"]");
    private final By CheckoutBtn = By.xpath("(//div[@class=\"navswitchbtn flex-all-c\"])[2]");
    private final WebDriverWait wait;

    public TripDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 30);
    }

    public WebElement getResultContainer(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//div[@class=\"result-container\"]"));
    }

    public void selectSeat(String seatNumber){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectSeatBtn)));
        driver.findElement(selectSeatBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By SeatNumber = By.xpath("//div[@class=\"seats\"]//div[@class=\"seatlook\" and text()=\""+seatNumber+"\"]");
        driver.findElement(SeatNumber).click();
    }

    public void selectBoardingPoint(String BoardingPoint){
        By selectBoardingPointButton = By.xpath("(//div[@class=\"point-inp flex-vc\"])[1]");
        driver.findElement(selectBoardingPointButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class=\"point-opt active\"]//div[text()=\""+BoardingPoint+"\"]"));
        dropdownElement.click();
    }

    public void selectDropPoint( String DroppingPoint){
        By selectDropPointButton = By.xpath("(//div[@class=\"point-inp flex-vc\"])[2]");
        driver.findElement(selectDropPointButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class=\"point-opt active\"]//div[text()=\""+DroppingPoint+"\"]"));
        dropdownElement.click();
    }

    public boolean isPassengerDetailsBtnDisplayed(){
        return driver.findElement(passengerDetailsBtn).isDisplayed();
    }

    public void clickPassengerDetailsBtn(){
        driver.findElement(passengerDetailsBtn).click();
    }

    public void fillCustomerDetails(String CountryCode, String MobileNo, String Email){
        //============ Select country code ==============
        // click dropdown menu first
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("countrycode")).click();
        // choose option
        By option = By.xpath("//div[@class=\"country--code\" and text()= \""+CountryCode+"\"]");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(option).click();

        //============ Type phone number ==============
        By MobileNoInput = By.name("mobileNo");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MobileNoInput).sendKeys(MobileNo);

        //============ Type email  ==============
        By EmailInput = By.name("email");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(EmailInput).sendKeys(Email);
    }

    public void fillPassengerDetails(String name, String age,String Gender, String Concession, String CardType, String CardNo, String Country){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(proceedToPassengerDetails).click();

        //============ Type name  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxName[0]")).sendKeys(name);
        //============ Choose Gender  ==============
                /*
                 1. click the dropdown menu first
                 2. choose option
                 */
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxGender[0]")).click();
        WebElement option = driver.findElement(By.xpath("//div[@class = \"pass--inp--drop onward_gender\" ]//div[text()=\""+Gender+"\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        option.click();
        //============ Type Age  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxAge[0]")).sendKeys(age);
        //============ Choose concession  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxConcessionType[0]")).click();
         option = driver.findElement(By.xpath("//div[text()=\""+Concession+"\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        option.click();
        //============ Choose Id Card Type  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxIDCardType[0]")).click();
        option = driver.findElement(By.xpath("//div[text()=\""+CardType+"\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        option.click();
        //============ Type ID Card number  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxIDCardNo[0]")).sendKeys(CardNo);
        //============ Choose country  ==============
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("paxNationality[0]")).click();
        option = driver.findElement(By.xpath("//div[text()=\""+Country+"\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        option.click();

    }

    public ReviewBookingPage clickCheckout(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(CheckoutBtn).click();
        return new ReviewBookingPage(driver);
    }
}
