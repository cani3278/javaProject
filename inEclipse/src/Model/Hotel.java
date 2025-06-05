package Model;

import DAO.ListGuest;
import DAO.ListOrder;
import DAO.ListRoom;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Hotel {
	private static Hotel instance = null;
    private  String name;
    private String address;
    private  String phone;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Order>orders;
    private ListRoom listRoom;
    private ListOrder listOrder;
    private ListGuest listGuest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel hotel)) return false;
        return Objects.equals(getName(), hotel.getName()) && Objects.equals(getAddress(), hotel.getAddress()) && Objects.equals(getPhone(), hotel.getPhone()) && Objects.equals(getRooms(), hotel.getRooms()) && Objects.equals(getGuests(), hotel.getGuests()) && Objects.equals(getOrders(), hotel.getOrders()) && Objects.equals(listRoom, hotel.listRoom) && Objects.equals(listOrder, hotel.listOrder) && Objects.equals(listGuest, hotel.listGuest);
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getPhone(), getRooms(), getGuests(), getOrders(), listRoom, listOrder, listGuest);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ListRoom getRooms() {
        return listRoom;
    }

    public ListGuest getGuests() {
        return listGuest;
    }

    public ListOrder getOrders() {
        return listOrder;
    }

    public String showHotelDetails() {
       return  "שם המלון: " +getName() +
                "\nכתובת: " +getAddress() + "\nטלפון: " +getPhone();
    }
    public Hotel(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public static Hotel getInstance() {
        if(instance == null)
            instance = new Hotel("Miri & Chani & tzippy","Yirmihu 24", "025380187");
        return instance;
    }
}
