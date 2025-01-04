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
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input")).sendKeys(employeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div[2]/div/span")));
        firstElement.click();
    }

    @Step("select event")
    public void selectEvent(String event) {
        $(By.xpath("//label[contains(text(),'Event')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]", event))).click();
    }

    @Step("select currency")
    public void selectCurrency(String currency) {
        $(By.xpath("//label[contains(text(),'Currency')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]", currency))).click();
    }

    @Step("click submit")
    public void clickSubmit() {
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("select event to search")
    public void selectEventToSearch(String event) {
        $(By.xpath("//label[contains(text(),'Event Name')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]", event))).click();
    }

    @Step("select event to search")
    public void selectStatusToSearch(String status) {
        $(By.xpath("//label[contains(text(),'Status')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]", status))).click();
    }

    @Step("click search")
    public void clickSearch() {
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("validate if the table has claim")
    public void validateIfTableHasClaim(String employeeName, String eventName, String currencyName, String statusName) {
        ListOfWebElementFacades rows = findAll(By.cssSelector(".oxd-table-row"));

        boolean rowFound = rows.stream().anyMatch(row -> {
            String employee = row.findElement(By.xpath(".//div[2]")).getText();
            String event = row.findElement(By.xpath(".//div[3]//span")).getText();
            String currency = row.findElement(By.xpath(".//div[5]")).getText();
            String status = row.findElement(By.xpath(".//div[7]")).getText();
            return employee.equals(employeeName) && currency.equals(currencyName) && event.equals(eventName) && status.equals(statusName);
        });

        assertThat(rowFound)
                .as("Row with Employee Name: %s, Event: %s,Currency: %s, Status: %s should exist", employeeName, eventName, currencyName, statusName)
                .isTrue();
    }

}
