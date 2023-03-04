package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/Shared/AtumationProjects/seleniumCucumberFramework/Features/GoogleSearch.feature",
        glue = "stepDefinitions"
)
public class TestRunner {
}
