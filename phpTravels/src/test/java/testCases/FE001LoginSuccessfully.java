package testCases;
import features.common.commonFunctions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.LoginPage;
import org.testng.annotations.Test;
import features.common.GlobalVariables;


public class FE001LoginSuccessfully {
    @BeforeTest
    public void beforeTest() {
        commonFunctions.initialChromeWebDriver();
    }
    @Test
    public void test() {
        System.out.println("********* TEST CASE:FE01 Login Successfully");
        // Goto Home page
        commonFunctions.gotoURL(GlobalVariables.phpTravelURL);
         homePage objHomePage= new homePage();
         objHomePage.clickLoginFromMyAccount();
        //  Verify page title
         Assert.assertEquals(GlobalVariables.driver.getTitle(),"Login","Incorrect Login Page Title ");
        //  Verify page url
        Assert.assertEquals(GlobalVariables.driver.getCurrentUrl(),GlobalVariables.loginURL,"Incorrect Login Page url=");
        LoginPage login=new LoginPage();
        login.setEmail(GlobalVariables.userEmail);
        login.setPassword(GlobalVariables.password);
        login.clickLoginButton();
        accountPage AccountPage=new accountPage();
        // Verify User Name
        Assert.assertEquals(AccountPage.getUserName(),"Hi, Johny Smith","Incorrect User Name");
        //  Verify Current Day as format .Example 08 August 2018
        Assert.assertTrue(AccountPage.verifyFormatDate(),"Incorrect Format Date.");
        //  Verify Booking menu item is selected by default
        Assert.assertTrue(AccountPage.isBookingSelected(),"Booking is not selected");
        //  Verify Left Menu Labels
        Assert.assertTrue(AccountPage.menu.verifyLeftMenuBarLabel(),"Left Menu Labels are incorrect");
        //  Verify Left Menu icons
        Assert.assertTrue(AccountPage.menu.verifyMenuBarIcons(),"Left Menu Icons are incorrect");
    }

    @AfterTest
    public void afterTest() {
         commonFunctions.logOut();
    }
}
