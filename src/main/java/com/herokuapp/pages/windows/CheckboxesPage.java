package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage {
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement checkbox2;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkbox1;


    public CheckboxesPage unmarkMarkCheckbox() {
        click(checkbox2);
        click(checkbox1);

        return this;
    }

    public CheckboxesPage verifyMark(String checkbox,String color) {
        WebElement selectedCheckbox = driver.findElement(By.xpath("//input"));
        //click(selectedCheckbox);
        //System.out.println(selectedCheckbox.getCssValue("background-color"));
        Assertions.assertTrue(selectedCheckbox.getCssValue("background-color").contains(color));
        return this;
    }
}
