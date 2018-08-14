package features;
import pageObjects.loginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import static features.GlobalVariables.*;

public class commonFunctions {

    // Login with Email and Password
    public static void login(){
        initialChromeWebDriver();
        gotoURL("https://www.phptravels.net/login");
        String sEmail="user@phptravels.com";
        String sPassword="demouser";
        loginPage objLogin=new loginPage();
        objLogin.txtEmail.sendKeys(sEmail);
        objLogin.txtPassword.sendKeys(sPassword);
        objLogin.btnLogin.click();
        sleep(longSleepTime);

    }
    public static void sleep(long s)
    {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // gotoURL
    public static void gotoURL(String pageUrl)  {
        System.out.println("Go to url "+ pageUrl);
        driver.get(pageUrl);
        sleep(shortSleepTime);


    }
    public static void initialChromeWebDriver() {

        String exePath = "D:\\JavaWorkspace\\Project\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    // logout
    public static void logOut() {
        System.out.println("LOGOUT");
        driver.quit(); // close all window opening by WebDriver
    }
}
