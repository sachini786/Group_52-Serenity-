package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.TimePageObject;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    TimePageObject timePageObject;

    @Step("Click the 'Projects' under 'Project Info'")
    public void clickProjectsUnderProjectInfo() {
        timePageObject.clickProjectInfo();
        timePageObject.clickProjects();
    }

    @Step("click add")
    public void clickAdd() {
        timePageObject.clickAdd();
    }

    @Step("select project name")
    public void selectProjectName(String projectName) {
        timePageObject.enterProjectName(projectName);
    }

    @Step("select customer name")
    public void selectCustomerName(String customerName) {
        timePageObject.selectCustomerName(customerName);
    }

    @Step("click submit")
    public void clickSubmit() {
        timePageObject.clickSubmit();
    }

    @Step("select customer name for search")
    public void selectCustomerNameForSearch(String customerName) {
        timePageObject.selectCustomerNameForSearch(customerName);
    }

    @Step("select project name for search")
    public void selectProjectNameForSearch(String projectName) {
        timePageObject.enterProjectNameForSearch(projectName);
    }

    @Step("validate search results")
    public void validateIfTableHasProject(String projectName, String customerName) {
        timePageObject.validateIfTableHasProject(projectName, customerName);
    }
}