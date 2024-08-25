package hooks;

import base.BaseTests;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;

public class Hooks  extends BaseTests {

    @BeforeAll
    public static void before_all(){
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        driver = new EdgeDriver();
       // driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().maximize();
        driver.get(KSRTC_URL);
        homePage = new HomePage(driver);
    }

    @AfterAll
    public static void after_all() {
           driver.quit();
    }

}
