package features.pages;
import features.common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class hotelsFunction extends GlobalVariables{
    public void setStarGrade(int starGrade) {
        if (starGrade >= 1 && starGrade <= 5) {
            WebElement rdo_starGrade = driver.findElement(By.xpath("//input[@id='" + starGrade + "']/following::ins[1]"));
            rdo_starGrade.click();
        }
        else {
            System.out.println("Invalid data: Data must be from 1 to 5");
        }
    }

    public void setPriceRangeByHotels(int minPrice, int maxPrice) {

            WebElement sld_slider = driver.findElement(By.xpath("//*[@class='slider-selection']"));
            WebElement sld_Left = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[1]"));
            WebElement sld_Right = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[2]"));
            int widthSliderBar = sld_slider.getSize().getWidth();
            int maxValue = 500;
            int minValue = 50;
            int pixel = (widthSliderBar / ((maxValue - minValue) / 10)) + 1;
            int minPixel = (((minPrice - minValue) / 10) * pixel);
            int maxPixel = ((maxPrice - maxValue) / 10) * pixel;
            Actions action = new Actions(driver);
            action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
            action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();

    }


    public void setPropertyTypes(String [] propertyTypes) {
        for (int i=0;i<propertyTypes.length;i++) {
            WebElement chk_propertyTypes = driver.findElement(By.xpath("//input[@id='" + propertyTypes[i] + "']/following::ins[1]"));
            System.out.println(chk_propertyTypes.isSelected());
            if (chk_propertyTypes.isSelected()==true){
                chk_propertyTypes.click();
                chk_propertyTypes.click();
            }
            chk_propertyTypes.click();
        }
    }

    public void setAmenities(String [] amenities) {
        for (int i=0;i<amenities.length;i++) {
            WebElement chk_amenities = driver.findElement(By.xpath("//input[@id='" + amenities[i] + "']/following::ins[1]"));
            System.out.println(chk_amenities.isSelected());
            if (chk_amenities.isSelected()==true) {
                chk_amenities.click();
                chk_amenities.click();
            }
                chk_amenities.click();
        }
    }

    public void clickSearch() {
             WebElement btn_search = driver.findElement(By.xpath("//button[@id='searchform']"));
             btn_search.click();
    }

    public void filterSearchByHotels(int starGrage, int minPrice, int maxPrice, String [] propertyTypes, String [] amenities){
            this.setStarGrade(starGrage);
            this.setPriceRangeByHotels(minPrice, maxPrice);
            this.setPropertyTypes(propertyTypes);
            this.setAmenities(amenities);
            this.clickSearch();
    }
}
