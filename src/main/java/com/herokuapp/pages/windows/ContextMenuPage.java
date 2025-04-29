package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//!Тестирование клика правой кнопкой мышки
public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#hot-spot")
    WebElement hotspot;

    public ContextMenuPage rightClick() {
        //pause(100); // проверить работу без паузы

        new Actions(driver).contextClick(hotspot).perform();

        return this;
    }



    public ContextMenuPage verifyRightClick(String text) {
        Alert alertText = driver.switchTo().alert();
        Assertions.assertTrue(alertText.getText().contains(text));
        return this;
    }
}
