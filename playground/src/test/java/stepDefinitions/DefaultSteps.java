package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class DefaultSteps {
    private static final Logger logger = Logger.getLogger(DefaultSteps.class);
    private Response response;

    private Integer weight;

    @Before("@pokemon")
    public void setDefaultPathForPokemon() {
        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
    }
    @Given("^I request info about (.*) pokemon$")
    public void i_request_url(String pokemon) {
        String path = "pokemon/"+pokemon;
        response = RestAssured.get(path);
        logger.info("requested "+path);
    }
    @When("^I get weight from the response$")
    public void i_get_cookies_from_response() {
        weight = response.path("weight");
        logger.info("weight is "+ weight);
    }

    @Then("I see that weight is {int}")
    public void iSeeThatWeightIs(Integer weight) {
        Assert.assertEquals(this.weight,weight);
    }
}
