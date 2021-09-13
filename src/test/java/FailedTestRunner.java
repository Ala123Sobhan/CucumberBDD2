

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"@target/failedRerun.txt"},
        glue = "stepdef",
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/failedRerun.txt"
        }
)


public class FailedTestRunner extends  AbstractTestNGCucumberTests {

}
