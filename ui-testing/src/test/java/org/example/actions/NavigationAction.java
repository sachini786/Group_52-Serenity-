package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.ClaimPageObject;
import org.example.pageobjects.LoginPageObject;
import org.openqa.selenium.By;

public class NavigationAction extends UIInteractionSteps {

    LoginPageObject loginPageObject;
    ClaimPageObject claimPageObject;
    @Step("Navigate to the login page")
    public void toOrangeHRMLoginPage() {
        loginPageObject.toOrangeHRMLoginPage();
    }

    @Step("Navigate to Time Page")
    public void toTimePage() {
        $(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']")).click();
    }

    @Step("Navigate to the Leave page")
    public void toOrangeHRMLeavePage() {
        $(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']")).click();
    }

    @Step("Navigate to the Claim page")
    public void toOrangeHRMClaimPage() {
        claimPageObject.toOrangeHRMClaimPage();
    }

    @Step("Navigate to the Recruitment page")
    public void toOrangeHRMRecruitmentPage() {
        $(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
    }

    @Step("Navigate to the Admin page")
    public void toOrangeHRMAdminPage() {
        $(By.xpath("//span[@data-v-7b563373 and @data-v-6475d26d and text()='Admin']")).click();
    }

    @Step("navigate to PIM page")
    public void toOrangeHRMPIMPage() {
        $(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();

    }

}
