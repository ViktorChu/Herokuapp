package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class RedirectLinkPage extends BasePage { //LinksPage
    public RedirectLinkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#redirect")
    WebElement clickHere;


    public RedirectLinkPage clickHereLink() {
        click(clickHere);

        return this;
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public RedirectLinkPage getAllLinks() {
        String url = "";
        System.out.println("Total amount of links: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();//распечатка каждой ссылки с помощью метода iterator, для чего создаем переменную iterator
        while (iterator.hasNext()) {// пока итератор имеет следующее значение
            url = iterator.next().getText(); // получаем в url значение текста текущей ссылки из массива iterator
            System.out.println(url); // печатаем значение текста текущей ссылки из массива iterator
            System.out.println("====================================================");
        }
        return this;
    }

    public RedirectLinkPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");//достаем ссылку из каждого элемента массива allLinks и создаем переменную url
            verifyLinks(url);//метод проверки ссылки
        }
        return this;
//        URL linkUrl = new URL(new URL())//URL - класс для установления связи с сервером, в IntelliJ есть 2 класса с этим именем, в данном случае нужно выбрать java.net
    }


}
