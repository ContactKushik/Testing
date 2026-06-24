package org.example.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css3_buttons_hover.asp");

        Actions a = new Actions(driver);

        List<WebElement> options = driver.findElements(By.xpath("//a[@class=\"ga-nav\"]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println(options.size());
        WebElement opt1 = options.get(2);
        System.out.println(opt1.getText());
        WebElement opt2 = options.get(5);
        System.out.println(opt2.getText());
        Thread.sleep(2000);
        a.moveToElement(opt1).moveToElement(opt2).perform();
        driver.quit();
    }
}
