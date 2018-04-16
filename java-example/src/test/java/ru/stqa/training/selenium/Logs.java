package ru.stqa.training.selenium;

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
 * @since 16.04.2018.
 */
public class Logs {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLogs() throws Exception {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name=username]")).clear();
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("input[name=password]")).clear();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        System.out.println("send password");
        driver.findElement(By.cssSelector("div.footer button")).click();
        //String aa = driver.manage().logs().get("browser").getAll().toString();
        List<WebElement> ducks = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']/td[3]/a"));
        ducks.remove(0);
        Assert.assertTrue("Сообщение в логах:"+driver.manage().logs().get("browser").getAll(),driver.manage().logs().get("browser").getAll().isEmpty());
        for (int i =0; i< ducks.size(); i++) {
            ducks = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']/td[3]/a"));
            ducks.get(i).click();
            wait.until(WebDriver::getTitle).contains("Edit Product");
            Assert.assertTrue("Сообщение в логах:" + driver.manage().logs().get("browser").getAll(),driver.manage().logs().get("browser").getAll().isEmpty());
            driver.navigate().back();
            wait.until(WebDriver::getTitle).contains("Catalog");
        }
        driver.close();
    }
}
