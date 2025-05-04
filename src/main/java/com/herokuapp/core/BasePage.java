package com.herokuapp.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BasePage {

    public WebDriver driver; // объявляем класс
    public static JavascriptExecutor js;
    public static SoftAssertions softly;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions(); // иннициализируем класс
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x, y);
        click(element);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        return true;
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try{
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException exception){
            exception.getMessage();
            return false;
        }
    }

    public void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);

            //создаем URL соединение и получаем код ответа
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000); // перед установкой соединения ставим ожидание
            connection.connect(); // установление соединения с сервером

            if(connection.getResponseCode()>=400){
                //System.out.println(url + " - " + connection.getResponseMessage() + " is a broken link"); - вместо этой строки используем на следующей строке assertion из библиотеки SoftAssertion
                softly.fail(url + " - " + connection.getResponseMessage() + " is a broken link");
            }else {
                //System.out.println(url + " - " + connection.getResponseMessage()); - тоже самое (см предыдущий коммент)
                softly.assertThat(connection.getResponseCode()).isLessThan(400);
            }
        } catch (IOException e) {
            System.out.println(url + " - " + e.getMessage() + " ERROR occurred");
        }
        softly.assertAll(); // обязательно вызывать этот метод в конце при использовании нескольких ассертов (91 и 94 строки), иначе работать не будет
    }
}
