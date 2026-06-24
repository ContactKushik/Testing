package org.example.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // FIX: Always maximize for DemoQA to prevent ads from blocking your clicks
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alertsWindows");

        // Selecting the menu item header itself to expand the menu safely
        WebElement parentdiv = driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']"));
        Thread.sleep(2000);
        parentdiv.click();

        driver.findElement(By.xpath("//span[text()=\"Alerts\"]")).click();

        // ---- FIRST ALERT (Simple Alert) ----
        WebElement alertbtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertbtn.click();

        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // ---- SECOND ALERT (Timer Alert) ----
        WebElement timerAlert = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        timerAlert.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert talert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Alert text: " + talert.getText());
        talert.accept();

        // ---- THIRD ALERT (Confirm Alert) ----
        Thread.sleep(1000);
        // FIX: Added '//' to the beginning of the XPath
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();

        Thread.sleep(1000); // Added a small sleep so you can see it before dismissing
        driver.switchTo().alert().dismiss();

        // ---- FOURTH ALERT (Prompt Alert) ----
        // FIX: Added '//' and corrected the closing bracket ']' at the end
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();

        Thread.sleep(1000);
        Alert a1 = driver.switchTo().alert();
        System.out.println(a1.getText());
        Thread.sleep(2000);
        a1.sendKeys("Kushik");
//        a1.ge
        Thread.sleep(3000);
        a1.accept();

        System.out.println("Alert accepted successfully");

        // Good practice to close the browser at the end
        driver.quit();
    }
}