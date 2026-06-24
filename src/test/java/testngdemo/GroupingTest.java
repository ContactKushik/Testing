package testngdemo;
import org.testng.annotations.Test;
public class GroupingTest {
    // We tag this as a "smoke" test
    @Test(groups = {"smoke"})
    public void login() {
        System.out.println("Login test running...");
    }

    // We tag this as a "regression" test
    @Test(groups = {"regression"})
    public void logout() {
        System.out.println("Logout test running...");
    }
}
