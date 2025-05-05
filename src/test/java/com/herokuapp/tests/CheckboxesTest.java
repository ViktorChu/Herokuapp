package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.CheckboxesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckboxesTest extends TestBase {
    HomePage homePage;
    CheckboxesPage checkboxesPage;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(app.driver);
        checkboxesPage = new CheckboxesPage(app.driver);
    }

    @Test
    public void checkboxesTest(){ // не законченый тест, задать вопрос Ирине
        homePage.selectCheckboxesPage();
        checkboxesPage.unmarkMarkCheckbox()
                .verifyMark("Checkbox 1","rgb(0, 191, 255)")
        ;
    }

}
