package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.actions.CommonAction;

public class CommonStepDefinitions {
    CommonAction commonAction;
    @Then("user expect success message")
    public void userExpectSuccessMessage() {
        commonAction.waitUntilSuccessMessage();
    }
}
