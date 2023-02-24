package com.juaracoding.ujianminggu3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ShopDemoQA {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://shop.demoqa.com";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        driver.findElement(By.xpath("/html/body/p/a")).click();
        System.out.println("Click - Dismiss");

        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
        System.out.println("Click - My Account");

        js.executeScript("window.scrollBy(0, 700)");
        System.out.println("=== Scroll ===");

        //login
        driver.findElement(By.id("username")).sendKeys("renpu-27");
        System.out.println("Fill - Username");
        driver.findElement(By.id("password")).sendKeys("@Renaldo27");
        System.out.println("Fill - Password");
        driver.findElement(By.xpath("//*[@id=\"rememberme\"]")).click();
        System.out.println("Click - Remember Me");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
        System.out.println("Click - Log in");

        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/section/div/div/div/span[1]/a/span")).click();
        System.out.println("Click - Home");

        js.executeScript("window.scrollBy(0, 800)");
        System.out.println("=== Scroll ===");

        //Shopping
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/h3/a")).click();
        System.out.println("Click - Item");

        js.executeScript("window.scrollBy(0, 700)");
        System.out.println("=== Scroll ===");

        WebElement selectColor = driver.findElement(By.id("pa_color"));
        Select color = new Select(selectColor);
        color.selectByIndex(1);
        System.out.println("Color - Black");

        WebElement selectSize = driver.findElement(By.id("pa_size"));
        Select size = new Select(selectSize);
        size.selectByIndex(2);
        System.out.println("Size - 34");

        driver.findElement(By.xpath("//*[@id=\"product-1485\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        System.out.println("Click - Add To Cart");

        System.out.println("=== Delay 3 seconds ===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}
