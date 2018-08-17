package testCases;
import features.commonFunctions;
import org.testng.Assert;
import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.loginPage;

import static features.GlobalVariables.*;

public class FE001Loginsucessful {

    public static void main(String[] args) {
  commonFunctions.initialChromeWebDriver();
     commonFunctions.gotoURL(phpTravelURL);
     homePage objHomePage= new homePage();
     objHomePage.clickLoginFromMyAccount();
      /* Assert.assertEquals(driver.getTitle(),"Login","Incorrect Login Page Title "+driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),loginURL,"Incorrect Login Page url="+driver.getCurrentUrl());*/
        loginPage login=new loginPage();
        login.setEmail(userEmail);
        login.setPassword(password);
        login.clickLoginButton();
        accountPage AccountPage=new accountPage();

      //  String result=AccountPage.getBookingStatus();
    //    Assert.assertEquals(AccountPage.getBookingStatus(),"true","Bookings is not selected by default");
     commonFunctions.closeBrowser();
	 commonFunctions.closeBrowser();

    }
}
