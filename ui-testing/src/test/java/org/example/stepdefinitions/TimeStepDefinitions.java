package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
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

    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String ADMIN = environmentVariables.getProperty("login.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("login.password");
    private final static String DASHBOARD = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private final static String TIME_PAGE = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
    private final static String PROJECTS_PAGE = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewProjects";
    private final static String ADD_PROJECT_PAGE = "https://opensource-demo.orangehrmlive.com/web/index.php/time/saveProject";

    @Given("user is in dashboard page")
    public void userIsInDashboardPage() {
        navigationAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword(ADMIN,ADMIN_PASSWORD);
        assertThat(commonAction.getUrl()).isEqualTo(DASHBOARD);
    }

    @When("user click time section in sidebar")
    public void userClickTimeSectionInSidebar() {
        navigationAction.toTimePage();
    }

    @Then("user expect redirection to time page")
    public void userExpectRedirectionToTimePage() {
        assertThat(commonAction.getUrl()).isEqualTo(TIME_PAGE);
    }

    @Given("user is in project info in time page and click add button")
    public void userIsInTimePageProjectInfoAndClickAddButton() {
        userIsInDashboardPage();
        userClickTimeSectionInSidebar();
        userExpectRedirectionToTimePage();
        timeAction.clickProjectsUnderProjectInfo();
        assertThat(commonAction.getUrl()).isEqualTo(PROJECTS_PAGE);
        timeAction.clickAdd();
        assertThat(commonAction.getUrl()).isEqualTo(ADD_PROJECT_PAGE);
    }

    @When("user add a project with name {string},customer name {string}")
    public void addProjectWithNameCustomerName(String name, String customerName) {
        timeAction.selectProjectName(name);
        timeAction.selectCustomerName(customerName);
        timeAction.clickSubmit();
    }

    @Given("user is in time page wants to search for project")
    public void userIsInTimePageWantsToSearchForProject() {
        userIsInDashboardPage();
        userClickTimeSectionInSidebar();
        timeAction.clickProjectsUnderProjectInfo();
        assertThat(commonAction.getUrl()).isEqualTo(PROJECTS_PAGE);
    }

    @When("user search for project with project name {string},customer name {string}")
    public void userSearchForProjectWithProjectNameCustomerName(String projectName, String customerName) {
        timeAction.selectCustomerNameForSearch(customerName);
        timeAction.selectProjectNameForSearch(projectName);
        timeAction.clickSubmit();
    }

    @Then("user expect to see project with name {string},event {string}")
    public void userExpectToSeeProjectWithNameEvent(String projectName, String customerName) {
        commonAction.pause(1000);
        timeAction.validateIfTableHasProject(projectName,customerName);

    }
}
