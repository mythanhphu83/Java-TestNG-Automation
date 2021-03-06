package features.common;
import pageObjects.loginPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class commonFunctions extends GlobalVariables {

    // Login with default Email and Password
    public static void login(){
        initialChromeWebDriver();
        gotoURL(loginURL);
        loginPage objLogin=new loginPage();
        objLogin.setEmail(userEmail);
        objLogin.setPassword(password);
        objLogin.clickLoginButton();
        sleep(shortSleepTime);

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

        String exePath = "./drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    // logout
    public static void logOut() {
        System.out.println("LOGOUT");
        driver.close();
        driver.quit(); // close all window opening by WebDriver
    }
}
