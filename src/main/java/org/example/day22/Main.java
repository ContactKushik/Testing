package org.example.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
//        all the locators
        WebElement e1 = driver.findElement(By.id("nava"));
        System.out.println("NavBar Heading"+e1.getText());




    }
}
