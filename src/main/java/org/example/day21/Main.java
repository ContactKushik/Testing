package org.example.day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        if(title.equals("Google")){
            System.out.println("Correct Website:Google has been opened");
        }
//        this is used for closing the current tabs
        driver.close();
        //this is used for closing all the tabs of browser
//        driver.quit();
    }
}
