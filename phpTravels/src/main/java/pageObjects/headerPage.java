package pageObjects;

import features.common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class headerPage extends GlobalVariables {
    // DECLARE VARIABLES
    private  String sHotels ="//ul[@class='nav navbar-nav']//a[@title='Hotels']";
    private  String  sFlights = "//ul[@class='nav navbar-nav']//a[@title='Flights']";
    private  String  sTours = "//ul[@class='nav navbar-nav']//a[@title='Tours']";
    private  String  sCars = "//ul[@class='nav navbar-nav']//a[@title='Cars']";
    private  String  sVisa = "//ul[@class='nav navbar-nav']//a[@title='Ivisa']";
    private  String  sOffers = "//ul[@class='nav navbar-nav']//a[@title='Offers']";
    private  String  sBlog = "//ul[@class='nav navbar-nav']//a[@title='Blog']";

    // GET OBJECTS

    public WebElement getHotelObject()
    {
        return  driver.findElement(By.xpath(sHotels));
    }

    public WebElement getFlightsObject()
    {
        return  driver.findElement(By.xpath(sFlights));
    }
    public WebElement getToursObject()
    {
        return  driver.findElement(By.xpath(sTours));
    }
    public WebElement getCarsObject()
    {
        return  driver.findElement(By.xpath(sCars));
    }
    public WebElement getVisaObject()
    {
        return  driver.findElement(By.xpath(sVisa));
    }
    public WebElement getOfferObject()
    {
        return  driver.findElement(By.xpath(sOffers));
    }
    public WebElement getBlogObject()
    {
        return  driver.findElement(By.xpath(sBlog));
    }

    // Clicks on menu items
    public void clickHotels()
    {    System.out.println("Click on Hotels menu." );
        getHotelObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickFlights()
    {    System.out.println("Click on Flights menu." );
        getFlightsObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickTours()
    {    System.out.println("Click on Tours menu." );
        getToursObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickCar()
    {    System.out.println("Click on Car menu." );
        getCarsObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickVisa()
    {    System.out.println("Click on Visa menu." );
        getVisaObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickOffer()
    {    System.out.println("Click on Offers menu." );
        getOfferObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
    public void clickBlog()
    {    System.out.println("Click on Blog menu." );
        getBlogObject().click();
        commonFunctions.sleep(shortSleepTime);
    }
}
