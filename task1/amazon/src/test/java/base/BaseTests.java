package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import pages.HomePage;


public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected final String amazonURL = "https://www.amazon.com/";

    public void setUp() throws InterruptedException {
        System.out.println("Before Base Class");
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(amazonURL);
        Thread.sleep(10000);
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
