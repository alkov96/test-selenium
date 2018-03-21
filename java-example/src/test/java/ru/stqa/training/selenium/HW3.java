package ru.stqa.training.selenium;

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
 * @since 21.03.2018.
 */
public class HW3 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyT3()  throws Exception {
        driver.get("http://localhost/litecart/admin");
        Thread.sleep(500);
        // wait.until(WebDriver::getTitle).equals("My Store");
        driver.findElement(By.cssSelector("input[name=username]")).clear();
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("input[name=password]")).clear();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        System.out.println("send password");
        driver.findElement(By.cssSelector("div.footer button")).click();

        List<WebElement> menu = driver.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li"));//список значение в меню
        for (int catalog = 0; catalog < menu.size(); catalog++) {
            menu.get(catalog).click();
            Assert.assertFalse("Not found h1", driver.findElements(By.xpath("//h1")).isEmpty());//предупреждение о том, что
            menu = driver.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li"));
            if (!menu.get(catalog).findElements(By.xpath("ul/li")).isEmpty()) {
                for (int submenu = 0;  submenu < menu.get(catalog).findElements(By.xpath("ul/li")).size(); submenu++) {
                    menu.get(catalog).findElements(By.xpath("ul/li")).get(submenu).click();
                    Assert.assertFalse("Not found h1", driver.findElements(By.xpath("//h1")).isEmpty());
                    menu = driver.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li"));
                }
            }

        }
        System.out.println("Result");

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
