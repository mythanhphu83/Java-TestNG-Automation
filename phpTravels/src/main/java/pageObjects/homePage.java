package pageObjects;
import static features.common.GlobalVariables.*;
import features.common.commonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class homePage {
    private String sMyAccount="//nav[contains(@class,'navbar-default')]//*[@id='li_myaccount']/a";
    private String sLogin="//nav[contains(@class,'navbar-default')]//a[contains(@href,'login')]";

    public WebElement getMyAccountObject()
    {
        return driver.findElement(By.xpath(sMyAccount));
    }
    public WebElement getLoginObject()
    {
        return driver.findElement(By.xpath(sLogin));
    }

    public void clickLoginFromMyAccount()
    {
        System.out.println("CLick My Account >> Login menu from Homepage.");
        this.getMyAccountObject().click();
        this.getLoginObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
}
