package MyTestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  //settings for your test
        features = "C:\\Users\\mdube\\Documents\\Selenium-Training\\src\\main\\java\\Features", //The path of the feature files
        glue = {"StepDefinition"}, //The path of the step definition
        format = {"pretty", "html:test-report"},//shows detailed info on the console and generates report
        monochrome =  true
)
public class TestRunner {
}
