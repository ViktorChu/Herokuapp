package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.windows.JavaScriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space(text())='JavaScript Alerts']")// ищем раздел 'JavaScript Alerts' по локатору
    WebElement jsAlerts; //присваиваем разделу имя jsAlerts. alerts в lesson project

    public JavaScriptAlertsPage selectAlerts() { // метод для входа в раздел с алертами 'JavaScript Alerts'
        click(jsAlerts); //click 'JavaScript Alerts'
        return new JavaScriptAlertsPage(driver); // вызываем методы из класса JavaScriptAlertsPage
    }




    //1:44:00 @FindBy
}
