package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class flightsPage {
    WebDriver driver;

    public flightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFilter (String [] filter) {
        for (int i=0;i<filter.length;i++) {
            By chk_filter = By.xpath("//input[@id='" + filter[i] + "']/following::ins[1]");
            driver.findElement(chk_filter).click();
        }
    }

    public void filterSearchByFlights(String [] filter){
        this.setFilter(filter);
    }
}
