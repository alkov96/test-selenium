package ru.stqa.training.selenium;

import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author a.kovtun
 * @since 03.04.2018.
 */
public class Registration {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Reg () throws Exception {
        driver.get("http://localhost/litecart/en/");
        Thread.sleep(500);
        driver.findElement(By.xpath("//tbody/tr[5]/td/a")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Name");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("LastName");
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("Address");
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("Moscow");
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys("12345");
        driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
        driver.findElement(By.cssSelector("select[name=country_code] option[value=US]")).click();
        int a = (int)(Math.random()*8000);
        String email = "test" + a + "@mail.com";
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.xpath("//div[@class='content']/ul[@class='list-vertical']/li[4]/a")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("12345");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.xpath("//div[@class='content']/ul[@class='list-vertical']/li[4]/a")).click();

    }

    }
