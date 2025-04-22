package com.herokuapp.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

//    ! раскомментировать AfterEach после написания всего кода!!
//    @AfterEach
//    public void tearDown(){
//        driver.quit(); // в конце теста закрывается тестовый браузер
//    }
}
