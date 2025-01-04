package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.CommonPageObject;


public class CommonAction extends UIInteractionSteps {

    CommonPageObject commonPageObject;

    @Step("get page url")
    public String getUrl() {
        return commonPageObject.getUrl();
    }

    @Step("wait for milliseconds")
    public void pause(int milliseconds) {
        commonPageObject.pause(milliseconds);
    }

    @Step("wait success message")
    public void waitUntilSuccessMessage() {
        commonPageObject.waitUntilSuccessMessage();
    }
}

