package org.example.actions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @Step("Click the 'Projects' under 'Project Info'")
    public void clickProjectsUnderProjectInfo() {

        $(By.xpath("//span[contains(text(), 'Project Info')]")).click();

        $(By.xpath("//li/a[@role='menuitem' and contains(text(), 'Projects')]")).click();
    }
    @Step("click add")
    public void clickAdd() {
        $(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(., 'Add')]")).click();
    }

    @Step("select project name")
    public void selectProjectName(String projectName){
        $(By.xpath("//label[contains(text(),'Name')]/following::input[1]")).sendKeys(projectName);
    }

    @Step("select customer name")
    public void selectCustomerName(String customerName){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/input")).sendKeys(customerName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div/span")));
        firstElement.click();
    }

    @Step("click submit")
    public void clickSubmit(){
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("select customer name for search")
    public void selectCustomerNameForSearch(String customerName){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys(customerName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span")));
        firstElement.click();
    }

    @Step("select project name for search")
    public void selectProjectNameForSearch(String projectName){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys(projectName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/span")));
        firstElement.click();
    }

    @Step("validate search results")
    public void validateIfTableHasProject(String projectName,String customerName){

        ListOfWebElementFacades rows = findAll(By.cssSelector(".oxd-table-row"));

        boolean rowFound = rows.stream().anyMatch(row -> {
            String project = row.findElement(By.xpath(".//div[3]")).getText();
            String customer = row.findElement(By.xpath(".//div[2]")).getText();
            return project.equals(projectName) && customer.equals(customerName);
        });

        assertThat(rowFound)
                .as("Row with Project Name: %s & Customer Name : %s is exist", projectName, customerName)
                .isTrue();
    }

}