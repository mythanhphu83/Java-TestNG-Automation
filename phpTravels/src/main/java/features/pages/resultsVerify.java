package features.pages;
import features.common.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class resultsVerify extends basePage {
    WebDriver driver;

    public resultsVerify(WebDriver driver) {
        this.driver = driver;
    }

    WebElement baseTable = driver.findElement(By.tagName("table"));
//    List<WebElement> tableRows = baseTable.findElements(By.xpath("//table[@class='bgwhite table table-striped']//td[contains(@class,'wow fadeIn')]"));
    List<WebElement> tableRows = baseTable.findElements(By.xpath("//table//td[contains(@class,'wow fadeIn')]"));

    public void verifyAirportPickup(boolean isButtonPresented){
        int r = 1;
        for (WebElement trCell: tableRows) {
                WebElement cellAirportPickup = trCell.findElement(By.xpath("(//button[./text()=' Airport Pickup'])["+r+"]"));
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
            WebElement cellTourType = trCell.findElement(By.xpath("//tr["+r+"]//*[text()='Tour Type']/following-sibling::a["+r+"]"));
            Assert.assertEquals(tourType, cellTourType.getText());
            r++;
        }
    }

    public void verifyAirlineName(String[] airlineNameList){
        int r = 1;
        for (WebElement trCell: tableRows) {
            WebElement cellAirlineName = trCell.findElement(By.xpath("//tr["+r+"]//div[contains(@class,'col-md-2')]/img"));
            String sub = cellAirlineName.getAttribute("baseURI");
            String array1[] = sub.split("0/");
//            Assert.assertTrue(cellAirlineName.getAttribute("baseURI").contains([airlineNameList]));
            r++;
        }
    }
}
