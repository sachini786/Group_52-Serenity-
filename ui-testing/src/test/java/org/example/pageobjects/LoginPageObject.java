package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPageObject extends PageObject {
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final String LOGIN_PAGE_URL = "https://opensource-demo.orangehrmlive.com/";

    public void loginWithUsernameAndPassword(String username, String password) {
        $(usernameInput).sendKeys(username);
        $(passwordInput).sendKeys(password, Keys.ENTER);
    }

    public void toOrangeHRMLoginPage() {
        openUrl(LOGIN_PAGE_URL);
    }
}
