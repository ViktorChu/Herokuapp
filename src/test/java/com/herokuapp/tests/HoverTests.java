package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.HoversPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoverTests extends TestBase {
    HomePage homePage;
    HoversPage hovers;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(app.driver);
        hovers = new HoversPage(app.driver);
    }

    @Test
    public void selectImageTest(){
        homePage.selectHover();
        new HoversPage(app.driver)
                .selectAvatar("userAvatar3")
                .verifyUser();
    }
}
