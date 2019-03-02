package du.rock.paper.scissors;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"du.rock.paper.scissors.steps"},
        strict = true,
        plugin = {"pretty", "html:build/cucumber-html-report"})
public class CTTests {
}
