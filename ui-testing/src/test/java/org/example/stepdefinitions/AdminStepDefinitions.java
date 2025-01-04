package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.AdminAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    AdminAction adminAction;

    @Given("user in dashboard need to navigate to admin page")
    public void userInDashboardNeedToNavigateToAdminPage() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin", "admin123");
        assertThat(commonAction.getUrl())
                .as("User should be redirected to dashboard")
                .isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click Admin section in sidebar")
    public void userClickAdminSectionInSidebar() {
        navigateAction.toOrangeHRMAdminPage();
    }

    @Then("user expect redirection to Admin section")
    public void userExpectRedirectionToAdminSection() {
        assertThat(commonAction.getUrl())
                .as("User should be redirected to Admin section")
                .isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Given("user is in Admin page")
    public void userIsInAdminPage() {
        userInDashboardNeedToNavigateToAdminPage();
        userClickAdminSectionInSidebar();
    }

    @When("user clicking the add Button")
    public void userClickingTheAddButton() {
        adminAction.clickAddUser();
        adminAction.waitForRedirectionToAddUser();
    }

    @When("user add new user role {string}, employee name {string}, Status {string}, username {string}, password {string}, confirm password {string}")
    public void userAddNewUserRoleEmployeeNameStatusUsernamePasswordConfirmPassword(String userRole, String employeeName, String status, String username, String password, String confirmPassword) {
        adminAction.selectUserRole(userRole);
        adminAction.selectStatus(status);
        adminAction.selectEmployeeName(employeeName);
        adminAction.userName(username);
        adminAction.passwordGiven(password);
        adminAction.confirmPassword(confirmPassword);
        adminAction.clickSave();
    }

    @Then("user expect to be redirected to the Admin section")
    public void userExpectToBeRedirectedToTheAdminSection() {
        adminAction.waitForRedirection();
    }

    @Given("user is in the admin page")
    public void userIsInTheAdminPage() {
        userInDashboardNeedToNavigateToAdminPage();
        userClickAdminSectionInSidebar();
    }

    @When("user clicked the job icon")
    public void userClickedTheJobIcon() {
        adminAction.selectTheJobIcon();
    }

    @Then("redirecting to the job title page")
    public void redirectingToTheJobTitlePage() {
        adminAction.waitForJobTitlePage();
    }

    @When("clicking the add job button")
    public void clickingTheAddJobButton() {
        adminAction.clickOnAddJobInTheJobPage();
    }

    @Then("redirecting to the Add job page")
    public void redirectingToTheAddJobPage() {
        adminAction.waitForJobAddPage();
    }

    @And("fill the job title as {string}")
    public void fillTheJobTitleAs(String jobTitle) {
        adminAction.fillTheJobTitle(jobTitle);
    }

    @And("click on the save button")
    public void clickOnTheSaveButton() {
        adminAction.clickOnSave();
    }
}
