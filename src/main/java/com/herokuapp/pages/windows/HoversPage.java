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

    @FindBy(xpath = "(//div[@class='figcaption']//a)[1]")
    WebElement nameUser1;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    WebElement userAvatar2;

    @FindBy(xpath = "//(//div[@class='figcaption']//a)[1]")
    WebElement nameUser2;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    WebElement userAvatar3;

    @FindBy(xpath = "(//div[@class='figcaption']//a)[1]")
    WebElement nameUser3;


    public HoversPage selectAvatar(String avatar) {
        pause(100);
        Actions actions = new Actions(driver);
        if (avatar.equals("userAvatar1")) {
            actions.moveToElement(userAvatar1).perform();
        } else if (avatar.equals("userAvatar2")) {
            actions.moveToElement(userAvatar2).perform();
        } else {
            actions.moveToElement(userAvatar3).perform();
        }
        //Actions actions = new Actions(driver);
        //actions.moveToElement(userAvatar1).perform();
        return this;
    }

    public HoversPage verifyUser() {
        Assertions.assertTrue(isElementVisible(nameUser1));

        return this;
    }


}
