package BL;

import Model.Guest;
import Model.Hotel;
import Model.Order;
import Model.Room;

import java.util.Date;

public class BL {
    private Hotel myHotel;

    //add Order:
    public void addOrder(Guest g, Room r, Date d, int numOfDays){
        Order newOrder= new Order(g,r,d,numOfDays);
        myHotel.getOrders().AddOrder(newOrder);
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



}
