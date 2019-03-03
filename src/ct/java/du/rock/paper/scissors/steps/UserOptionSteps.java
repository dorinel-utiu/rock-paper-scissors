package du.rock.paper.scissors.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserOptionSteps {

    @Value("${app.url}/user-option")
    private String userOptionUrl;

    private Response response;

    @When("^User selects '(.+)' as option for game '(.+)'$")
    public void userOption(String option, String gameId) {
        response = given().when().post(userOptionUrl + "/" + gameId + "/" + option).then().extract().response();
    }

    @Then("^A '(.+)' response status code should be returned$")
    public void selectOptionStatusCode(int statusCode) {
        assertThat(response.statusCode(), is(equalTo(statusCode)));
    }
}
