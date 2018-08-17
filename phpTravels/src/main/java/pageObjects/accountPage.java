package pageObjects;

public class accountPage {
    private String sUserName="//h3[@class='RTL']";
    private String sDate="//div[@class='go-left']//*[@class='h4']";
    private String sTitle="//title";
    public leftMenu menu=new leftMenu();

    public String getBookingStatus()
    {
        String isSelected;
        isSelected = menu.menuBookings.getAttribute("aria-expanded");
        System.out.println("STATUS OF BOOKING MENU ="+isSelected);

        if (isSelected=="true")
            System.out.println("TRUEEEEEEE");
        else
            System.out.println("FALSE");
        return isSelected;
    }


}
