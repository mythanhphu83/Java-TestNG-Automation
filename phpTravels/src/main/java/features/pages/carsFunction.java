package features.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class carsFunction {
    WebDriver driver;

    public carsFunction(WebDriver driver) {
        this.driver = driver;
    }

    public void setStarGrade(int starGrade) {
        if (starGrade >= 1 && starGrade <= 5) {
            WebElement rdo_starGrade = driver.findElement(By.xpath("//input[@id='" + starGrade + "']/following::ins[1]"));
            rdo_starGrade.click();
        }
        else {
            System.out.println("Invalid data: Data must be from 1 to 5");
        }
    }

    public void setPriceRangeByCars(int minPrice, int maxPrice){
        WebElement sld_slider = driver.findElement(By.xpath("//*[@class='slider-selection']"));
        WebElement sld_Left = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[1]"));
        WebElement sld_Right = driver.findElement(By.xpath("//*[@class='slider-selection']/following::div[2]"));
        int widthSliderBar = sld_slider.getSize().getWidth();
        int maxValue = 600;
        int minValue = 60;
        int pixel = (widthSliderBar / ((maxValue - minValue) / 100)) + 1;
        int minPixel = (((minPrice - minValue) / 100) * pixel);
        int maxPixel = ((maxPrice - maxValue) / 100) * pixel;
        Actions action = new Actions(driver);

        if(minPrice == minValue && maxPrice == maxValue){
            System.out.println("No set Price Range");
        }
        else if (minPrice == minValue && maxPrice < maxValue) {
            action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();
        } else if (minPrice > minValue && maxPrice == maxValue) {
            action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
        } else if (minPrice > minValue && maxPrice < maxValue) {
            action.dragAndDropBy(sld_Left, minPixel, 0).build().perform();
            action.dragAndDropBy(sld_Right, maxPixel, 0).build().perform();
        } else {
            System.out.println("Invalid data: Data must be from 50, 60, 70, ... to 500");
        }
    }
    public void setCarType(String carType) {
        WebElement rdo_carType = driver.findElement(By.xpath("//input[@id='" + carType + "']/following::ins[1]"));
        rdo_carType.click();
    }

    public void selectPickUp(String pickUp) {
        Select rdo_airportPickUp = new Select(driver.findElement(By.xpath("//select[@class='selectx' and @name='pickup']")));
        rdo_airportPickUp.selectByVisibleText(pickUp);
    }

    public void clickSearch() {
        WebElement btn_search = driver.findElement(By.xpath("//button[@id='searchform']"));
        btn_search.click();
    }

    public void filterSearchByCars(int starGrage, int minPrice, int maxPrice, String carType, String pickUp){
        this.setStarGrade(starGrage);
        this.setPriceRangeByCars(minPrice, maxPrice);
        this.setCarType(carType);
        this.selectPickUp(pickUp);
        this.clickSearch();
    }
}
