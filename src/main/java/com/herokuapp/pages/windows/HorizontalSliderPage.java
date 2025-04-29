package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='range']")
    WebElement sliderContainer;

    public HorizontalSliderPage moveSliderToHorizontalDirection(int x,int y) {
        pause(500);

        new Actions(driver).dragAndDropBy(sliderContainer,x,y).perform();
        return this;
    }

@FindBy(id = "range")
WebElement range;

    public HorizontalSliderPage verifySliderValue(String number) {
        Assertions.assertEquals(number,range.getText());
        return this;
    }
}
