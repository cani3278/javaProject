package Model;

import java.util.Date;
import java.util.Objects;

public class Order {
    public Order( Guest guest, Room room, int numDays) {
		super();
		//this.numOrder = numOrder;
		this.guest = guest;
		this.room = room;
		this.orderDate = orderDate;
		this.numDays = numDays;
	}
    
	private int  numOrder;
    private Guest guest;
    private Room room;
    private Date orderDate;
    private int numDays;

    public int getNumOrder() {
        return numOrder;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getNumDays() {
        return numDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getNumOrder() == order.getNumOrder() && getNumDays() == order.getNumDays() && Objects.equals(getGuest(), order.getGuest()) && Objects.equals(getRoom(), order.getRoom()) && Objects.equals(getOrderDate(), order.getOrderDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumOrder(), getGuest(), getRoom(), getOrderDate(), getNumDays());
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }
    public static int count=0;
    public Order( Guest guest, Room room, Date orderDate, int numDays) {
        this.numOrder = count++;
        this.guest = guest;
        this.room = room;
        this.orderDate = orderDate;
        this.numDays = numDays;
    }
    public int calcPrice(){
        if(guest instanceof BussinessGuest)
        return numDays*Room.getStartPrice()*BussinessGuest.getDiscountPercent()/100;
        return numDays*Room.getStartPrice();
    }
}
