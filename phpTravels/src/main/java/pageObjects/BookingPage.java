package pageObjects;
import java.text.DecimalFormat;
import java.util.*;
import features.common.GlobalVariables;
import features.common.commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {
    private WebDriver driver= GlobalVariables.driver;
    public List<String> getBookingDataOnLandingPageByRowIndex(int rowIndex){
        // Declare xpath of elements on One Row
        String sHotelNameLinkXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[1]//a[@class='dark']",rowIndex);
        String sCountryXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[1]//span[1]",rowIndex);
        String sStarRateXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[1]//*[@class='star fa fa-star']",rowIndex);
        String sPriceXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[1]//span[2]",rowIndex);
        String sCheckInDateXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[1]//*[@class='grey']",rowIndex);
        String sBookingInfoXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//div[2]//*[@class='grey']",rowIndex);

        // Declare webElements on the row
        WebElement hotelName=driver.findElement(By.xpath(sHotelNameLinkXpath));
        WebElement countryName=driver.findElement(By.xpath(sCountryXpath));
        List <WebElement> starRateList=driver.findElements(By.xpath(sStarRateXpath));
        WebElement checkInDate=driver.findElement(By.xpath(sCheckInDateXpath));
        WebElement price=driver.findElement(By.xpath(sPriceXpath));
        WebElement bookingInfo=driver.findElement(By.xpath(sBookingInfoXpath));

        // Add Hotel info into the list
        List <String> landingRowData=new ArrayList<String>();
        landingRowData.add(hotelName.getText());
        landingRowData.add(countryName.getText().replaceAll(" /",""));
        landingRowData.add(String.valueOf(starRateList.size()));
        landingRowData.add(getPriceFormat(price.getText()));
        landingRowData.add(checkInDate.getText());

        // Process BookingData
        String[] bookingData=bookingInfo.getAttribute("innerText").split("\n");
        String BookingID=(bookingData[0].split("Booking ID"))[1].trim();
        String BookingCode=(bookingData[1].split("Booking Code"))[1].trim();
        String DueDate=(bookingData[2].split("Due Date"))[1].trim();

        // Add booking info into the list
        landingRowData.add(BookingID);
        landingRowData.add(BookingCode);
        landingRowData.add(DueDate);
        return landingRowData;
    }

    public void clickInvoiceButtonByRowIndex(int rowIndex){
    String sInvoiceButtonXpath=String.format("//*[@id='bookings']/div[@class='row'][%d]//*[contains(@class,'btn-action btn-block')]",rowIndex);
    WebElement invoiceButton=driver.findElement(By.xpath(sInvoiceButtonXpath));
    invoiceButton.click();
    commonFunctions.sleep(GlobalVariables.shortSleepTime);
}

    public int getTotalRows() {
        String sRowListXpath = "//*[@id='bookings']/div[@class='row']";
        return driver.findElements(By.xpath(sRowListXpath)).size();
    }

    public String getPriceFormat(String text)
    {
        String strDollar="USD $";
        String number=text.replace(strDollar,"");
        String correctPriceFormat=strDollar+ convertNumberFormat(number);
       return correctPriceFormat;
    }

    public String convertNumberFormat(String number){
        String pattern;
        double d = Double.parseDouble(number);
        if (number.indexOf('.')>=0) pattern="#,###.00";
        else pattern="#,###";
        DecimalFormat formatter = new DecimalFormat(pattern);
        return formatter.format(d);
    }
}
