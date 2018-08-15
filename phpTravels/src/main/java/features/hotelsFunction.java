package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class hotelsPage {
    WebDriver driver;

    public hotelsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setStarGrade(int starGrade) {
        By rdo_starGrade = By.xpath("//input[@id='" + starGrade + "']/following::ins[1]");
        driver.findElement(rdo_starGrade).click();
    }

    public void setPriceRangeByHotels(int minPrice, int maxPrice) {
        WebElement sld_slider = driver.findElement(By.xpath("//*[@class='slider-selection']"));
        WebElement sld_Left = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[1]"));
        WebElement sld_Right = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[2]"));
        int widthSliderBar = sld_slider.getSize().getWidth();
        int maxValue = 500;
        int minValue = 50;
        int pixel = (widthSliderBar / ((maxValue - minValue) / 10))+1;
        int minPixel = (((minPrice - minValue)/10) * pixel) - pixel;
        int maxPixel = ((maxPrice - maxValue)/10) * pixel;
        Actions action = new Actions(driver);

        if (minPrice == minValue && maxPrice < maxValue) {
            action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();
        }

        if(minPrice > minValue && maxPrice == maxValue) {
            action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
        }

        if (minPrice > minValue && maxPrice < maxValue){
            action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
            action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();
        }
    }

    public void setPropertyTypes(String [] propertyTypes) {
        for (int i=0;i<propertyTypes.length;i++) {
            By chk_propertyTypes = By.xpath("//input[@id='" + propertyTypes[i] + "']/following::ins[1]");
            driver.findElement(chk_propertyTypes).click();
        }
    }

    public void setAmenities(String [] amenities) {
        for (int i=0;i<amenities.length;i++) {
            By chk_amenities = By.xpath("//input[@id='" + amenities[i] + "']/following::ins[1]");
            driver.findElement(chk_amenities).click();
        }
    }

    public void clickSearch() {
        By btn_search = By.xpath("//button[@id='searchform']");
        driver.findElement(btn_search).click();
    }

    public void filterSearchByHotels(int starGrage, int minPrice, int maxPrice, String [] propertyTypes, String [] amenities){
        this.setStarGrade(starGrage);
        this.setPriceRangeByHotels(minPrice, maxPrice);
        this.setPropertyTypes(propertyTypes);
        this.setAmenities(amenities);
        this.clickSearch();
    }
}
