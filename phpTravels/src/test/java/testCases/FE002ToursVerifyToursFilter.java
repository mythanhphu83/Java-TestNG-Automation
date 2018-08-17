package testCases;
import features.common.GlobalVariables;
import features.common.commonFunctions;
import features.pages.*;
import org.testng.annotations.Test;

public class FE002ToursVerifyToursFilter extends GlobalVariables {
    @Test
    public void test(){

//      Login to the page
        commonFunctions.login();
        commonFunctions.gotoURL(GlobalVariables.tourURL);

//      Filter Search
        toursFunction tourF = new toursFunction();
        tourF.filterSearchByTours(3,60,500,"Holidays");
//      Verify Tour Type of each Hotels is 'Holidays'
        resultsVerify results = new resultsVerify();
        results.verifyTourType("Holidays");
        //      Logout
        commonFunctions.logOut();
    }
}
