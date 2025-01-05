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

public class DeleteBookStepDefinitions {

    public Response response;
    private RequestSpecification requestSpecification;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");

    @Given("user authenticate using {string} and {string}")
    public void userAuthentication(String username, String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);
    }

    @When("I send a DELETE request to delete a book with valid ID")
    public void sendRequestToDeleteBooksWithValidId() {
        int validBookId = HookDefinitions.getCreatedBookIDForDelete();
        response = requestSpecification.when()
                .delete("api/books/" + validBookId);
    }

    @When("I send a DELETE request to delete a book with non-existing {int}")
    public void sendRequestToDeleteBooksWithNonExistingId(int nonExistingBookId) {
        response = requestSpecification.when()
                .delete("api/books/" + nonExistingBookId);
    }

    @Then("Delete response status should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(statusCode));
    }
}
