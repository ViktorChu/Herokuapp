package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.RedirectLinkPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedirectLinkTest extends TestBase {

    HomePage homePage;
    RedirectLinkPage redirectLinkPage;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(app.driver);
        redirectLinkPage = new RedirectLinkPage(app.driver);
    }


    @Test
    public void getAllLinksTest(){
        homePage.selectRedirectLinkPage(); //переход на искомую страницу и получение списка всех существующих на этой странице ссылок
        redirectLinkPage
                .clickHereLink()
                .getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest (){ //! проверка битых ссылок. ВОПРОС: нужно ди делать отдельный тест, или можно было в предыдущем тесте отдельный метод написать, ведь иначе идет повтор кода?
        homePage.selectRedirectLinkPage();
        redirectLinkPage.clickHereLink()
                .checkBrokenLinks()
                ;
    }

}
