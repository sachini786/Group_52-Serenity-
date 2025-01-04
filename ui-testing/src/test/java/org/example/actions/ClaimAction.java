package org.example.actions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.ClaimPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    ClaimPageObject claimPageObject;

    @Step("click assign claim")
    public void clickAssignClaim() {
        claimPageObject.clickAssignClaim();
    }

    @Step("select employee name")
    public void selectEmployeeName(String employeeName) {
        claimPageObject.selectEmployeeName(employeeName);
    }

    @Step("select event")
    public void selectEvent(String event) {
        claimPageObject.selectEvent(event);
    }

    @Step("select currency")
    public void selectCurrency(String currency) {
        claimPageObject.selectCurrency(currency);
    }

    @Step("click submit")
    public void clickSubmit() {
        claimPageObject.clickSubmit();
    }

    @Step("select event to search")
    public void selectEventToSearch(String event) {
        claimPageObject.selectEventToSearch(event);
    }

    @Step("select event to search")
    public void selectStatusToSearch(String status) {
        claimPageObject.selectStatusToSearch(status);
    }

    @Step("click search")
    public void clickSearch() {
        claimPageObject.clickSubmit();
    }

    @Step("validate if the table has claim")
    public void validateIfTableHasClaim(String employeeName, String eventName, String currencyName, String statusName) {

        boolean rowFound = claimPageObject.validateIfTableHasClaim(employeeName,eventName,currencyName,statusName);

        assertThat(rowFound)
                .as("Row with Employee Name: %s, Event: %s,Currency: %s, Status: %s should exist", employeeName, eventName, currencyName, statusName)
                .isTrue();
    }

}
