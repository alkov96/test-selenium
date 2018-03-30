package ru.stqa.training.selenium;

import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author a.kovtun
 * @since 22.03.2018.
 */
public class HW4 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyT3() throws Exception {
        driver.get("http://localhost/litecart/en/");
        Thread.sleep(500);
        List<WebElement> allUtkas = driver.findElements(By.className("product"));//список всех уток
        for (WebElement utka : allUtkas) {
            List<WebElement> stickers = utka.findElements(By.xpath("a/div/div"));

            Assert.assertTrue("Fail",stickers.size() == 1 );
            }
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    } }

