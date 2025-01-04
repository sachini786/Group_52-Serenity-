package org.example.pageobjects;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class TimePageObject extends PageObject {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    private final By projectInfoButton = By.xpath("//span[contains(text(), 'Project Info')]");
    private final By projectsButton = By.xpath("//li/a[@role='menuitem' and contains(text(), 'Projects')]");
    private final By addButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(., 'Add')]");
    private final By projectNameInputField = By.xpath("//label[contains(text(),'Name')]/following::input[1]");
    private final By customerInputField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/input");
    private final By customerNameDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]");
    private final By customerNameSpan = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div/span");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By customerInputFieldForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
    private final By customerNameDropdownForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
    private final By customerNameSpanForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span");
    private final By projectNameInputFieldForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private final By projectNameDropdownForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]");
    private final By projectNameSpanForSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/span");
    private final By searchResultsTableRow = By.cssSelector(".oxd-table-row");
    private final By projectSpanInTable = By.xpath(".//div[3]");
    private final By customerSpanInTable = By.xpath(".//div[2]");

    public void clickProjectInfo() {
        $(projectInfoButton).click();
    }

    public void clickProjects() {
        $(projectsButton).click();
    }

    public void clickAdd() {
        $(addButton).click();
    }

    public void enterProjectName(String projectName) {
        $(projectNameInputField).sendKeys(projectName);
    }

    public void selectCustomerName(String customerName) {
        $(customerInputField).sendKeys(customerName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameDropdown));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameSpan));
        firstElement.click();
    }

    public void clickSubmit() {
        $(submitButton).click();
    }

    public void selectCustomerNameForSearch(String customerName) {
        $(customerInputFieldForSearch).sendKeys(customerName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameDropdownForSearch));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameSpanForSearch));
        firstElement.click();
    }

    public void enterProjectNameForSearch(String projectName) {
        $(projectNameInputFieldForSearch).sendKeys(projectName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectNameDropdownForSearch));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(projectNameSpanForSearch));
        firstElement.click();
    }

    public void validateIfTableHasProject(String projectName, String customerName) {
        ListOfWebElementFacades rows = findAll(searchResultsTableRow);

        boolean rowFound = rows.stream().anyMatch(row -> {

            String project = row.findElement(projectSpanInTable).getText();
            String customer = row.findElement(customerSpanInTable).getText();
            return project.equals(projectName) && customer.equals(customerName);
        });

        assertThat(rowFound)
                .as("Row with Project Name: %s & Customer Name : %s is exist", projectName, customerName)
                .isTrue();
    }
}
