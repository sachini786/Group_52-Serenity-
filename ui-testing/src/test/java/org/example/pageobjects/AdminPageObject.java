package org.example.pageobjects;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AdminPageObject extends PageObject {

    // Locators
    private final By addUserButton = By.xpath("//button[contains(., 'Add')]");
    private final By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    private final By userRoleOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");
    private final By statusDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
    private final By statusOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']");
    private final By employeeNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private final By firstEmployeeNameOption = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]");
    private final By usernameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private final By passwordInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private final By confirmPasswordInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    private final By jobIcon = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span");
    private final By jobIconSubMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a");
    private final By addJobButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button");
    private final By jobTitleInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    private final By saveJobButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and contains(., 'Save')]");

    // Methods
    public void clickAddUser() {
        $(addUserButton).click();
    }

    public void openUserRoleDropdown() {
        $(userRoleDropdown).click();
    }

    public void selectUserRoleOption(String userRole) {
        $(By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']")).click();
    }

    public void openStatusDropdown() {
        $(statusDropdown).click();
    }

    public void selectStatusOption(String status) {
        $(By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']")).click();
    }

    public void enterEmployeeName(String employeeName) {
        $(employeeNameInput).sendKeys("J");
    }

    public void selectFirstEmployeeNameOption() {
        $(firstEmployeeNameOption).click();
    }

    public void enterUsername(String username) {
        $(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        $(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void clickSave() {
        $(saveButton).click();
    }

    public void selectJobIcon() {
        $(jobIcon).click();
        $(jobIconSubMenu).click();
    }

    public void clickAddJob() {
        $(addJobButton).click();
    }

    public void enterJobTitle(String jobTitle) {
        $(jobTitleInput).sendKeys(jobTitle);
    }

    public void clickSaveJob() {
        $(saveJobButton).click();
    }
}
