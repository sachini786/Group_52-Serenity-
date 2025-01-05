package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.example.models.Book;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetBookByIDStepDefinitions {
    private Response response;
    private int createBookId;
    private RequestSpecification requestSpecification;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");
    private final String USER = environmentVariables.getProperty("api.user.username");
    private final String USER_PASSWORD = environmentVariables.getProperty("api.user.password");
    private final String ADMIN = environmentVariables.getProperty("api.admin.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("api.admin.password");

    @Given("user authenticate using by {string} and {string} wants to retrieve the book with valid ID")
    public void userUsernameAndPassword(String username, String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);
    }

    @Given("admin user wants to get book the ID is valid")
    public void adminUserWantsToGetBookWithValidID() {
        userUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
    }

    @Given("regular user wants to get book the ID is valid")
    public void regularUserWantsToGetBookWithValidID() {
        userUsernameAndPassword(USER, USER_PASSWORD);
    }

    @Given("admin user wants to get a non-existent book")
    public void adminUserWantsToGetNonExistentBook() {
        userUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
    }

    @Given("regular user wants to get a non-existent book")
    public void regularUserWantsToGetNonExistentBook() {
        userUsernameAndPassword(USER, USER_PASSWORD);
    }

    @Given("admin user wants to get a book with an invalid ID")
    public void adminUserWantsToGetBookWithInvalidID() {
        userUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
    }

    @Given("regular user wants to get a book with an invalid ID")
    public void regularUserWantsToGetBookWithInvalidID() {
        userUsernameAndPassword(USER, USER_PASSWORD);
    }

    @Given("the book exists")
    public void hasBooks() {
        userUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
        final String REQUEST_BODY = """
                    {
                        "title": "Harry Potter",
                        "author": "JK Rolling"
                    }
                """;

        createBookId = requestSpecification
                .body(REQUEST_BODY)
                .header("Content-Type", "application/json")
                .post("/api/books").getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();
        System.out.println("Created Book ID: " + createBookId);
    }

    @After("@ValidIdFormat-Admin")
    public void afterBooksExistScenario1() {
        userUsernameAndPassword(USER, USER_PASSWORD);
        requestSpecification.when()
                .delete("/api/books/" + createBookId);
    }

    @After("@ValidIdFormat-RegularUser")
    public void afterBooksExistScenario2() {
        userUsernameAndPassword(USER, USER_PASSWORD);
        requestSpecification.when()
                .delete("/api/books/" + createBookId);
    }

    @When("user calls service to get the book with ID")
    public void userCallsServiceToGetBookWithID() {
        response = requestSpecification.when().get("/api/books/" + createBookId);
    }

    @When("user calls service to get the book with ID {int}")
    public void userCallsServiceToGetBookWithSpecificID(int bookId) {
        response = requestSpecification.when().get("/api/books/" + bookId);
    }

    @When("user calls service to get the book with ID {string}")
    public void userCallsServiceToGetBookWithInvalidID(String bookId) {
        response = requestSpecification.when().get("/api/books/" + bookId);
    }

    @Then("user expects response status to be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("user expects response should contain the book details with ID")
    public void responseShouldContainBookDetails() {
        response.then()
                .body("id", equalTo(createBookId))
                .body("title", notNullValue())
                .body("author", notNullValue());
    }

    @Then("user expects response should contain a {string} message")
    public void responseShouldContainMessage(String expectedMessage) {
        response.then().body(equalTo(expectedMessage));
    }
}
