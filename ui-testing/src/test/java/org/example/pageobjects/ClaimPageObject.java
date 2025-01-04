package org.example.pageobjects;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaimPageObject extends PageObject {

    private final By assignClaimButton = By.xpath("//button[contains(., 'Assign Claim')]");
    private final By claimPageLink = By.xpath("//a[@href='/web/index.php/claim/viewClaimModule']");
    private final By employeeNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input");
    private final By employeeNamesDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div[2]");
    private final By employeeNameSpan = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div[2]/div/span");
    private final By eventDropdown = By.xpath("//label[contains(text(),'Event')]/following::div[contains(@class,'oxd-select-text-input')]");
    private final By currencyDropdown = By.xpath("//label[contains(text(),'Currency')]/following::div[contains(@class,'oxd-select-text-input')]");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By eventDropdownInSearch = By.xpath("//label[contains(text(),'Event Name')]/following::div[contains(@class,'oxd-select-text-input')]");
    private final By statusDropdownInSearch = By.xpath("//label[contains(text(),'Status')]/following::div[contains(@class,'oxd-select-text-input')]");
    private final By tableRow = By.cssSelector(".oxd-table-row");
    private final By tableRowColumn2 = By.xpath(".//div[2]");
    private final By tableRowColumn3 = By.xpath(".//div[3]//span");
    private final By tableRowColumn5 = By.xpath(".//div[5]");
    private final By tableRowColumn7 = By.xpath(".//div[7]");
    private final String EVENT_SPAN_XPATH = "//div[@role='listbox']//span[contains(text(),'%s')]";
    private final String CURRENCY_SPAN_XPATH = "//div[@role='listbox']//span[contains(text(),'%s')]";
    private final String EVENT_SPAN_XPATH_IN_SEARCH = "//div[@role='listbox']//span[contains(text(),'%s')]";
    private final String STATUS_SPAN_XPATH_IN_SEARCH = "//div[@role='listbox']//span[contains(text(),'%s')]";

    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public void clickAssignClaim() {
        $(assignClaimButton).click();
    }

    public void toOrangeHRMClaimPage() {
        $(claimPageLink).click();
    }

    public void selectEmployeeName(String employeeName) {
        $(employeeNameInput).sendKeys(employeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNamesDropdown));
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameSpan)).click();
    }

    public void selectEvent(String event) {
        $(eventDropdown).click();
        $(By.xpath(EVENT_SPAN_XPATH.formatted(event))).click();
    }

    public void selectCurrency(String currency) {
        $(currencyDropdown).click();
        $(By.xpath(CURRENCY_SPAN_XPATH.formatted(currency))).click();
    }

    public void clickSubmit() {
        $(submitButton).click();
    }

    public void selectEventToSearch(String event) {
        $(eventDropdownInSearch).click();
        $(By.xpath(EVENT_SPAN_XPATH_IN_SEARCH.formatted(event))).click();
    }

    public void selectStatusToSearch(String status) {
        $(statusDropdownInSearch).click();
        $(By.xpath(STATUS_SPAN_XPATH_IN_SEARCH.formatted(status))).click();
    }

    public boolean validateIfTableHasClaim(String employeeName, String eventName, String currencyName, String statusName) {
        ListOfWebElementFacades rows = findAll(tableRow);

        return rows.stream().anyMatch(row -> {
            String employee = row.findElement(tableRowColumn2).getText();
            String event = row.findElement(tableRowColumn3).getText();
            String currency = row.findElement(tableRowColumn5).getText();
            String status = row.findElement(tableRowColumn7).getText();
            return employee.equals(employeeName) && currency.equals(currencyName) && event.equals(eventName) && status.equals(statusName);
        });
    }
}
