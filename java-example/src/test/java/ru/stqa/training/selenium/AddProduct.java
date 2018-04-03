package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author a.kovtun
 * @since 03.04.2018.
 */
public class AddProduct {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void AddProduct() throws Exception {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.cssSelector("input[name=username]")).clear();
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("input[name=password]")).clear();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        System.out.println("password");
        driver.findElement(By.cssSelector("div.footer button")).click();
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Duck");
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='1-3']")).click();
        driver.findElement(By.cssSelector("input[name=quantity]")).sendKeys("123");
        //driver.findElement(By.cssSelector("input[name=name[en]]")).sendKeys("Duck");
        String workDir = System.getProperty("user.dir");
        driver.findElement(By.name("new_images[]")).sendKeys(workDir+"\\duck.jpg");
        System.out.println("hbfth");
       // wait.until((WebDriver d)-> d.findElement(By.name("date_valid_from")).isDisplayed());
       // JavascriptExecutor js = (JavascriptExecutor)driver;
       // js.executeAsyncScript( "('{0}').datepicker('setDate', '{1}')", By.cssSelector("input[name=date_valid_from]"),"02/12/2012" );
      //  System.out.println("bgfdb");
        driver.findElement(By.cssSelector("input[name=date_valid_from]")).sendKeys("111122200");
        driver.findElement(By.cssSelector("input[name=date_valid_to]")).sendKeys("11112121211");
        driver.findElement(By.xpath("//ul[@class='index']/li[2]/a")).click();
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']/option[2]")).click();
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.cssSelector("input[name=keywords]")).sendKeys("duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("duck");
        driver.findElement(By.xpath("//ul[@class='index']/li[4]/a")).click();
        driver.findElement(By.cssSelector("input[name=purchase_price]")).sendKeys("1234");
        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']/option[2]")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        
    }
}

