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
 * @since 20.03.2018.
 */
public class HW2 {
    public WebDriver driver;
    public WebDriverWait wait;
    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void MyTask() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("div.content input")).clear();
        driver.findElement(By.cssSelector("div.content input")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("span.input-wrapper input")).clear();
        driver.findElement(By.cssSelector("span.input-wrapper input")).sendKeys("admin");
        System.out.println("password");
        driver.findElement(By.cssSelector("div.footer button")).click();
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}


