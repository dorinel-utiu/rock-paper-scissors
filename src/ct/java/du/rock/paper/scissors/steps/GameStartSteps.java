package du.rock.paper.scissors.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameStartSteps {

    @Value("${app.url}/game-start")
    private String gameStartUrl;

    private Response response;

    @When("^An '(.+)' is given to start the game$")
    public void callGameStart(String gameId) {
        response = given().when().post(gameStartUrl + "/" + gameId).then().extract().response();
    }

    @Then("^A '(.+)' status code should be returned$")
    public void checkGameStartStatusCode(int statusCode) {
        assertThat(response.statusCode(), is(equalTo(statusCode)));
    }


}
