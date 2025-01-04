package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.RecruitmentPageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentAction extends UIInteractionSteps {

    RecruitmentPageObject recruitmentPageObject;

    @Step("Click Vacancies tab")
    public void clickVacanciesTab() {
        recruitmentPageObject.clickVacancies();
    }

    @Step("Click Add button")
    public void clickAddButton() {
        recruitmentPageObject.clickAddButton();
    }

    @Step("Fill Vacancy Name")
    public void fillVacancyName(String vacancyName) {
        recruitmentPageObject.fillVacancyName(vacancyName);
    }

    @Step("Select Job Title")
    public void selectJobTitle() {
        recruitmentPageObject.selectJobTitle();

    }

    @Step("Fill Hiring Manager")
    public void fillHiringManager() {
        recruitmentPageObject.fillHiringManager();

    }

    @Step("Click Save button")
    public void clickSaveButton() {
        recruitmentPageObject.clickSaveButton();
    }

}
