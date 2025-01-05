package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;
import org.example.actions.PIMAction;

import static org.assertj.core.api.Assertions.assertThat;

public class PIMStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    PIMAction pimAction;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String ADMIN = environmentVariables.getProperty("login.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("login.password");


    @Then("user expect redirection to PIM section")
    public void userExpectRedirectionToPIMSection() {
        commonAction.pause(5000);
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    @When("user click in PIM in sidebar")
    public void userClickInPIMInSidebar() {
        navigateAction.toOrangeHRMPIMPage();
    }

    @Given("user is in PIM page and click the add button")
    public void userIsInPIMPageAndClickTheAddButton() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin", "admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        userClickInPIMInSidebar();
        pimAction.clickAdd();

    }

    @When("user add employee with employee firstName {string} lstName {string}")
    public void userAddEmployeeWithEmployeeFirstNameLstNameEmployeeId(String firstName, String lastName) {
        pimAction.SelectEmployeeFirstName(firstName);
        pimAction.SelectEmployeeLastName(lastName);
        pimAction.clickCreate();
    }

    @Then("user expect to show Personal Details page")
    public void userExpectToShowPersonalDetailsPage() {
        pimAction.waitPersonalDetailForm();
    }

    @Given("user is in PIM page wants to search for employee")
    public void userIsInPIMPageWantsToSearchForEmployee() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        userClickInPIMInSidebar();

    }

    @When("user search for employee with first name {string} last name {string}")
    public void userSearchForEmployeeWithEmployeeName(String firstName, String lastName) {
        pimAction.EnterEmployeeName(firstName, lastName);
        pimAction.clickSearch();
    }

    @Then("user expect to see employee with first name {string} last name {string}")
    public void userExpectToSeeEmployeeWithEmployeeName(String firstName, String lastName) {
        commonAction.pause(1000);
        pimAction.validateIfTableHasEmployee(firstName, lastName);
    }
}
