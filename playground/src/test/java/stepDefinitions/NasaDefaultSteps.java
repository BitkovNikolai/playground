package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import models.Apod;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class NasaDefaultSteps {
    String API_KEY = "T8MSoflw362caPjbBF7ZgraYmgmcCHUjQWTJoQnP";
    private static final Logger logger = Logger.getLogger(PokemonDefaultSteps.class);

    private Apod apod;
    @Before("@nasa")
    public void setDefaultPathForPokemon() {
        RestAssured.baseURI = "https://api.nasa.gov/planetary/";
    }
    @Given("^I request apod from (.*) date$")
    public void i_request_url(String date) {
        String path = "apod/";
        apod = RestAssured
            .given()
            .queryParams("api_key",API_KEY,"date",date)
            .get(path).as(Apod.class);
        logger.info("get apod from date "+date+" with title" + apod.getTitle());
    }
    @Then("I see that date is (.*)")
    public void iSeeThatWeightIs(String date) {

        Assert.assertEquals(apod.getDate(),date);
    }
}
