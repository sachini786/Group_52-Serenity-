package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageObject extends PageObject {
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    private final By successMessage =By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[1]");

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void waitUntilSuccessMessage() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertEquals("Success", header.getAttribute("innerHTML"));
    }
}
