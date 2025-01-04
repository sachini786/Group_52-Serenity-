package org.example.actions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class PIMAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @Step("click Add PIM")
    public void clickAdd() {
        $(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and text()=' Add ']")).click();
    }

    @Step("select employee First Name")
    public void SelectEmployeeFirstName(String firstName) {
        $(By.xpath("//input[@name='firstName']")).type(firstName);
    }

    @Step("select employee last Name")
    public void SelectEmployeeLastName(String lastName) {
        $(By.xpath(("//input[@name='lastName']"))).type(lastName);
    }

    @Step("click the button")
    public void clickCreate() {
        $(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and text()=' Save ']")).click();
    }

    @Step("display the PersonalDetailsPage")
    public void PersonalDetailsPage() {
        $(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and text()=' Save ']")).click();
    }

    @Step("wait for personal detail form")
    public void waitPersonalDetailForm() {
        By waitPersonalDetailForm = By.xpath("//h6[@data-v-7b563373='' and @data-v-af86f9aa='']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitPersonalDetailForm));
    }

    @Step("enter EnterEmployee Name to search")
    public void EnterEmployeeName(String firstName, String lastName) {
        String employeeName = firstName + " " + lastName;
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys(employeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span")));
        firstElement.click();
    }

    @Step("click search")
    public void clickSearch() {
        $(By.xpath("//button[@type='submit']")).click();
    }

    public void validateIfTableHasEmployee(String firstName, String lastName) {
        ListOfWebElementFacades rows = findAll(By.cssSelector(".oxd-table-row"));

        boolean rowFound = rows.stream().anyMatch(row -> {
            String employeeFirstName = row.findElement(By.xpath(".//div[3]")).getText();
            String employeeLastName = row.findElement(By.xpath(".//div[4]")).getText();
            return employeeFirstName.equals(firstName) && employeeLastName.equals(lastName);
        });
        assertThat(rowFound)
                .as("Row with Employee Name: %s %s", firstName, lastName)
                .isTrue();
    }
}
