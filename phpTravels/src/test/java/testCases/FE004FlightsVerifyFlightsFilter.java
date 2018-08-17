package testCases;

import features.common.GlobalVariables;
import features.common.commonFunctions;
import features.pages.flightsFunction;
import features.pages.resultsVerify;
import org.testng.annotations.Test;

public class FE004FlightsVerifyFlightsFilter {
    @Test
    public void FE004(){
        //      Login to the page
        commonFunctions.login();
        commonFunctions.gotoURL(GlobalVariables.flightsURL);

//      Filter Search
        flightsFunction tourF = new flightsFunction();
        String filter [] = {"Emirates"};
        tourF.filterSearchByFlights(filter,"NonStop");
//      Verify Tour Type of each Hotels is 'Holidays'
        resultsVerify results = new resultsVerify();
        results.verifyAirlineNameList();

//      Logout
        commonFunctions.logOut();
    }
}
