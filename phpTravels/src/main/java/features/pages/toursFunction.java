package features.pages;
import features.common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class toursFunction extends GlobalVariables{
    public void setStarGrade(int starGrade) {
        if (starGrade >= 1 && starGrade <= 5) {
            WebElement rdo_starGrade = driver.findElement(By.xpath("//input[@id='" + starGrade + "']/following::ins[1]"));
            rdo_starGrade.click();
        }
        else {
            System.out.println("Invalid data: Data must be from 1 to 5");
        }
    }

    public void setPriceRangeByTours(int minPrice, int maxPrice){
        WebElement sld_slider = driver.findElement(By.xpath("//*[@class='slider-selection']"));
        WebElement sld_Left = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[1]"));
        WebElement sld_Right = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[2]"));
        int widthSliderBar = sld_slider.getSize().getWidth();
        int maxValue = 800;
        int minValue = 60;
        int pixel = (widthSliderBar / ((maxValue - minValue) / 100)) + 1;
        int minPixel = (((minPrice - minValue) / 100) * pixel);
        int maxPixel = ((maxPrice - maxValue) / 100) * pixel;
        Actions action = new Actions(driver);
        action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
        action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();

    }
    public void setTourType(String tourType) {
        WebElement rdo_tourType = driver.findElement(By.xpath("//input[@id='" + tourType + "']/following::ins[1]"));
        rdo_tourType.click();
    }

    public void clickSearch() {
        WebElement btn_search = driver.findElement(By.xpath("//button[@id='searchform']"));
        btn_search.click();
    }

    public void filterSearchByTours(int starGrage, int minPrice, int maxPrice, String tourType){
        this.setStarGrade(starGrage);
        this.setPriceRangeByTours(minPrice, maxPrice);
        this.setTourType(tourType);
        this.clickSearch();
    }
  }

