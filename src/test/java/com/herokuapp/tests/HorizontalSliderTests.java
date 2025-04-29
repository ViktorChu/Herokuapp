package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.HorizontalSliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorizontalSliderTests extends TestBase {

    HomePage homePage;
    HorizontalSliderPage horizontalSlider;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        horizontalSlider = new HorizontalSliderPage(driver);
    }

    @Test
    public void horizontalSliderTest(){
        homePage.selectHorisontalSlider();
        new HorizontalSliderPage(driver).moveSliderToHorizontalDirection(60,0)
                .verifySliderValue("5");
    }
}
