package features.pages;
import features.common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class flightsFunction extends GlobalVariables {
    public void setStatus(String status) {
        if (status.toLowerCase().equals("nonstop")) {
            WebElement chk_status = driver.findElement(By.xpath("//input[@id='nonstop']/following::ins[1]"));
            System.out.println(chk_status.isSelected());
            if (chk_status.isSelected() == true) {
                chk_status.click();
                chk_status.click();
            }
            chk_status.click();
        }
        else if (status.toLowerCase().equals("transit")) {
            WebElement chk_status = driver.findElement(By.xpath("//input[@id='nonstop1']/following::ins[1]"));
            System.out.println(chk_status.isSelected());
            if (chk_status.isSelected() == true) {
                chk_status.click();
                chk_status.click();
            }
            chk_status.click();
        }
        else if (status.toLowerCase().equals("refundable")){
            WebElement chk_status = driver.findElement(By.xpath("//input[@id='Refundable']/following::ins[1]"));
            System.out.println(chk_status.isSelected());
            if (chk_status.isSelected() == true) {
                chk_status.click();
                chk_status.click();
            }
            chk_status.click();
        } else
        {
            System.out.println("No set Status");
        }

    }


    public void setFilter (String [] filter) {
        for (int i=0;i<filter.length;i++) {
            WebElement chk_filter = driver.findElement(By.xpath("//input[@value='" + filter[i] + "']/following::ins[1]"));
            System.out.println(chk_filter.isSelected());
            if(chk_filter.isSelected() == true){
                chk_filter.click();
                chk_filter.click();
            }
                chk_filter.click();
        }
    }

    public void filterSearchByFlights(String [] filter, String status){
        this.setStatus(status);
        this.setFilter(filter);

    }
}
