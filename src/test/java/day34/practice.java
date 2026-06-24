package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class practice {
    static HashMap<String,Integer> m=new HashMap<>();
    static {

        m.put("January", 1);
        m.put("February", 2);
        m.put("March", 3);
        m.put("April", 4);
        m.put("May", 5);
        m.put("June", 6);
        m.put("July", 7);
        m.put("August", 8);
        m.put("September", 9);
        m.put("October", 10);
        m.put("November", 11);
        m.put("December", 12);
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String day = "7";
        String month = "August";
        int year = 2025;
        driver.switchTo().frame(0);
         driver.findElement(By.id("datepicker")).click();

        while(true){
            String cur_month = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText(); //
            int cur_year = Integer.parseInt(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText());


            WebElement prev = driver.findElement(By.xpath("//a[@data-handler='prev']"));//This element is in iframe - //a[@class='ui-state-default ui-state-hover']
            WebElement next = driver.findElement(By.xpath("//a[@data-handler='next']"));

            if(cur_month.equals(month)&&cur_year==year) {
                break;
            }

            if(cur_year>year){
                prev.click();
                continue;

            }
            else if(cur_year<year) {
                next.click();
                continue;
            }

            if(m.get(month)>m.get(cur_month)){

                next.click();
                continue;
            }
            else if(m.get(month)<m.get(cur_month)){
                prev.click();
                continue;
            }



        }
        List<WebElement> dates = driver.findElements(By.xpath("//table//td[@data-handler='selectDay']//a"));
        for(WebElement d:dates){
            System.out.println(d.getText());
            if(d.getText().equals(day)) {
                d.click();
                break;
            }

        }


    }
}
