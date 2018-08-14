package pageObjects;

import features.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    private WebDriver driver;

    {
        driver = GlobalVariables.driver;
    }

    public WebElement txtEmail = driver.findElement(By.name("username"));
    public WebElement txtPassword = driver.findElement(By.name("password"));
    public WebElement btnLogin = driver.findElement(By.className("loginbtn"));
}
