package org.example.stepdefinitions;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;

public class AuthStepDefinitions {

    private static final String BASE_URL = "http://localhost:7081/api";
    @Given("I am a normal user")
    public void iAmANormalUser() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password");
    }

    @Given("I am an admin user")
    public void iAmAnAdminUser() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("admin","password");
    }
}
