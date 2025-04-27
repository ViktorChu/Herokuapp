package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space(text())='Click for JS Confirm']")
    WebElement confirmButton;

    public JavaScriptAlertsPage selectResult(String result) {
        click(confirmButton);

        if(result!=null && result.equals("OK")){
            driver.switchTo().alert().accept();
        }else if(result!=null && result.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }


    @FindBy(id = "result")
    WebElement result;

    public JavaScriptAlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, result));
        return this;
    }


    @FindBy(xpath = "//button[normalize-space(text())='Click for JS Prompt']")
    WebElement promptButton;

    public JavaScriptAlertsPage sendMessageToAlert(String message) {
        click(promptButton);
        if (message!=null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement promptResult;

    public JavaScriptAlertsPage verifyMessage(String text) {
        Assertions.assertTrue(isContainsText(text,promptResult));
        return this;
    }

    @FindBy(xpath = "//button[normalize-space(text())='Click for JS Alert']")
    WebElement alertButton;

    public JavaScriptAlertsPage clickOkInAlert(String text) {
        click(alertButton);
        driver.switchTo().alert().accept();

        return this;
    }
}
