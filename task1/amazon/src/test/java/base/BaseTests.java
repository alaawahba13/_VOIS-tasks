package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;


public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        driver = new EdgeDriver();
        goToHomePage();
        Thread.sleep(10000);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goToHomePage()  {
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {
       driver.quit();
    }

}
