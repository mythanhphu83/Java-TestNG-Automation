package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class driverSetUp {
    private static WebDriver driver;


    public WebDriver getWebDriver(){
        return this.driver;
    }


    @Parameters("browser")
    private void setWebDriver(String browser) {

        System.out.println("$$$$$$$$$$$$$$");
        System.out.println(driver);
        // If the browser is Firefox, then do this
        if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        // If browser is Chrome, then do this
        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_2.41.exe");
            driver = new ChromeDriver();
        }
        // If browser is IE, then do this
        if (browser.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }


}