package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class CreateBookStepDefinitions {
    public Response response;
    private RequestSpecification requestSpecification;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");
    private final String USER = environmentVariables.getProperty("api.user.username");
    private final String USER_PASSWORD = environmentVariables.getProperty("api.user.password");
    private final String ADMIN = environmentVariables.getProperty("api.admin.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("api.admin.password");

    @Given("user as {string}")
    public void userAs(String role) {
        requestSpecification = SerenityRest.given().baseUri(BASE_URL);

        if ("admin".equalsIgnoreCase(role)) {
            requestSpecification.auth().basic(ADMIN, ADMIN_PASSWORD);
        } else if ("user".equalsIgnoreCase(role)) {
            requestSpecification.auth().basic(USER, ADMIN_PASSWORD);
        }
    }

    @When("send request to create book with {int},{string},{string}")
    public void sendRequestToCreateBookWithId(int id, String title, String author) {
        final String REQUEST_BODY =
                """
                        {
                            "id":%d,
                            "title":"%s",
                            "author":"%s"
                        }
                        """;
        response = requestSpecification.when().header("Content-Type", "application/json").body(REQUEST_BODY.formatted(id, title, author)).post("api/books");

    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        int actualStatusCode = response.getStatusCode();
        assert actualStatusCode == expectedStatus : System.out.printf("Expected status code %d but got %d", expectedStatus, actualStatusCode);

    }

    @Given("request payload with")
    public void requestPayloadWith(String requestBody) {
        requestSpecification = SerenityRest.given().baseUri(BASE_URL).auth().basic(USER, USER_PASSWORD).body(requestBody);
    }

    @When("method POST with endpoint {string}")
    public void methodPOSTWithEndpoint(String endpoint) {
        response = requestSpecification.when().header("Content-Type", "application/json").post("api" + endpoint);
    }

    @Then("status {int}")
    public void responseForPostDuplicate(int statusCode) {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());

    }
}
