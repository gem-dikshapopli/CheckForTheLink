package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature"
        ,glue = "stepdefinition"
        ,tags = "@test1"
        ,monochrome = true
        ,publish = true
)
public class TestRunner {
}
