package DAO;

import Model.Guest;
import Model.Order;
import Model.Room;

import java.util.ArrayList;
import java.util.List;

public class ListOrder {
  private   ArrayList <Order> arrayOrder;


//create
 public void addOrder(Order o){
        arrayOrder.add(o);
 }
 
 //read
 public  ArrayList<Order> readOrders() {
     return new ArrayList<Order>(arrayOrder) ;
 }
 
 //update
 public void updateOrder(Order o) {
	 Order old=arrayOrder.stream().filter(item->item.getNumOrder()==o.getNumOrder()).toList().get(0);
	 arrayOrder.remove(old);
	 arrayOrder.add(o);	 
	 
 }
 
 //delete
 public int deleteOrder(Order o) {
	 arrayOrder.remove(o);
	 return o.getRoom().getNumRoom();
	 
 }
 public int delete(Guest g) {
	 Order o=findByGuest(g).get(0);
	 return deleteOrder(o);
 }
 
 //findByGuest--------------------------1 or list?
 public List<Order> findByGuest(Guest g){
	 return arrayOrder.stream().filter(o->o.getGuest().equals(g)).toList();
 }
 
 //findByRoom
 public List<Order> findByRoom(Room r){
	 return arrayOrder.stream().filter(o->o.getRoom().equals(r)).toList();
 }
}

