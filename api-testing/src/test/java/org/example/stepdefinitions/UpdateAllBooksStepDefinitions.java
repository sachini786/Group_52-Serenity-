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

public class UpdateAllBooksStepDefinitions {
    public Response response;
    private RequestSpecification requestSpecification;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");
    private final String USER = environmentVariables.getProperty("api.user.username");
    private final String USER_PASSWORD = environmentVariables.getProperty("api.user.password");
    private final String ADMIN = environmentVariables.getProperty("api.admin.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("api.admin.password");
    private final int bookID = HookDefinitions.getCreatedBookIDForUpdate();

    @When("I send a PUT request to update a book")
    public void iSendRequestToUpdateBook() {
        String requestBody = """
                {
                "id": %d,
                "title": "updated book title",
                "author": "Updated author"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("api/books/" + bookID);
    }

    @When("I send a PUT request to update a book with missing mandatory fields")
    public void iSendRequestToUpdateBooksWithMissingFields() {
        String requestBody = """
                {
                "id": %d,
                "author": "Updated author"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("api/books/" + bookID);
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBeExact(Integer expectedStatusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(expectedStatusCode));
    }

    @Given("User need to update a book as an admin")
    public void userNeedToUpdateABookAsAnAdmin() {

        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(ADMIN, ADMIN_PASSWORD)
        ;
    }

    @Given("User need to update a book as an normal user")
    public void userNeedToUpdateABookAsAnNormalUser() {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(USER, USER_PASSWORD)
        ;
    }

    @When("I send a request with an empty string value")
    public void iSendARequestWithAnEmptyStringValueWithID() {
        String requestBody = """
                {
                "id": %d,
                "title": "",
                "author": "Rowan"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("api/books/" + bookID);
    }
}


