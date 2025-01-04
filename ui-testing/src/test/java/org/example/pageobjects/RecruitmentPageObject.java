package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPageObject extends PageObject {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    private final By clickVacanciesButton = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Vacancies']");
    private final By clickPlusAddButton = By.xpath("//button[contains(@class,'oxd-button') and contains(., 'Add')]");
    private final By fillVacName = By.xpath("//label[text()='Vacancy Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')]");
    private final By jobTitleInputField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i");
    private final By jobTitleDropDown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div[2]");
    private final By getJobTitleSpan = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div[4]");
    private final By hiringManagerInputField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[3]/div[1]/div/div[2]/div/div/input");
    private final By hiringManagerSearchField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]");
    private final By hiringManagerSpanField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/span");
    private final By buttonSave = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/button[2]");

    public void clickVacancies() {
        $(clickVacanciesButton).click();
    }
    public void clickAddButton() {
        $(clickPlusAddButton).click();
    }

    public void fillVacancyName(String VacancyName) {
        $(fillVacName).type(VacancyName);
    }

    public void selectJobTitle() {
        $(jobTitleInputField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleDropDown));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getJobTitleSpan));
        firstElement.click();
    }

    public void fillHiringManager() {
        $(hiringManagerInputField).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(hiringManagerSearchField));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(hiringManagerSpanField));
        firstElement.click();
    }

    public void clickSaveButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSave));
        button.click();
    }
}
