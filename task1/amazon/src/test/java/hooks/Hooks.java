package hooks;

import base.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterClass;

public class Hooks extends BaseTests {
    @After
    public void tearDown() {
        driver.quit();
    }

}
