package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

/**
 * @author a.kovtun
 * @since 10.04.2018.
 */
public class LinksInWindow {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void LinksInWindowTest() throws Exception {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("input[name=username]")).clear();
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("input[name=password]")).clear();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        System.out.println("send password");
        driver.findElement(By.cssSelector("div.footer button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("i.fa-external-link"));
        Set handles;
        String title;
        String currentHandle = driver.getWindowHandle();
        for (WebElement link : links) {
            link.click();
            wait.until(numberOfWindowsToBe(2));
            handles = driver.getWindowHandles();
            handles.remove(currentHandle);
            title = driver.switchTo().window(handles.iterator().next().toString()).getTitle();
            System.out.println("Открылась страница " + title);
            driver.close();
            driver.switchTo().window(currentHandle);
        }
        driver.close();
    }


}

