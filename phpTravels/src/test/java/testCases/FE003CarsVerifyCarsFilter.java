package testCases;

import features.common.GlobalVariables;
import features.common.commonFunctions;
import features.pages.resultsVerify;
import features.pages.carsFunction;
import org.testng.annotations.Test;

public class FE003CarsVerifyCarsFilter {
    @Test
    public void FE003(){
        //      Login to the page
        commonFunctions.login();
        commonFunctions.gotoURL(GlobalVariables.carsURL);

//      Filter Search
        carsFunction tourF = new carsFunction();
        tourF.filterSearchByCars(4, 0, 0, "", "Yes");
//      Verify Tour Type of each Hotels is 'Holidays'
        resultsVerify results = new resultsVerify();
        results.verifyAirportPickup(true);
//      Logout
        commonFunctions.logOut();
    }
}
