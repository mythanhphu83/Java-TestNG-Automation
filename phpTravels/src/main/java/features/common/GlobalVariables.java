package features.common;

import org.openqa.selenium.WebDriver;

public class GlobalVariables {
    public static WebDriver driver;
    public static long longSleepTime=30000;
    public static long shortSleepTime=5000;
    public static String userEmail="user@phptravels.com";
    public static String password="demouser";
    public static String phpTravelURL="https://www.phptravels.net/";
    public static String loginURL= phpTravelURL+"login";
    public static String tourURL= phpTravelURL+"tours";
    public static String hotelURL= phpTravelURL+"hotels";
    public static String carsURL=phpTravelURL+"cars";
    public static String visaURL= phpTravelURL+"ivisa";
    public static String offersURL= phpTravelURL+"offers";
    public static String blogURL= phpTravelURL+"blog";
    public static String flightsURL= phpTravelURL+"flights";
}
