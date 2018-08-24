package testCases;

import features.common.commonFunctions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.BookingPage;
import pageObjects.InvoicePage;

import java.util.*;

public class FE010BookingVerifyInvoiceBookingDetails {
    @BeforeTest
    public void beforeTest() {
         commonFunctions.login();
    }
    @Test
    public void test() {
        System.out.println("********* TEST CASE:FE10 Booking Verify Invoice Booking Details********* ");
        BookingPage bookingPage = new BookingPage();
        // get random Row index
       int rowIndex=commonFunctions.generateRandomIntergerNumber(1, bookingPage.getTotalRows());
        // Get Booking Info on Booking Landing page
        List<String> bookingData=bookingPage.getBookingDataOnLandingPageByRowIndex(rowIndex);
        // CLick Invoice button on Booking page
        bookingPage.clickInvoiceButtonByRowIndex(rowIndex);
        // Switch to new window opened
       commonFunctions.swithToNewOpenedWindow();
       InvoicePage invoicePage=new InvoicePage();
       //Verify Invoice page title
       Assert.assertEquals(invoicePage.pageTitle.getAttribute("innerText"),"Invoice","Invoice page title is incorrect");
       // Get invoice data
        List <String> invoiceData=invoicePage.getInvoiceInfo();
       Assert.assertEquals(bookingData, invoiceData,"Mismatch data between Booking Landing page and Detail Invoice page.");

    }

    @AfterTest
    public void afterTest() {
          commonFunctions.logOut();
    }
}
