package base;

import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class BaseTests {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static final String KSRTC_URL = "https://ksrtc.in/oprs-web/guest/home.do?h=1";
    protected String Email,MobileNo;
}
