package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.example.hooks.HookDefinitions;

public class EdgeCasesStepDefinitions {

    private Response response;

    private int createBookId = HookDefinitions.getCreatedBookIDForUpdate();
    private RequestSpecification requestSpecification;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");
    private final String USER = environmentVariables.getProperty("api.user.username");
    private final String USER_PASSWORD = environmentVariables.getProperty("api.user.password");

    @Given("user needs to get all the authors")
    public void userNeedsToGetAllTheAuthors() {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(USER, USER_PASSWORD);
    }

    @When("user send request to get all authors")
    public void userSendRequestToGetAllAuthors() {
        response = requestSpecification.when().get("/api/authors");
    }

    @Then("the edge case response status should be {int}")
    public void theEdgeCaseResponseStatusShouldBeThe(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }

    @Given("user need to create a book with extra field")
    public void userNeedToCreateABookWithExtraField() {
        String requestBody = """
                {
                    "title": "Update Book title01",
                    "author": "rowan atkinson",
                    "registration": "ISBN0032"
                }
                """;
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(USER, USER_PASSWORD).body(requestBody);
    }

    @When("user send request to create book")
    public void userSendRequestToCreateBook() {
        response = requestSpecification.given()
                .header("Content-Type", "application/json")
                .when()
                .post("api/books");
    }

    @Given("user need to authenticate using {string} and {string}")
    public void UsernameAndPassword(String username, String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);

    }

    @When("user send a DELETE request to delete a book with invalid ID format {string}")
    public void sendRequestToDeleteBooksWithInvalidID(String invalidFormatBookId) {
        response = requestSpecification.when()
                .delete("api/books/" + invalidFormatBookId);
    }
}