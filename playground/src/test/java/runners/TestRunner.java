package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    tags = "@nasa"
)
public class TestRunner {

}