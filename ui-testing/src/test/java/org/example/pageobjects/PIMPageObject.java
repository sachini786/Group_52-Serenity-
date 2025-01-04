package org.example.pageobjects;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPageObject extends PageObject {
    private final By addButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and text()=' Add ']");
    private final By firstNameInput = By.xpath("//input[@name='firstName']");
    private final By lastNameInput = By.xpath(("//input[@name='lastName']"));
    private final By createButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and text()=' Save ']");
    private final By displayPage = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and text()=' Save ']");
    private final By clickSearchButton = By.xpath("//button[@type='submit']");
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    private final By personalDetailFormTitle = By.xpath("//h6[@data-v-7b563373='' and @data-v-af86f9aa='']");
    private final By employeeNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
    private final By employeeNameDropDown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div");
    private final By employeeNameSpan = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span");
    private final By tableRow = By.cssSelector(".oxd-table-row");
    private final By tableRowColumn3 = By.xpath(".//div[3]");
    private final By tableRowColumn4 = By.xpath(".//div[4]");

    public void clickAdd() {
        $(addButton).click();
    }

    public void selectEmployeeFirstName(String firstName) {
        $(firstNameInput).type(firstName);
    }

    public void selectEmployeeLastName(String lastName) {
        $(lastNameInput).type(lastName);
    }

    public void clickCreateEmployee() {
        $(createButton).click();
    }

    public void displayPersonalDetailsPage() {
        $(displayPage).click();
    }

    public void waitPersonalDetailForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailFormTitle));
    }

    public void clickSearch() {
        $(clickSearchButton).click();
    }

    public void enterEmployeeName(String employeeName) {
        $(employeeNameInput).sendKeys(employeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameDropDown));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameSpan));
        firstElement.click();
    }

    public boolean validateIfTableHasEmployee(String firstName, String lastName) {
        ListOfWebElementFacades rows = findAll(tableRow);
        return rows.stream().anyMatch(row -> {
            String employeeFirstName = row.findElement(tableRowColumn3).getText();
            String employeeLastName = row.findElement(tableRowColumn4).getText();
            return employeeFirstName.equals(firstName) && employeeLastName.equals(lastName);
        });
    }
}
