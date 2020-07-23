package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.lang.Thread.sleep;

public class FirstTest {

    ChromeDriver chromeDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(chromeDriver, 30);

    @AfterEach
    public void checkheaderfooter(){
        WebElement header = chromeDriver.findElementByCssSelector("[class=*\"gb-header__content\"]");
        WebElement footer = chromeDriver.findElementByCssSelector("[class=\"site-footer__content\"]");

        wait.until(ExpectedConditions.visibilityOf(header));
        wait.until(ExpectedConditions.visibilityOf(footer));
    }



    @Test
    public void events() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/events");
        sleep(3000);
        Assertions.assertEquals("Вебинары",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());

     }
    @Test
    public void courses() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/courses");
        sleep(3000);
                Assertions.assertEquals("Курсы",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());

        chromeDriver.findElement(By.cssSelector("button [class=\"svg-icon icon-popup-close-button \"]")).click();

    }

    @Test
    public void topics() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/topics");
        sleep(3000);
        Assertions.assertEquals("Форум",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());


    }

    @Test
    public void posts() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/posts");
        sleep(3000);
        Assertions.assertEquals("Блог",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());


    }

    @Test
    public void tests() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/tests");
        sleep(3000);
        Assertions.assertEquals("Тесты",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());
    }

    @Test
    public void career() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/career");
        sleep(3000);
        Assertions.assertEquals("Карьера",
                chromeDriver.findElement(By.cssSelector("[id = \"top-menu\"] h2")).getText());
    }

    @AfterEach
    public void close(){
        chromeDriver.quit();
    }

}
