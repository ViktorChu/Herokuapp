package com.herokuapp.core;

import com.herokuapp.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;

    //public static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
        
    }

    public WebDriver startTest() {

        switch (browser){
            case "chrome"->driver = new ChromeDriver();
            case "firefox"->driver = new FirefoxDriver();
            case "edge"->driver = new EdgeDriver();
        }

        WebDriverListener listener = new MyListener();
        driver=new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    public void stopTest() {
        driver.quit(); // в конце теста закрывается тестовый браузер
    }
}
