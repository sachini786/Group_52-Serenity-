package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageobjects.PIMPageObject;

import static org.assertj.core.api.Assertions.assertThat;

public class PIMAction extends UIInteractionSteps {
    PIMPageObject pimPageObject;

    @Step("click Add PIM")
    public void clickAdd() {
        pimPageObject.clickAdd();
    }

    @Step("select employee First Name")
    public void SelectEmployeeFirstName(String firstName) {
        pimPageObject.selectEmployeeFirstName(firstName);
    }

    @Step("select employee last Name")
    public void SelectEmployeeLastName(String lastName) {
        pimPageObject.selectEmployeeLastName(lastName);
    }

    @Step("click the button")
    public void clickCreate() {
        pimPageObject.clickCreateEmployee();

    }

    @Step("display the PersonalDetailsPage")
    public void PersonalDetailsPage() {
        pimPageObject.displayPersonalDetailsPage();

    }

    @Step("wait for personal detail form")
    public void waitPersonalDetailForm() {
        pimPageObject.waitPersonalDetailForm();

    }

    @Step("enter EnterEmployee Name to search")
    public void EnterEmployeeName(String firstName, String lastName) {
        String employeeName = firstName + " " + lastName;
        pimPageObject.enterEmployeeName(employeeName);
    }

    @Step("click search")
    public void clickSearch() {
        pimPageObject.clickSearch();

    }

    public void validateIfTableHasEmployee(String firstName, String lastName) {
        boolean rowFound = pimPageObject.validateIfTableHasEmployee(firstName, lastName);
        assertThat(rowFound)
                .as("Row with Employee Name: %s %s", firstName, lastName)
                .isTrue();
    }
}
