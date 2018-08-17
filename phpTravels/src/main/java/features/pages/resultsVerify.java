package features.pages;
import features.common.*;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class resultsVerify extends GlobalVariables{

    WebElement baseTable = driver.findElement(By.tagName("table"));
    List<WebElement> tableRows = baseTable.findElements(By.xpath("//table//td[contains(@class,'wow fadeIn')]"));

    public void waitForImageLoading() {
        List<WebElement> img = driver.findElements(By.xpath("//img[contains(@src,'loader')]"));
        System.out.println("========LOADING IMAGE========"+img.size());
        while (img.size() > 0) {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> img1 = driver.findElements(By.xpath("//img[contains(@src,'loader')]"));
            img=img1;
        }
    }

    public void verifyAirportPickup(boolean isButtonPresented){
        int r = 1;
        String bgColor = "rgba(92, 184, 92, 1)";
        for (WebElement trCell: tableRows) {
            WebElement cellAirportPickup = trCell.findElement(By.xpath("//tr["+r+"]//button[./text()=' Airport Pickup']"));
            Assert.assertEquals(cellAirportPickup.getCssValue("background-color:"),bgColor);
            if(cellAirportPickup.isDisplayed()==true) {
                Assert.assertEquals(isButtonPresented, cellAirportPickup.isDisplayed());
//                    System.out.println("The Airport Pickup button is displayed: " + cellAirportPickup.getText());
            }
            else {
                Assert.assertEquals(false, cellAirportPickup.isDisplayed());
//                    System.out.println("The Airport Pickup button is NOT displayed");
            }
            r++;
        }
    }
    public void verifyStarGrade(int starGradeNum){
        int r = 1;
        for (WebElement trCell: tableRows) {
            List<WebElement> cellStarGrade = trCell.findElements(By.xpath("//tr["+r+"]//i[@class='star fa fa-star']"));
            Assert.assertTrue(cellStarGrade.size() >= starGradeNum);
            r++;
        }
    }
    public void verifyTourType(String tourType){
        int r = 1;
        waitForImageLoading();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for (WebElement trCell: tableRows) {
            WebElement cellTourType = trCell.findElement(By.xpath("//tr["+r+"]//*[text()='Tour Type']/following-sibling::a[1]"));
            System.out.println("==============TOUR TYPE is "+r+": "+cellTourType.getAttribute("innerText"));
            Assert.assertEquals(tourType, cellTourType.getAttribute("innerText"));
            r++;
        }
    }
    public List<String> getCheckedAirlineNameList(){
        List<String> checkedItemList = new ArrayList<String>();
        List<WebElement> checkedList = driver.findElements(By.xpath("//div[@class='panel-body']//div[./*[contains(@class,'checked')]]/following-sibling::label//img"));
        for (WebElement e: checkedList){
            String item = e.getAttribute("src").trim();
            checkedItemList.add(item);
        }
        return checkedItemList;
    }
    public void verifyAirlineNameList(){
        List<String> listItem = getCheckedAirlineNameList();
        int r = 1;
        for (WebElement trCell: tableRows) {
            WebElement cellAirlineName = trCell.findElement(By.xpath("//tr["+r+"]//div[contains(@class,'col-md-2')]/img"));
            String sub = cellAirlineName.getAttribute("src");
            Assert.assertTrue(listItem.contains(sub));
            r++;
        }
    }

//    List<WebElement> pageList = driver.findElements(By.xpath("//*[contains(@class,'pagination')]//li/a"));
//    public void waitForImageLoading(){
//        List<WebElement> img = driver.findElements(By.xpath("//img[contains(@src,'loader')]"));
//        while (img.size()>0)
//            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        }
//    }
//    public void clickOnPage(int pageNum){
//        WebElement page = driver.findElement(By.xpath("//*[contains(@class,'pagination')]//li//a[text()='"+pageNum+"']"));
//        if (page.isDisplayed()==true){
//            page.click();
//            waitForImageLoading();
//        }else {
//            System.out.println("The page "+pageNum+" is NOT existed");
//        }
//    }
//    public void clickNextPage(boolean nextPage){
//        if (nextPage == true){
//            pageList.get(pageList.size()).click();
//            waitForImageLoading();
//        }else {
//            pageList.get(1).click();
//            waitForImageLoading();
//        }
//
//    }
}
