package BL;

import Model.Guest;
import Model.Hotel;
import Model.Order;
import Model.Room;

import java.io.Console;
import java.util.Date;

import DAO.ListGuest;
import DAO.ListOrder;
import DAO.ListRoom;

public class BL {
    private Hotel myHotel=Hotel.getInstance();

    //add Order:
    public void addOrder(Guest g, Room r, Date d, int numOfDays){
        Order newOrder= new Order(g,r,d,numOfDays);
        myHotel.getOrders().addOrder(newOrder);
    }

    //find room
    public Room findRoomByLevel(int level){
      return  (Room)myHotel.getRooms().getArrayRoom().stream().filter(x->x.getLevel()==level&&!x.isActive());
    }
    //update guestList
    public void updateGuestList(Guest guest){
     Guest oldGuest= (Guest) myHotel.getGuests().getArrayGuest().stream().filter(g->g.equals(guest));
     if(oldGuest==null)
         myHotel.getGuests().addGuest(guest);
     else oldGuest.setNumVisit(oldGuest.getNumVisit()+1);
    }
    //menu context
    public void menu(Guest g) {
    	System.out.println("להדפסת פרטי המלון הקש 1 להוספת הזמנה הקש 2 למחיקת הזמנה הקש 3 להדפסת הזמנות הקש 4 להדפסת דוח מצב החדרים הקש 5 להדפסת פרטי הלקוחות הקש 6");
//    	int x
    }
    public ListRoom getRooms() {
        return myHotel.getRooms() ;
    }

    public ListGuest getGuests() {
    	return myHotel.getGuests() ;
    }

    public ListOrder getOrders() {
    	return myHotel.getOrders() ;
    }
    
	public String showHotelDetails() {
		return myHotel.showHotelDetails();
	}


}
