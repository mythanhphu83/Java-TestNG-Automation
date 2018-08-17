package testCases;
import features.common.commonFunctions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.loginPage;
import org.testng.annotations.Test;

import static features.common.GlobalVariables.*;

public class FE001LoginSuccessfully {
    @BeforeTest
    public void beforeMethod() {
        System.out.println("===BEFORE TEST====");
      commonFunctions.initialChromeWebDriver();
    }
    @Test
    public void test() {
        // Goto Home page
         commonFunctions.gotoURL(phpTravelURL);
         homePage objHomePage= new homePage();
         objHomePage.clickLoginFromMyAccount();
        //  Verify page title
         Assert.assertEquals(driver.getTitle(),"Login","Incorrect Login Page Title "+driver.getTitle());
        //  Verify page url
        Assert.assertEquals(driver.getCurrentUrl(),loginURL,"Incorrect Login Page url="+driver.getCurrentUrl());
        loginPage login=new loginPage();
        login.setEmail(userEmail);
        login.setPassword(password);
        login.clickLoginButton();
        accountPage AccountPage=new accountPage();
        // Verify User Name
        Assert.assertEquals(AccountPage.getUserName(),"Hi, Johny Smith","Incorrect User Name");
        //  Verify Current Day as format .Example 08 August 2018
        AccountPage.verifyFormatDate();
        //  Verify Booking menu item is selected by default
        Assert.assertTrue(AccountPage.isBookingSelected(),"Booking is not selected");
        //  Verify Left Menu Labels
        Assert.assertTrue(AccountPage.menu.verifyLeftMenuBarLabel(),"Left Menu Labels are incorrect");
        //  Verify Left Menu icons
        Assert.assertTrue(AccountPage.menu.verifyMenuBarIcons(),"Left Menu Icons are incorrect");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AFTER TEST===");
         commonFunctions.logOut();
    }
}
