package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author a.kovtun
 * @since 29.03.2018.
 */
public class HomeWork10 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        //driver = new FirefoxDriver();
        //DesiredCapabilities ad = new DesiredCapabilities();
        //ad.setCapability(FirefoxDriver.MARIONETTE, false);
       // driver = new FirefoxDriver(ad);
        //FirefoxOptions options = new FirefoxOptions().setLegacy(true);
       // options.setBinary(new FirefoxBinary(new File("C:\\Users\\a.kovtun\\AppData\\Local\\Mozilla Firefox\\firefox.exe")));
       // WebDriver driver = new FirefoxDriver(options);
       //driver=new FirefoxDriver(options);
       //System.out.println(((HasCapabilities)driver).getCapabilities());
       //wait = new WebDriverWait(driver, 11);
        //driver=new FirefoxDriver();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE,false);
        // driver=new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")),new FirefoxProfile(),caps);
        driver=new FirefoxDriver(caps);

    }

    @Test
    public void Duck() throws Exception {
        driver.get("http://localhost/litecart/en/");
        Thread.sleep(500);
        String NameOnMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='name']")).getText();
        driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String NameOnCategory = driver.findElement(By.xpath("//div[@id='box-product']//h1[@class='title']")).getText();
        if (NameOnMain.equals(NameOnCategory)) {
            System.out.println("Имя утки совпадает");
        }
        driver.findElement(By.linkText("Home")).click();
        String StrongPriceOnMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getText();
        String RegularPriceOnMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getText();
        driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String StrongPriceOnCategory = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/strong")).getText();
        String RegularPriceOnCategory = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/s")).getText();
        if (StrongPriceOnMain.equals(StrongPriceOnCategory) && RegularPriceOnMain.equals(RegularPriceOnCategory)) {
            System.out.println("Цены совпадают");
        }
        driver.findElement(By.linkText("Home")).click();

        String StrongColorPriceOnMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getCssValue("color");
        int a1 = StrongColorPriceOnMain.indexOf("(");
        int a2 = StrongColorPriceOnMain.indexOf(")");
        StrongColorPriceOnMain = StrongColorPriceOnMain.substring(a1+1,a2);
        int S1 = Integer.valueOf(StrongColorPriceOnMain.split(",")[1].trim());
        int S2 = Integer.valueOf(StrongColorPriceOnMain.split(",")[2].trim());
        if (!(S1==0 && S2==0)) {
            System.out.println("Цвет не красный");
        }

        // if (!(StrongColorPriceOnMain.split(",")[1].equals('0') && StrongColorPriceOnMain.split(",")[2].equals('0'))) {
        //    System.out.println("Цвет не красный");
      //  }
        String RegularColorPriceOnMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getCssValue("color");

            int b1 = RegularColorPriceOnMain.indexOf("(");
            int b2 = RegularColorPriceOnMain.indexOf(")");
            RegularColorPriceOnMain = RegularColorPriceOnMain.substring(b1+1,b2);
            int R1 = Integer.valueOf(RegularColorPriceOnMain.split(",")[0].trim());
            int G1 = Integer.valueOf(RegularColorPriceOnMain.split(",")[1].trim());
            int B1 = Integer.valueOf(RegularColorPriceOnMain.split(",")[2].trim());
            if (!(R1==G1 && G1==B1)) {
                System.out.println("Цвет не серый");
            }
        String RegularPriceOnMainType = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getTagName();
        String StrongPriceOnMainType = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getTagName();
        if (!(RegularPriceOnMainType.equals("s") && StrongPriceOnMainType.equals("strong"))) {
            System.out.println("не зачёркнутый и не жирный");
        }
        if(RegularPriceOnMainType.equals(StrongPriceOnMainType)) {
            System.out.println("Акционная цена не больше, чем обычная. Ошибка.");
        }
        driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();

        String StrongColorPriceOnCategory = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/strong")).getCssValue("color");
        String RegularColorPriceOnCategory = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/s")).getCssValue("color");
        int c1 = StrongColorPriceOnCategory.indexOf("(");
        int c2 = StrongColorPriceOnCategory.indexOf(")");
        StrongColorPriceOnCategory = StrongColorPriceOnCategory.substring(c1+1,c2);
        int C1 = Integer.valueOf(StrongColorPriceOnCategory.split(",")[1].trim());
        int C2 = Integer.valueOf(StrongColorPriceOnCategory.split(",")[2].trim());
        if (!(C1==0 && C2==0)) {
            System.out.println("Цвет не красный в категоии");
        }
        int y1 = RegularColorPriceOnCategory.indexOf("(");
        int y2 = RegularColorPriceOnCategory.indexOf(")");
        RegularColorPriceOnCategory = RegularColorPriceOnCategory.substring(y1+1,y2);
        int Y1 = Integer.valueOf(RegularColorPriceOnCategory.split(",")[0].trim());
        int X1 = Integer.valueOf(RegularColorPriceOnCategory.split(",")[1].trim());
        int W1 = Integer.valueOf(RegularColorPriceOnCategory.split(",")[2].trim());
        if (!(Y1==X1 && X1==W1)) {
            System.out.println("Цвет не серый в категории");
        }
        String RegularPriceOnCategoryType = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/s")).getTagName();
        String StrongPriceOnCategoryType = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']/strong")).getTagName();
        if (!(RegularPriceOnCategoryType.equals("s") && StrongPriceOnCategoryType.equals("strong"))) {
            System.out.println("не зачёркнутый и не жирный");
        }
        if(RegularPriceOnCategoryType.equals(StrongPriceOnCategoryType)) {
            System.out.println("Акционная цена не больше, чем обычная. Ошибка.");
        }

    } }





