package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class FE008VisaValidatePassportIssuedDate {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://www.phptravels.net/ivisa";
        driver.get(baseUrl);

        WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@data-ivisa-label=\"Email address\"]"));
        WebElement txtArrialDate = driver.findElement(By.xpath("//input[@data-ivisa-label=\"Arrival Date in Canada\"]"));
        WebElement txtPhone = driver.findElement(By.xpath("//input[@data-ivisa-label=\"Phone\"]"));
        WebElement txtHomeAddress = driver.findElement(By.xpath("//input[@data-ivisa-label=\"Home Address (include city & ZIP code)\"]"));
        WebElement ddlHomeCountry = driver.findElement(By.xpath("//select[@data-ivisa-label=\"Home Country\"]"));
        WebElement ddlTravelingBy = driver.findElement(By.xpath("//select[@data-ivisa-label=\"Traveling By\"]"));

        WebElement txtFirstAndMiddleName = driver.findElement(By.xpath("(//input[@data-ivisa-label=\"First and Middle Name\"])[2]"));
        WebElement txtLastName = driver.findElement(By.xpath("(//input[@data-ivisa-label=\"Last Name\"])[2]"));
        WebElement ddlNationality = driver.findElement(By.xpath("(//select[@data-ivisa-label=\"Nationality (as in Passport)\"])[2]"));
        WebElement dtpBirthday = driver.findElement(By.xpath("(//input[@data-ivisa-label=\"Birthday\"])[2]"));
        WebElement ddlGender = driver.findElement(By.xpath("(//select[@data-ivisa-label=\"Gender\"])[2]"));
        WebElement txtPassportNumber = driver.findElement(By.xpath("(//input[@data-ivisa-label=\"Passport Number\"])[2]"));
        WebElement lblPassportIssued = driver.findElement(By.xpath("(//label[.=\"Passport Issued\"])[2]/parent::*"));
        WebElement ddlPassportExpiration = driver.findElement(By.xpath("(//input[@data-ivisa-label=\"Passport Expiration\"])[1]"));
        WebElement ddlCanadaVisaType = driver.findElement(By.xpath("(//select[@data-ivisa-label=\"Canada Visa Type\"])[2]"));
        WebElement btnNext = driver.findElement(By.xpath("//button[.=\"Next\"]"));

        //Date
//        WebElement ddlMonth = driver.findElement(By.xpath("//select[@id=\"dp_month\"]"));
//        WebElement ddlDay = driver.findElement(By.xpath("//select[@id=\"dp_day\"]"));
//        WebElement ddlYear = driver.findElement(By.xpath("//select[@id=\"dp_year\"]"));
//        WebElement btnSave = driver.findElement(By.id("dp_save"));

        txtEmailAddress.sendKeys("test@kms.com");

        txtArrialDate.click();
        /////

        txtPhone.sendKeys("123456");

        txtHomeAddress.sendKeys("2 Tan Vien");

        ddlHomeCountry.click();
        Select dropdownHomeCountry =new Select(ddlHomeCountry);
        dropdownHomeCountry.selectByVisibleText("Vietnam (VN)");

        ddlTravelingBy.click();
        Select dropdownTravelingBy =new Select(ddlTravelingBy);
        dropdownTravelingBy.selectByVisibleText("Air");
        ddlTravelingBy.click();

        txtFirstAndMiddleName.sendKeys("hong");
        txtLastName.sendKeys("nguyen");

        ddlNationality.click();
        Select dropdownNationality =new Select(ddlNationality);
        dropdownNationality.selectByVisibleText("Mexico (MX)");

//        dtpBirthday.click();
//        Select dropdownMonth = new Select(ddlMonth);
//        dropdownMonth.selectByVisibleText("5 - May");
//        Select dropdownDay = new Select(ddlDay);
//        dropdownDay.selectByVisibleText("1");
//        Select dropdownYear =new Select(ddlYear);
//        dropdownYear.selectByVisibleText("2017");
//        btnSave.click();

        ddlGender.click();
        Select dropdownGender = new Select(ddlGender);
        dropdownGender.selectByVisibleText("Female");

        txtPassportNumber.sendKeys("123456");

//        ddlPassportExpiration.click();
//        dropdownMonth.selectByVisibleText("5 - May");
//        dropdownDay.selectByVisibleText("1");
//        dropdownYear.selectByVisibleText("2017");
//        btnSave.click();

        ddlCanadaVisaType.click();
        Select dropdownCanadaVisaType =new Select(ddlCanadaVisaType);
        dropdownCanadaVisaType.selectByVisibleText("ETA - 180 days, Multiple Entry");

        btnNext.click();

        String color = lblPassportIssued.getCssValue("border").trim();
        System.out.println("Color: " + color);
        String expected_color = "rgb(255, 0, 0)";

        String actual_color = color.substring(10,24);
        System.out.println("Color: " + actual_color);
        System.out.println("Color: " + expected_color);
        // assertEquals("actual_color should equal to: ", "rgb(255, 0, 0)", actual_color);
        assertEquals(actual_color,expected_color,"Check color");

    }
}
