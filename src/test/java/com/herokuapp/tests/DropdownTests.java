package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownTests extends TestBase {
    HomePage homePage;
    DropdownPage dropdownList;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        dropdownList = new DropdownPage(driver);
    }

    @Test
    public void dropdownListTest(){
        homePage.getDropdownList();
        dropdownList.selectOption("Option 2")
                .verifyOption();
    }

}
