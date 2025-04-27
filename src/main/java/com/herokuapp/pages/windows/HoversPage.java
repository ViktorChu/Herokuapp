package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    WebElement userAvatar1;

    @FindBy(xpath = "//h5[normalize-space(text())='name: user1']")
    WebElement nameUser1;

    public HoversPage selectAvatar() {
        pause(100);

        Actions actions = new Actions(driver);
        actions.moveToElement(userAvatar1).perform();
        return this;
    }

    public HoversPage verifyUser() {
        Assertions.assertTrue(isElementVisible(nameUser1));
        return this;
    }


}
