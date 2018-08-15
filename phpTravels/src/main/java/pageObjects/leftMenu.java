package pageObjects;

import static features.GlobalVariables.*;
import features.commonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class leftMenu {
    public WebElement menuBookings = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#bookings\"]"));
    public WebElement menuMyProfiles = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#profile\"]"));
    public WebElement menuWishList = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#wishlist\"]"));
    public WebElement menuNewsLetter = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#newsletter\"]"));


    public void clickBookings()
    {
        this.menuBookings.click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickMyProfiles()
    {
        this.menuMyProfiles.click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickWishList()
    {
        this.menuWishList.click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickNewsLetter()
    {
        this.menuNewsLetter.click();
        commonFunctions.sleep(shortSleepTime);
    }
}
