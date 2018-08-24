package pageObjects;
import features.common.commonFunctions;
import features.common.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver= GlobalVariables.driver;
    public WebElement txtEmail = driver.findElement(By.name("username"));
    public WebElement txtPassword = driver.findElement(By.name("password"));
    public WebElement btnLogin = driver.findElement(By.className("loginbtn"));
    public void setEmail(String sEmail)
    {
        txtEmail.clear();
        txtEmail.sendKeys(sEmail);
    }
    public void setPassword(String sPassword)
    {
        txtPassword.clear();
        txtPassword.sendKeys(sPassword);
    }
    public void clickLoginButton()
    {
        btnLogin.click();
        commonFunctions.sleep(GlobalVariables.shortSleepTime);
    }
}
