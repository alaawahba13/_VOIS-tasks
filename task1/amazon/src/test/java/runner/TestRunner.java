package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps","hooks"},
        tags = "@FilterAndAddToCart"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
