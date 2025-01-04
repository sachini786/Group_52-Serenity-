package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ClaimPageObject extends PageObject {

    private final By assignClaimButton = By.xpath("//button[contains(., 'Assign Claim')]");

    public void clickAssignClaim() {
        $(assignClaimButton).click();
    }
}
