package code.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", //this is for feature files path
        glue = "code/stepDefinition", //this is for steps path
        tags = "@TC5",
        dryRun = false // when it is true it will check if there is any undefined steps

)

public class TestRunner {
}
