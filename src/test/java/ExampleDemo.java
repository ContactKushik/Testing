import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class ExampleDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor d
        driver.get("https://demoqa.com/droppable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // 2. Define the target FOLDER path
        String projectPath = System.getProperty("user.dir");
        File screenshotDir = new File(projectPath + "/screenshot");

        // 3. Check if the folder exists, and create it if it doesn't
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }
        File trgt = new File(System.getProperty("user.dir")+"/screenshot/mySrc.jpg");

        WebElement e = driver.findElement(By.id("simpleDropContainer"));

        File src = e.getScreenshotAs(OutputType.FILE);


        FileHandler.copy(src, trgt);

        driver.quit();

    }
}
