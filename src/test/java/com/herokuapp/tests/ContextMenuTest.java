package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.ContextMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

public class ContextMenuTest extends TestBase {//ElementsTest в классном проекте

    HomePage homePage;
    ContextMenuPage contextMenu; // ButtonsPage в классном проекте

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        contextMenu = new ContextMenuPage(driver);
    }

    @Test
    public void rightClickTest(){
        homePage.selectContextMenu();
        contextMenu.rightClick()
                .verifyRightClick(" context menu");//можно только часть текста

    }

}
