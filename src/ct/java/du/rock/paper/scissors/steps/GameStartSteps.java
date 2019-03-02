package du.rock.paper.scissors.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameStartSteps {

    @Value("${app.url}/game-start")
    private String gameStartUrl;

    @When("^An id is given to start the game$")
    public Response callGameStart() {
        return given().when().get(gameStartUrl+"/gameId").then().extract().response();
    }

    @Then("^A 201 status code should be returned$")
    public void checkGameStartStatusCode() {
        assertThat(callGameStart().statusCode(), is(equalTo(HttpStatus.CREATED.value())));
    }


}
