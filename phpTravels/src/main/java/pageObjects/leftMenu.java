package pageObjects;

import features.common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class leftMenu extends GlobalVariables{
    public WebElement menuBookings = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#bookings\"]"));
    public WebElement menuMyProfiles = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#profile\"]"));
    public WebElement menuWishList = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#wishlist\"]"));
    public WebElement menuNewsLetter = driver.findElement(By.xpath("//ul[@class='nav profile-tabs']//a[@href=\"#newsletter\"]"));
    public WebElement bookingIcon = driver.findElement(By.className("bookings-icon"));
    public WebElement myProfileIcon = driver.findElement(By.className("profile-icon"));
    public WebElement wishlistIcon = driver.findElement(By.className("wishlist-icon"));
    public WebElement newsletterIcon = driver.findElement(By.className("newsletter-icon"));

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
    public boolean isMenuSelected(String sMenuItem)
    {
        String sXpath="//ul[@class='nav profile-tabs']/*[@class='active']/a[contains(@href,'"+sMenuItem+"')]";
        WebElement selectedMenu = driver.findElement(By.xpath(sXpath));
        if (selectedMenu.isDisplayed())

            return true;
        else
            return false;

    }

    public boolean verifyLeftMenuBarLabel()
    {
        if (!menuBookings.getText().contains("Bookings")) {
            System.out.println("Incorrect Booking label");
            return false;
        }
        if (!menuMyProfiles.getText().contains("My Profile")) {
            System.out.println("Incorrect My Profile label");
            return false;
        }
        if (!menuWishList.getText().contains("Wishlist")) {
            System.out.println("Incorrect Wishlist label");
            return false;
        }
        if (!menuNewsLetter.getText().contains("Newsletter")) {
            System.out.println("Incorrect Newsletter label");
            return false;
        }
         return true;

    }
    public boolean verifyMenuBarIcons()
    {
        if (!bookingIcon.isDisplayed()) {
            System.out.println("Booking icon is not displayed");
            return false;
        }
        if (!myProfileIcon.isDisplayed()) {
            System.out.println("My Profile icon is not displayed");
            return false;
        }
        if (!wishlistIcon.isDisplayed()) {
            System.out.println("Wishlist icon is not displayed");
            return false;
        }
        if (!newsletterIcon.isDisplayed()) {
            System.out.println("New Letter icon is not displayed");
            return false;
        }
        return true;
    }
}
