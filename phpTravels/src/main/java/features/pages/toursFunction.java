package features.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class toursFunction {
    WebDriver driver;

    public toursFunction(WebDriver driver) {
        this.driver = driver;
    }

    public void setStarGrade(int starGrade) {
        By rdo_starGrade = By.xpath("//input[@id='" + starGrade + "']/following::ins[1]");
        driver.findElement(rdo_starGrade).click();
    }

    public void setPriceRangeByTours(int minPrice, int maxPrice){
        WebElement sld_slider = driver.findElement(By.xpath("//*[@class='slider-selection']"));
        WebElement sld_Left = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[1]"));
        WebElement sld_Right = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[2]"));
        int widthSliderBar = sld_slider.getSize().getWidth();
        int maxValue = 800;
        int minValue = 60;
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

    public void setTourType(String tourType) {
        By rdo_tourType = By.xpath("//input[@id='" + tourType + "']/following::ins[1]");
        driver.findElement(rdo_tourType).click();
    }

    public void clickSearch() {
        By btn_search = By.xpath("//button[@id='searchform']");
        driver.findElement(btn_search).click();
    }

    public void filterSearchByTours(int starGrage, int minPrice, int maxPrice, String tourType){
        this.setStarGrade(starGrage);
        this.setPriceRangeByTours(minPrice, maxPrice);
        this.setTourType(tourType);
        this.clickSearch();
    }
  }

