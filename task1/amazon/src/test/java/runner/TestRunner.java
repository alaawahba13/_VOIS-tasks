package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;



@CucumberOptions(
       // plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/"},
        glue = {"steps"},
        tags = "@LoginScenario"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Test Runner Class");
    }
}
