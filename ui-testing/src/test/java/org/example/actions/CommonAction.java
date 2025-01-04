package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public String getUrl(){
        return getDriver().getCurrentUrl();
    }
    @Step("wait for milliseconds")
    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("wait success message")
    public void waitUntilSuccessMessage(){
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[1]")));
        Assert.assertEquals("Success",header.getAttribute("innerHTML"));
    }
}

