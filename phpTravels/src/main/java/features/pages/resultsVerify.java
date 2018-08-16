package features.pages;
import features.common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class resultsVerify extends GlobalVariables{

    WebElement baseTable = driver.findElement(By.tagName("table"));
    List<WebElement> tableRows = baseTable.findElements(By.xpath("//table//td[contains(@class,'wow fadeIn')]"));

    public void verifyAirportPickup(boolean isButtonPresented){
        int r = 1;
        String bgColor = "rgba(92, 184, 92, 1)";
        for (WebElement trCell: tableRows) {
            WebElement cellAirportPickup = trCell.findElement(By.xpath("(//button[./text()=' Airport Pickup'])["+r+"]"));
//            System.out.println("===========COLOR===: "+cellAirportPickup.getCssValue("background-color"));/
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
            Assert.assertEquals(starGradeNum, cellStarGrade.size());
            r++;
        }
    }
    public void verifyTourType(String tourType){
        int r = 1;
        for (WebElement trCell: tableRows) {
            WebElement cellTourType = trCell.findElement(By.xpath("//tr["+r+"]//*[text()='Tour Type']/following-sibling::a[1]"));
            System.out.println("=============="+r+": "+cellTourType.getAttribute("innerText"));
//            Assert.assertEquals(tourType, cellTourType.getAttribute("innerText"));
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
}
