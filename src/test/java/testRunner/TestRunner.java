package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "C://Cucumber-RestAssured-master//Calculator//Features//Calsi.feature",
        glue = "stepDefinitions",
        publish = true
)

public class TestRunner {

}
