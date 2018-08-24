package features.common;
import pageObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;


public class commonFunctions {

    // Login with default Email and Password
    public static void login(){
        initialChromeWebDriver();
        gotoURL(GlobalVariables.loginURL);
        LoginPage objLogin=new LoginPage();
        objLogin.setEmail(GlobalVariables.userEmail);
        objLogin.setPassword(GlobalVariables.password);
        objLogin.clickLoginButton();
        sleep(GlobalVariables.shortSleepTime);
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
        GlobalVariables.driver.get(pageUrl);
        sleep(GlobalVariables.shortSleepTime);


    }
    public static void initialChromeWebDriver() {

        String exePath = "./drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        GlobalVariables.driver= new ChromeDriver();
        GlobalVariables.driver.manage().window().maximize();
    }
    public static int generateRandomIntergerNumber(int minNumber,int maxNumber){
        Random rand = new Random();
        int i = rand.nextInt(maxNumber) + minNumber;
        return i;

    }
    public static void swithToNewOpenedWindow()
    {
        for(String curWindow : GlobalVariables.driver.getWindowHandles()){
            GlobalVariables.driver.switchTo().window(curWindow);
        }
        System.out.println("SWITCH TO OPENED WINDOW.");
        GlobalVariables.driver.manage().window().maximize();
    }
    // logout
    public static void logOut() {
        System.out.println("LOGOUT");
        GlobalVariables.driver.close();
        GlobalVariables.driver.quit(); // close all window opening by WebDriver
    }
}
