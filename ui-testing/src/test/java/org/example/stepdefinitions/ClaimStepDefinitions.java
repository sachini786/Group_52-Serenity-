package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.example.actions.ClaimAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    ClaimAction claimAction;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String ADMIN = environmentVariables.getProperty("login.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("login.password");

    @Given("user is in dashboard")
    public void userIsInDashboard() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword(ADMIN, ADMIN_PASSWORD);
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click claim section in sidebar")
    public void userClickClaimSectionInSidebar() {
        navigateAction.toOrangeHRMClaimPage();
    }

    @Then("user expect redirection to claim section")
    public void userExpectRedirectionToClaimSection() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim");
    }

    @Given("user is in claim page and click assign claim button")
    public void userIsInClaimPageAndClickAssignClaimButton() {
        userIsInDashboard();
        userClickClaimSectionInSidebar();
        claimAction.clickAssignClaim();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/assignClaim");
    }

    @When("user create new claim request with employee name {string},event {string}, currency {string}")
    public void userCreateNewClaimRequest(String employeeName, String event, String currency) {
        claimAction.selectEmployeeName(employeeName);
        claimAction.selectEvent(event);
        claimAction.selectCurrency(currency);
        claimAction.clickSubmit();
    }

    @Given("user is in claim page wants to search for initiated claim")
    public void userIsInClaimPageWantsToSearchForInitiatedClaim() {
        userIsInDashboard();
        userClickClaimSectionInSidebar();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim");
    }

    @When("user search for claim with employee name {string},event {string} and status {string}")
    public void userSearchForClaimWithEmployeeNameEventCurrency(String employeeName, String event, String status) {
        claimAction.selectEmployeeName(employeeName);
        claimAction.selectEventToSearch(event);
        claimAction.selectStatusToSearch(status);
        claimAction.clickSearch();
    }

    @Then("user expect to see claim with name {string},event {string}, currency {string} and status {string}")
    public void userExpectToSeeClaimWithNameEvent(String name, String event, String currency, String status) {
        commonAction.pause(1000);
        claimAction.validateIfTableHasClaim(name, event, currency, status);
    }
}
