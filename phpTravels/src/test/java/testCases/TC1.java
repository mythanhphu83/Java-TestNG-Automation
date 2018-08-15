package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import features.loginPage;

public class TC1 {
    WebDriver driver = new driverSetUp().getWebDriver();
    loginPage objLogin;





    @Test()
    public void test_Login_Successfully() {
        System.out.println("$$$$$$$$$$$$$$");
        System.out.println(driver);
        driver.get("https://www.phptravels.net/login");
        String username = "user@phptravels.com";
        String password = "demouser";
        objLogin = new loginPage(driver);
        objLogin.login(username, password);
    }
}





