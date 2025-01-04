package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @Step("Click the 'Projects' under 'Project Info'")
    public void clickProjectsUnderProjectInfo() {

        $(By.xpath("//span[contains(text(), 'Project Info')]")).click();

        $(By.xpath("//li/a[@role='menuitem' and contains(text(), 'Projects')]")).click();
    }
    @Step("click create")
    public void clickAdd() {
        $(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(., 'Add')]")).click();
    }

    @Step("select project name")
    public void selectProjectName(String projectName){
        $(By.xpath("//label[contains(text(),'Name')]/following::input[1]")).sendKeys(projectName);
    }

    @Step("select customer name")
    public void selectCustomerName(String customerName){
        //$(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(customerName, Keys.ARROW_DOWN, Keys.ENTER);

        $(By.xpath("//label[contains(text(),'Customer Name')]/following::input[1]")).sendKeys(customerName, Keys.ARROW_DOWN,Keys.ENTER);
       //$(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/input")).sendKeys("Apa");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]")));
//        WebElement firstELement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div")));
//        firstELement.click();
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", customerName))).click();
    }

    @Step("click create")
    public void clickSave(){
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("wait for projects form")
    public void waitUntilEditForm(){
        By editProjectTitle = By.xpath("//h6[contains(@class, 'oxd-text--h6') and contains(@class, 'orangehrm-main-title') and text()='Edit Project']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProjectTitle));
        $(By.xpath("//button[@type='submit']")).click();
        By projectsTitle = By.xpath("//h5[contains(@class, 'oxd-text--h5') and contains(@class, 'oxd-table-filter-title') and text()='Projects']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectsTitle));

    }
    @Step("click seacrch")
    public void clickSearch(){
        $(By.xpath("//button[@type='submit' and contains(., 'Search')]")).click();
    }

    @Step("select customer name for search")
    public void selectCustomerNameForSearch(String customerName){
        //$(By.xpath("//div[contains(@class,'oxd-autocomplete-text-input--active')]/input[@placeholder='Type for hints...']")).sendKeys(customerName, Keys.ARROW_DOWN, Keys.ENTER);
        //$(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/input")).sendKeys("Apa");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]")));
//        WebElement firstELement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div")));
//        firstELement.click();
        //$(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", customerName))).click();

        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span")));
        firstElement.click();
    }

    @Step("select project name for search")
    public void selectProjectNameForSearch(String projectName){
        $(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(projectName);
    }

}