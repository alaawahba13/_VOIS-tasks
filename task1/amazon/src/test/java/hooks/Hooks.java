package hooks;

import base.BaseTests;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;

public class Hooks extends BaseTests {
    @BeforeAll
    public static void setUp() throws InterruptedException {
        System.out.println("Before Base Class");
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get(amazonURL);
//        Thread.sleep(10000);
        homePage = new HomePage(driver);
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
