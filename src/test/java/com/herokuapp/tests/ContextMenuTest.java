package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.ContextMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends TestBase {//ElementsTest в классном проекте

    HomePage homePage;
    ContextMenuPage contextMenu; // ButtonsPage в классном проекте

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(app.driver);
        contextMenu = new ContextMenuPage(app.driver);
    }

    @Test
    @Tag("tag_test")
    public void rightClickTest(){
        homePage.selectContextMenu();
        contextMenu.rightClick()
                .verifyRightClick(" context menu");//можно только часть текста

    }

}
