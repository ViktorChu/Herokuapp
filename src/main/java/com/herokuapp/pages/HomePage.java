package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.windows.*;
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
        return new JavaScriptAlertsPage(driver); // вызываем методы из класса JavaScriptAlertsPage, то есть click
    }

    @FindBy(xpath = "//a[normalize-space(text())='Dropdown']")
    WebElement dropdown;

    public DropdownPage getDropdownList() {
        click(dropdown);
        return new DropdownPage(driver);
    }

    @FindBy(xpath = "//a[normalize-space(text())='Hovers']")
    WebElement hover;

    public HoversPage selectHover() {
        clickWithJS(hover, 0, 100);
        return new HoversPage(driver);
    }

    @FindBy(xpath = "//a[normalize-space(text())='Horizontal Slider']")
    WebElement horizontalSlider;

    public HorizontalSliderPage selectHorisontalSlider() {
        clickWithJS(horizontalSlider, 0, 100);
        return new HorizontalSliderPage(driver);
    }


    @FindBy(xpath = "//a[normalize-space(text())='Context Menu']")
    WebElement contextMenu;

    public ContextMenuPage selectContextMenu() {
        click(contextMenu);
        return new ContextMenuPage(driver);
    }

    @FindBy(css = "div#content>ul>li:nth-of-type(18)>a")
    WebElement fileUpload;

    public FileUploadPage selectFileUpload() {
        click(fileUpload);
        return new FileUploadPage(driver);
    }

    @FindBy(css = "div#content>ul>li:nth-of-type(6)>a")
    WebElement checkBox;

    public CheckboxesPage selectCheckboxesPage() {
        click(checkBox);
        return new CheckboxesPage(driver);
    }


    //1:44:00 @FindBy
}
