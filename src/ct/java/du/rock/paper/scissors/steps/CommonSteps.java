package du.rock.paper.scissors.steps;

import cucumber.api.java.en.Given;
import du.rock.paper.scissors.config.CTConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.when;

@ContextConfiguration(
        classes = CTConfig.class)
public class CommonSteps {

    @Value("${app.health}")
    private String healthEndpoint;

    @Given("^The application is up and running$")
    public void checkAppIsUpAndRunning() {
        when().get(healthEndpoint).then().statusCode(200);
    }
}
