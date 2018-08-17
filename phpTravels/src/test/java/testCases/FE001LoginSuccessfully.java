package testCases;
import features.common.commonFunctions;
import org.testng.Assert;
import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.loginPage;
import org.testng.annotations.Test;

import static features.common.GlobalVariables.*;

public class FE001LoginSuccessfully {
@Test
    public void test() {
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
       // accountPage AccountPage=new accountPage();

      //  String result=AccountPage.getBookingStatus();
    //    Assert.assertEquals(AccountPage.getBookingStatus(),"true","Bookings is not selected by default");
    //      Logout
    commonFunctions.logOut();


    }
}
