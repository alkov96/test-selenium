package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * @author a.kovtun
 * @since 28.03.2018.
 */
public class Countries {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testCountries () throws Exception {
       driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
       Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name=username]")).clear();
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        System.out.println("login");
        driver.findElement(By.cssSelector("input[name=password]")).clear();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        System.out.println("send password");
        driver.findElement(By.cssSelector("div.footer button")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
        List<String> newcountries = new ArrayList<>();
        countries.forEach(element -> newcountries.add(element.getText()));
        List<String> newnew = new ArrayList<>();
        countries.forEach(element -> newnew.add(element.getText()));
        Collections.sort(newcountries);
        newcountries.equals(newnew);
        System.out.println("Список отсортирован по алфавиту");
        List <WebElement> zones = driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[position()=6 and normalize-space(text())!='0']"));
        for(int thiszone =0; thiszone< zones.size(); thiszone++){
            zones.get(thiszone).findElement(By.xpath("../td[5]/a")).click();
            List<WebElement> otherCountries = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
            List<String> newotherCountries = new ArrayList<>();
            otherCountries.forEach(string -> newotherCountries.add(string.getText()));
            List<String> newnewother = new ArrayList<>();
            otherCountries.forEach(string -> newnewother.add(string.getText()));
            Collections.sort(newotherCountries);
            newotherCountries.equals(newnewother);
            //тут будет список со странами
            driver.findElement(By.xpath("//li[@class='selected']")).click();

            Thread.sleep(500);
            zones = driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[position()=6 and normalize-space(text())!='0']"));
            System.out.println("Список отсортирован по алфавиту");
        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> geozones = driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]/a"));
        for (int geozone =0; geozone<geozones.size();geozone++) {
            geozones.get(geozone).click();
            List<WebElement> zoneingeozone = driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]"));
            List<String> newzoneingeo = new ArrayList<>();
            zoneingeozone.forEach(element -> newzoneingeo.add(element.getText()));
            List<String> newnewzoneingeo = new ArrayList<>();
            zoneingeozone.forEach(element -> newnewzoneingeo.add(element.getText()));
            Collections.sort(newzoneingeo);
            newzoneingeo.equals(newnewzoneingeo);
            driver.findElement(By.xpath("//li[@class='selected']")).click();

            Thread.sleep(500);
            geozones = driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]/a"));
            System.out.println("Зоны отсортирвоаны");
        }
       }
    }
