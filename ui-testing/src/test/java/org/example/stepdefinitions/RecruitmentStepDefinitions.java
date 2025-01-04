package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;
import org.example.actions.RecruitmentAction;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    RecruitmentAction recruitmentAction;

    private final static String USERNAME = "Admin";
    private final static String PASSWORD = "admin123";
    private final static String DASHBOARD = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private final static String VIEWCANDIDATES = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
    private final static String ADDJOBVACANCY = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addJobVacancy";


    @Given("user is on the dashboard")
    public void userIsOnTheDashboard() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword(USERNAME, PASSWORD);
        assertThat(commonAction.getUrl()).isEqualTo(DASHBOARD);
    }

    @When("user clicks Recruitment section in the sidebar")
    public void userClicksRecruitmentSectionInTheSidebar() {
        navigateAction.toOrangeHRMRecruitmentPage();
    }

    @Then("user expects redirection to the Recruitment page")
    public void userExpectsRedirectionToTheRecruitmentPage() {
        assertThat(commonAction.getUrl()).isEqualTo(VIEWCANDIDATES);
    }

    @Given("user is on the Recruitment page and clicks the Vacancies section and the Add button")
    public void userIsOnTheRecruitmentPageAndClicksTheVacanciesSectionAndAddButton() {
        userIsOnTheDashboard();
        userClicksRecruitmentSectionInTheSidebar();
        recruitmentAction.clickVacanciesTab();
        recruitmentAction.clickAddButton();
        assertThat(commonAction.getUrl()).isEqualTo(ADDJOBVACANCY);

    }

    @When("user adds a new vacancy with Vacancy Name {string}")
    public void userAddsANewVacancy(String vacancyName) {
        recruitmentAction.fillVacancyName(vacancyName);
        recruitmentAction.selectJobTitle();
        recruitmentAction.fillHiringManager();
        recruitmentAction.clickSaveButton();
        commonAction.pause(2000);
    }

    @Then("user expects to see the Edit Vacancy page")
    public void userExpectsToSeeTheEditVacancyPage() {
        String regex = ".*/(\\d+)$";
        assertThat(commonAction.getUrl()).matches(regex);
    }
}
