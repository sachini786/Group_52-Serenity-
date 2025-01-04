package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginAction extends UIInteractionSteps {

    LoginPageObject loginPageObject;
    @Step("Login as a user")
    public void loginWithUsernameAndPassword(String username, String password) {
        loginPageObject.loginWithUsernameAndPassword(username,password);
    }

}