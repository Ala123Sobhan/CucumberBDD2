import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdef",
        monochrome=true,
       // tags = "@signuptest",
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/failedRerun.txt"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}