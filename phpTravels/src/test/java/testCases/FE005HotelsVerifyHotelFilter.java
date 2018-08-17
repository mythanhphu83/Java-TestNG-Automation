package testCases;

import features.common.GlobalVariables;
import features.common.commonFunctions;
import features.pages.hotelsFunction;
import features.pages.resultsVerify;
import org.testng.annotations.Test;

public class FE005HotelsVerifyHotelFilter {
    @Test
    public void FE005(){
        //      Login to the page
        commonFunctions.login();
        commonFunctions.gotoURL(GlobalVariables.hotelURL);

//      Filter Search
        hotelsFunction tourF = new hotelsFunction();
        String type [] = {"Hotel", "Villa"};
        String amenities [] = {"Night Club", "Restaurant"};
        tourF.filterSearchByHotels(4, 0, 40,type,amenities);
//      Verify Tour Type of each Hotels is 'Holidays'
        resultsVerify results = new resultsVerify();
        results.verifyStarGrade(4);

//      Logout
        commonFunctions.logOut();
    }
}
