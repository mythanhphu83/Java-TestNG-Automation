package features;

import pageObjects.accountPage;

public class account {
    private accountPage  page=new accountPage();

    public String getBookingStatus()
    {
       String isSelected;
        isSelected = page.menu.menuBookings.getAttribute("aria-expanded");
        System.out.println("STATUS OF BOOKING MENU ="+isSelected);

        if (isSelected=="true")
           System.out.println("TRUEEEEEEE");
        else
            System.out.println("FALSE");
return isSelected;
    }

}
