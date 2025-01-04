package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.AdminPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAction extends UIInteractionSteps {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    AdminPageObject adminPageObject;

    @Step("Click Add User")
    public void clickAddUser() {
        adminPageObject.clickAddUser();
    }

    @Step("Wait for redirection to Add User page")
    public void waitForRedirectionToAddUser() {
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));
    }

    @Step("Select User Role")
    public void selectUserRole(String userRole) {
        adminPageObject.openUserRoleDropdown();
        adminPageObject.selectUserRoleOption(userRole);
    }

    @Step("Select Status")
    public void selectStatus(String status) {
        adminPageObject.openStatusDropdown();
        adminPageObject.selectStatusOption(status);
    }

    @Step("Select Employee Name")
    public void selectEmployeeName(String employeeName) {
        adminPageObject.enterEmployeeName(employeeName);
        adminPageObject.selectFirstEmployeeNameOption();
    }

    @Step("Enter Username")
    public void userName(String username) {
        adminPageObject.enterUsername(username);
    }

    @Step("Enter Password")
    public void passwordGiven(String password) {
        adminPageObject.enterPassword(password);
    }

    @Step("Enter Confirm Password")
    public void confirmPassword(String confirmPassword) {
        adminPageObject.enterConfirmPassword(confirmPassword);
    }

    @Step("Click Save")
    public void clickSave() {
        adminPageObject.clickSave();
    }

    @Step("Wait for redirection to System Users page")
    public void waitForRedirection() {
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
    }

    @Step("Select the Job Icon")
    public void selectTheJobIcon() {
        adminPageObject.selectJobIcon();
    }

    @Step("Wait for Job Title Page")
    public void waitForJobTitlePage() {
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"));
    }

    @Step("Wait for Job Add Page")
    public void waitForJobAddPage() {
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle"));
    }

    @Step("Click on Add Job in the Job Page")
    public void clickOnAddJobInTheJobPage() {
        adminPageObject.clickAddJob();
    }

    @Step("Fill the Job Title")
    public void fillTheJobTitle(String jobTitle) {
        adminPageObject.enterJobTitle(jobTitle);
    }

    @Step("Click on Save")
    public void clickOnSave() {
        adminPageObject.clickSaveJob();
    }
}
