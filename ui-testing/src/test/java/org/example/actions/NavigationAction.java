package org.example.actions;

import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class NavigationAction extends UIInteractionSteps {
    @Step("Navigate to the login page")
    public void toOrangeHRMLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/");
    }

    @Step("Navigate to Time Page")
    public void toTimePage() {
        $(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']")).click();
    }
}

