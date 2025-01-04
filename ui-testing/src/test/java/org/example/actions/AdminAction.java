//package org.example.actions;
//
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
//import org.example.pageobjects.AdminPageObject;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class AdminAction extends UIInteractionSteps {
//    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//    AdminPageObject adminPageObject;
//
//    @Step("click add user")
//    public void clickAddUser() {
////        $(By.xpath("//button[contains(., 'Add')]")).click();
//        adminPageObject.clickAddUser();
//    }
//
//    @Step("wait for redirection to adduser")
//    public void waitForRedirectionToAddUser() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));
//    }
//
//    @Step("select User Role")
//    public void selectUserRole(String userrole) {
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
//       adminPageObject.selectUserRole();
//        By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
//        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
//        By adminOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");
//    }
//
//    @Step("select Status")
//    public void selectStatus(String status) {
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
//
//        adminPageObject.selectStatus();
////        adminPageObject.statusDropdown();
////        adminPageObject.statusOptions();
//        By statusDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
//        By statusOptions = By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']");
//        wait.until(ExpectedConditions.elementToBeClickable(statusOptions)).click();
//    }
//
//    @Step("select employeename")
//    public void selectEmployeeName(String employeename) {
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("J");
//
//        adminPageObject.enterEmployeeName();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]")));
//        WebElement firstELement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]")));
//        firstELement.click();
//    }
//
//    @Step("giving the username")
//    public void userName(String username) {
//
//        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")));
//        titleElement.sendKeys(username);
//    }
//
//    @Step("giving the password")
//    public void passwordGiven(String passwordgiven1) {
//        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
//        titleElement.sendKeys(passwordgiven1);
//    }
//
//    @Step("giving the confirmpassword")
//    public void confirmPassword(String confirmpassword) {
//        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
//        titleElement.sendKeys(confirmpassword);
//    }
//
//    @Step("click save")
//    public void clickSave() {
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
//        adminPageObject.clickSave();
//    }
//
//    @Step("wait for redirection")
//    public void waitForRedirection() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
//    }
//
//    @Step("select the Job icon")
//    public void selectTheJobIcon() {
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")).click();
//
//        adminPageObject.selectTheJobIconOne();
//        adminPageObject.selectTheJobIconSecond();
//
//    }
//
//    @Step("wait for jobtitlepage")
//    public void waitForJobTitlePage() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"));
//    }
//
//    @Step("wait for jobaddpage")
//    public void waitForJobAddPage() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle"));
//    }
//
//    @Step("click on add job in the job page")
//    public void clickOnAddJobInTheJobPage() {
//        adminPageObject.clickOnAddJobInTheJobPage();
////        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
//    }
//
//    @Step("fill the job title")
//    public void fillTheJobTitle(String jobtitle) {
//        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
//        titleElement.sendKeys(jobtitle);
//    }
//
//    @Step("click on save")
//    public void clickOnSave() {
////        $(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and contains(., 'Save')]")).click();
//   adminPageObject.clickOnSave();
//    }
//
//}

//
//package org.example.actions;
//
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
//import org.example.pageobjects.AdminPageObject;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class AdminAction extends UIInteractionSteps {
//
//    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//    AdminPageObject adminPageObject;
//
//    @Step("Click Add User")
//    public void clickAddUser() {
//        adminPageObject.clickAddUser();
//    }
//
//    @Step("Wait for redirection to Add User page")
//    public void waitForRedirectionToAddUser() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));
//    }
//
//    @Step("Select User Role")
//    public void selectUserRole(String userRole) {
//        adminPageObject.openUserRoleDropdown();
//        adminPageObject.selectUserRoleOption(userRole);
//    }
//
//    @Step("Select Status")
//    public void selectStatus(String status) {
//        adminPageObject.openStatusDropdown();
//        adminPageObject.selectStatusOption(status);
//    }
//
//    @Step("Select Employee Name")
//    public void selectEmployeeName(String employeeName) {
//        adminPageObject.enterEmployeeName(employeeName);
//        adminPageObject.selectFirstEmployeeNameOption();
//    }
//
//    @Step("Enter Username")
//    public void userName(String username) {
//        adminPageObject.enterUsername(username);
//    }
//
//    @Step("Enter Password")
//    public void passwordGiven(String password) {
//        adminPageObject.enterPassword(password);
//    }
//
//    @Step("Enter Confirm Password")
//    public void confirmPassword(String confirmPassword) {
//        adminPageObject.enterConfirmPassword(confirmPassword);
//    }
//
//    @Step("Click Save")
//    public void clickSave() {
//        adminPageObject.clickSave();
//    }
//
//    @Step("Wait for redirection to System Users page")
//    public void waitForRedirection() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
//    }
//
//    @Step("Select the Job Icon")
//    public void selectTheJobIcon() {
//        adminPageObject.selectJobIcon();
//    }
//
//    @Step("Wait for Job Title Page")
//    public void waitForJobTitlePage() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"));
//    }
//
//    @Step("Wait for Job Add Page")
//    public void waitForJobAddPage() {
//        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle"));
//    }
//
//    @Step("Click on Add Job in the Job Page")
//    public void clickOnAddJobInTheJobPage() {
//        adminPageObject.clickAddJob();
//    }
//
//    @Step("Fill the Job Title")
//    public void fillTheJobTitle(String jobTitle) {
//        adminPageObject.enterJobTitle(jobTitle);
//    }
//
//    @Step("Click on Save")
//    public void clickOnSave() {
//        adminPageObject.clickSaveJob();
//    }
//}
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
