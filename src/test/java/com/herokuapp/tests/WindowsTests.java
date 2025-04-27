package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {
    // тут должен быть @BeforeEach? По сути, у нас ведь только одно предусловие на этом сайте - зайти на сайт, и это предусловие прописано в классе TestBase (1:22:30)

    HomePage homePage;
    JavaScriptAlertsPage jsAlerts;

    @BeforeEach
    public void precondition() {
        homePage = new HomePage(driver);
        jsAlerts = new JavaScriptAlertsPage(driver);
    }

    @Test
    public void waitTest() {
        //может понадобиться, если где-то будут алерты с ожиданием.
    }

    @Test
    @DisplayName("Verify to - 'Cancel' is displayed")
    public void alertWithSelectTest() {
        homePage.selectAlerts();
        jsAlerts.selectResult("Cancel").verifyResult("Cancel");//выбираем кнопку Cancel.Ассёрт по результату Cancel
    }

    @Test
    @DisplayName("Verify to - Text you entered is displayed")
    public void sendMessageToAlertTest(){
        homePage.selectAlerts();
        jsAlerts.sendMessageToAlert("Hello!").verifyMessage("Hello!");
    }

    @Test
    @DisplayName("Verify to 'You successfully clicked an alert' is displayed")
    public void alertTest() {
        homePage.selectAlerts();
        jsAlerts.clickOkInAlert("You successfully clicked an alert").verifyResult("You successfully clicked an alert");
    }


}
