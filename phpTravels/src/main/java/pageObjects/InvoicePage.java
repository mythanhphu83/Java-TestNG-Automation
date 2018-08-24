package pageObjects;

import features.common.GlobalVariables;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class InvoicePage {

    private WebDriver driver= GlobalVariables.driver;

    public WebElement pageTitle = driver.findElement(By.xpath("//head/title"));
    public WebElement headerTable=driver.findElement(By.xpath("//td[div[text()='Invoice']]"));
    public WebElement invoiceDate=headerTable.findElement(By.xpath("./div[1]"));
    public WebElement dueDate=headerTable.findElement(By.xpath("./div[2]"));
   // public WebElement invoiceHeaderLabel=headerTable.findElement(By.xpath("./div[3]"));
    public WebElement invoiceNumber=headerTable.findElement(By.xpath("./div[4]"));
    public WebElement bookingCode=headerTable.findElement(By.xpath("./div[5]"));
    public List<WebElement> startRateList=driver.findElements(By.xpath("//i[@class='star fa fa-star']"));
    public WebElement hotelName=driver.findElement(By.xpath("//i[@class='star fa fa-star']/parent::td"));
    public WebElement countryName=driver.findElement(By.xpath("//i[@class='star fa fa-star']/following::td"));
    public WebElement totalAmount=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody//td[3]"));

    public List<String> getInvoiceInfo()
    {
        List <String> InvoiceData=new ArrayList<String>();
        InvoiceData.add(hotelName.getText());
        InvoiceData.add(countryName.getText().replaceAll(" /",""));
        InvoiceData.add(String.valueOf(startRateList.size()));
        InvoiceData.add(totalAmount.getText());
        InvoiceData.add(invoiceDate.getText().replace("Invoice Date : ",""));
        InvoiceData.add(invoiceNumber.getText().replace("Invoice Number : ",""));
        InvoiceData.add(bookingCode.getText().replace("Booking Code ",""));
        InvoiceData.add(dueDate.getText().replace("Due Date : ",""));
        return InvoiceData;
    }

}
