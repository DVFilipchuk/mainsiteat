package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//    Перейти на сайт https://geekbrains.ru/events
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что на странице:
//    Профессий не менее чем 2
//    Курсов более 15
//    Вебинаров больше чем 180, но меньше 300
//    В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//    Блогов более 300
//    Форумов не 350
//    Тестов не 0
//    В Проектах и компаниях отображается GeekBrains

public class SecondTest {
    ChromeDriver chromeDriver = new ChromeDriver();


    @Test
    public void Test2(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chromeDriver.get("https://geekbrains.ru/events");
        chromeDriver.findElement(By.cssSelector("[class=\"show-search-form\"] " +
                "[class=\"svg-icon icon-search \"]")).click();
        chromeDriver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"))
                .sendKeys("java");

        WebElement professionsNum = chromeDriver.findElement(By.xpath("//header//span[text()='3']"));
        WebElement coursesNum = chromeDriver.findElement(By.xpath("//header//span[text()='19']"));
        WebElement eventsNum = chromeDriver.findElement(By.xpath("//header//span[text()='223']"));
        WebElement eventsSearch = chromeDriver.findElement(By.xpath("//a[@class='event__title h3 search_text' and " +
                "@href=\"/events/6\"]"));
        WebElement blogsNum = chromeDriver.findElement(By.xpath("//header//span[text()='346']"));
        WebElement forumsNum = chromeDriver.findElement(By.xpath("//header//span[text()='454']"));
        WebElement testsNum = chromeDriver.findElement(By.xpath("//header//span[text()='1']"));
        WebElement forCompany = chromeDriver.findElement(By.xpath("//div[@class='company-items']//h3/a[contains(text(),'GeekBrains')]"));




        Assertions.assertTrue((Integer.parseInt(professionsNum.getText())) >= 2, "Профессий не менее чем 2");

        Assertions.assertTrue((Integer.parseInt(coursesNum.getText())) > 15, "Курсов более 15");
        Assertions.assertTrue((Integer.parseInt(eventsNum.getText()) > 180) & (Integer.parseInt(eventsNum.getText()) < 300),
                "Вебинаров больше чем 180, но меньше 300");
        Assertions.assertEquals("Java Junior. Что нужно знать для успешного собеседования?", eventsSearch.getText());
        Assertions.assertTrue((Integer.parseInt(blogsNum.getText())) > 300, "Блогов более 300");
        Assertions.assertTrue((Integer.parseInt(forumsNum.getText())) != 350, "Форумов не 350");
        Assertions.assertTrue((Integer.parseInt(testsNum.getText())) != 0, "Тестов не 0");

        Assertions.assertNotNull(forCompany, "В Проектах и компаниях отображается GeekBrains");

    }


}
