package DAO;

import Model.Order;

import java.util.ArrayList;

public class ListOrder {
  private   ArrayList <Order> arrayOrder;

    public ArrayList<Order> getArrayOrder() {
        return arrayOrder;
    }

 public void AddOrder(Order o){
        arrayOrder.add(o);
 }
}

