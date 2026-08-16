package day47testngdemo;

// Change this import from org.junit.Test to org.testng.annotations.Test
import org.testng.annotations.Test;

public class SimpleExample {

    @Test(priority=1)
    public void logout() {
        System.out.println("Logout from application.....");
    }

    @Test(priority=0)
    public void login() {
        System.out.println("Login to application.....");
    }

    @Test(priority=-1)
    public void openapp() {
        System.out.println("opening application...");
    }
}