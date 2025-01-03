package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;
import org.example.actions.TimeAction;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeStepDefinitions {
    NavigationAction navigationAction;
    LoginAction loginAction;
    CommonAction commonAction;
    TimeAction timeAction;


    @Given("user is in dashboard page")
    public void userIsInDashboardPage() {
        navigationAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin","admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click time section in sidebar")
    public void userClickTimeSectionInSidebar() {
        navigationAction.toTimePage();
    }

    @Then("user expect redirection to time page")
    public void userExpectRedirectionToTimePage() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
    }

    @Given("user is in project info in time page and click add button")
    public void userIsInTimePageProjectInfoAndClickAddButton() {
        userIsInDashboardPage();
        userClickTimeSectionInSidebar();
        userExpectRedirectionToTimePage();
        timeAction.clickProjectsUnderProjectInfo();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewProjects");
        timeAction.clickAdd();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/time/saveProject");
    }

    @When("user add a project with name {string},customer name {string}")
    public void addProjectWithNameCustomerName(String name, String customerName) {
        timeAction.selectProjectName(name);
        timeAction.selectCustomerName(customerName);
        timeAction.clickSave();
    }

    @Then("user expect to show project")
    public void userExpectToShowProject() {
        timeAction.waitUntilEditForm();
    }

//    @Given("user is in time page wants to search for project")
//    public void userIsInTimePageWantsToSearchForProject() {
//        userIsInDashboardPage();
//        userClickTimeSectionInSidebar();
//        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewProjects");
//    }
//
//    @When("user search for project with project name {string},customer name {string}")
//    public void userSearchForProjectWithProjectNameCustomerName(String projectName, String customerName) {
//        timeAction.enterProjectNameToSearch(projectName);
//        timeAction.selectCustomerNameToSearch(customerName);
//        timeAction.clickSearch();
//    }
//
//    @Then("user expect to see project with name {string},event {string}")
//    public void userExpectToSeeProjectWithNameEvent(String projectName, String customerName) {
//    }
}
