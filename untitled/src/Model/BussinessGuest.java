package Model;

public class BussinessGuest extends Guest {

  private String BussinessGuestCode;
  private static int discountPercent;
//getters and setters
    public String getBussinessGuestCode() {
        return BussinessGuestCode;
    }

    public void setBussinessGuestCode(String bussinessGuestCode) {
        BussinessGuestCode = bussinessGuestCode;
    }

    public static int getDiscountPercent() {
        return discountPercent;
    }

    public static void setDiscountPercent(int discountPercent) {
        BussinessGuest.discountPercent = discountPercent;
    }
//c-tors
    public BussinessGuest(Person personalDetails, int numVisit, String bussinessGuestCode) {
        super(personalDetails, numVisit);
        BussinessGuestCode = bussinessGuestCode;
    }

    public BussinessGuest(Person personalDetails, int numVisit) {
        super(personalDetails, numVisit);
    }
}
