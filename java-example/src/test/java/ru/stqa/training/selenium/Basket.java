package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.SunHints;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

/**
 * @author a.kovtun
 * @since 04.04.2018.
 */
public class Basket {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void BasketTest() throws Exception {
        driver.get("http://localhost/litecart/en/");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("test4184@mail.com");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("12345");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        System.out.println("Залогинились");
        int counter = 0;
        String cart;
        int a;
        while (counter<3) {
            driver.findElements(By.className("product")).get(counter).click();//нажимаем на уточку
            List<WebElement> select = driver.findElements(By.name("options[Size]"));
            if (select.size()>0){
                select.get(0).click();
                driver.findElements(By.xpath("//*[@name='options[Size]']/option")).get(1).click();
            }
            driver.findElement(By.name("add_cart_product")).click();//добавляю в корзину
            cart = driver.findElement(By.xpath("//div[@id='cart']//span[@class='quantity']")).getText();
            a = Integer.valueOf(cart);
            a++;
            wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='cart']//span[@class='quantity']"),"textContent",String.valueOf(a)));
            System.out.println("Добавился 1 товар");
            driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='general-0']/a")).click();//переходим обратно на главную
            counter++;
        }
        driver.findElement(By.xpath("//div[@id='cart']//a[3]")).click();

        int countItem;
        countItem = driver.findElements(By.xpath("//td[@class='item']")).size();
        while (countItem>0) {
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(numberOfElementsToBe(By.xpath("//td[@class='item']"), countItem - 1));
            System.out.println("Удалился 1 товар");
            countItem = driver.findElements(By.xpath("//td[@class='item']")).size();
        }
        driver.close();
    }
}

