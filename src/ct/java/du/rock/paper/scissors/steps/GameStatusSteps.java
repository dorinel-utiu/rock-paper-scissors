package du.rock.paper.scissors.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameStatusSteps {

    @Value("${app.url}/game-status")
    private String gameStatusUrl;

    private Response response;

    @When("^User calls game status for game '(.+)'$")
    public void gameStatus(String gameId) {
        response = given().when().get(gameStatusUrl + "/" + gameId).then().extract().response();
    }

    @Then("^Game status with status code '(.+)' should be returned$")
    public void gameStatusCode(int statusCode) {
        assertThat(response.statusCode(), is(equalTo(statusCode)));
    }
}
