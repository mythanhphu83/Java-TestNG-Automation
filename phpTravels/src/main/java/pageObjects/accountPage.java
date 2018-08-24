package pageObjects;
import java.text.SimpleDateFormat;
import java.util.Date;
import features.common.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class accountPage {
    private WebDriver driver;

    {
        driver = GlobalVariables.driver;
    }
    private String sUserName="//h3[@class='RTL']";
    private String sDate="//div[@class='go-left']//*[@class='h4']";
    private String sTitle="//title";

    public WebElement getDateObject(){
        return driver.findElement(By.className("h4"));
    }
    public leftMenu menu=new leftMenu();

    public Boolean isBookingSelected()
    {
        return menu.isMenuSelected("bookings");
    }
    public String getUserName()
    {
        WebElement lblUserName=driver.findElement(By.className("RTL"));
        return lblUserName.getText();
     }

    public Boolean verifyFormatDate(){

    SimpleDateFormat formatter=new SimpleDateFormat("dd MMMMM YYYY");
    String sExpectedDate=formatter.format(new Date()).toString();
    String sActualDate=getDateObject().getText();
      if (sActualDate.equals(sExpectedDate)) return true;
      else  return false;
      }
}
