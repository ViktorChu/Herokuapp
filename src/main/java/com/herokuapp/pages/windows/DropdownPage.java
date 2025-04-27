package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage selectOption(String option) {

        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
        return this;
    }

    public DropdownPage verifyOption() {
        String firstSelectedOption = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertTrue(isContainsText(firstSelectedOption,dropdown));
        return this;
    }
}
