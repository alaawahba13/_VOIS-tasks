package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"steps","hooks"},
        tags = "@BookTicket"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
