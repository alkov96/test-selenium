package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author a.kovtun
 * @since 15.03.2018.
 */
public class HomeTask1 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }
    @Test
    public void myFirstTest() {
        driver.get("https://yandex.ru/");
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys("game");
        driver.findElement(By.xpath("//div[@class='search2__button']//button[@class='button suggest2-form__button button_theme_websearch button_size_ws-head i-bem button_js_inited']")).click();
        wait.until(WebDriver::getTitle).contains("game — Яндекс: нашлось результатов");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
