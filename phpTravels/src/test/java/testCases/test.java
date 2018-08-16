package testCases;


import features.pages.carsFunction;
import features.pages.flightsFunction;
import features.pages.toursFunction;
import org.openqa.selenium.WebDriver;
import features.pages.hotelsFunction;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;
    hotelsFunction objhotelsFunction;
    toursFunction objtoursFunction;
    flightsFunction objfightFunctions;
    carsFunction objcarsFunction;


    @Test
    public void test() {
        String type = "Private";


        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\win64\\chromedriver_2.41.exe");
        driver = new ChromeDriver();
        objhotelsFunction = new hotelsFunction(driver);
        objtoursFunction = new toursFunction(driver);
        objfightFunctions = new flightsFunction(driver);
        objcarsFunction = new carsFunction(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/login");
        driver.navigate().to("https://www.phptravels.net/cars");
        driver.manage().window().maximize();


    }

}
